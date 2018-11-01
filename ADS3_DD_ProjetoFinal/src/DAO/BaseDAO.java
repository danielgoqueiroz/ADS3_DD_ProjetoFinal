package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public abstract class BaseDAO<T> {

	private static final int CODIGO_RETORNO_SQL = 1;
	
	public int inserir(T entidade) {
		String sql = (" INSERT INTO " + getNomeTabela() + " ( " + getColunasInsert() + " ) VALUES ( " + getInterrogacoesInsert() + " ) ");
		
		Connection conn = Banco.getConnection();
		PreparedStatement prepareStm = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);
		int idEntidade = -1;
		
		try {
			this.setValoresAtributosInsert(entidade, prepareStm);
			prepareStm.executeUpdate();
			ResultSet rs = prepareStm.getGeneratedKeys();
			
			if(rs.next()) {
				idEntidade = rs.getInt(1);
			} 
			
		} catch (SQLException e) {
			System.out.println("Erro " + e.getMessage());
		} finally {
			Banco.closeStatement(prepareStm);
			Banco.closeConnection(conn);
		}
		
		return idEntidade;
	}
	
	public boolean atualizar(T entidade, int idEntidade){
		String sql = (" UPDATE " + getNomeTabela() + " SET " + getValoresEntidadesUpdate(entidade) + " WHERE " + getColunaPrimaria() + " = " + idEntidade );
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		boolean sucessoUpdate = false;
		
		try {
			this.setValoresAtributosInsert(entidade, stmt);
			int retorno = stmt.executeUpdate();
			sucessoUpdate = (retorno == CODIGO_RETORNO_SQL);
		}catch (SQLException e) {
			System.out.println("Deu ruim: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		
		return sucessoUpdate;
	}

	public boolean excluir(int idEntidade) {
		String sql = ("DELETE FROM " + getNomeTabela() + " WHERE " + getColunasDelete() + " = " + idEntidade);
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		boolean sucessoDelete = false;
		
		try {
			int resultado = stmt.executeUpdate(sql);
			sucessoDelete = (resultado == CODIGO_RETORNO_SQL);
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return sucessoDelete;
	}
	
	public T pesquisaPorId (int idEntidade){
		String sql = ("SELECT * FROM" + getNomeTabela() + " WHERE " + getColunaPrimaria() + " = " + idEntidade);
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		T objetoPesquisado = null;
		
		try {
			resultado = stmt.executeQuery(sql);
			while(resultado.next()) {
				objetoPesquisado = construirObjetoConsultado(resultado);
			}
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		
		return objetoPesquisado;
	}
	
	public ArrayList<T> listarTodos() {
		String sql = ("SELECT * FROM  " + getNomeTabela());
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		
		ArrayList<T> listaObjetos = new ArrayList<>();
		try {
			resultado = stmt.executeQuery();
			while (resultado.next()){
				T objeto = construirObjetoConsultado(resultado);
				listaObjetos.add(objeto);
			}
		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaObjetos;
	}

	public abstract String getColunasDelete();
	
	public abstract String getColunaPrimaria();
	
	public abstract String getValoresEntidadesUpdate(T entidade);
	
	public abstract String getInterrogacoesInsert();
	
	public abstract String getNomeTabela();		

	public abstract T construirObjetoConsultado(ResultSet resultado) throws SQLException;

	public abstract void setValoresAtributosInsert(T entidade, PreparedStatement prepareStm);
	
	public abstract void setValoresAtributosUpdate(T entidade, PreparedStatement stmt);
	
	public abstract String getColunasInsert();

	public String getColunaInsert() {
		// TODO Auto-generated method stub
		return null;
	}
}
