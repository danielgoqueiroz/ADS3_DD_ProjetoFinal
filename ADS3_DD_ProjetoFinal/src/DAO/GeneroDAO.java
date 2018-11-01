package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import VO.Filme;
import VO.Genero;
import VO.Producao;

public class GeneroDAO extends BaseDAO<Genero>{


	@Override
	public String getColunasDelete() {
		// TODO Auto-generated method stub
		return " idgenero ";
	}

	@Override
	public String getColunaPrimaria() {
		// TODO Auto-generated method stub
		return " idgenero ";
	}

	@Override
	public String getValoresEntidadesUpdate(Genero entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInterrogacoesInsert() {
		// TODO Auto-generated method stub
		return " ? ";
	}

	@Override
	public String getNomeTabela() {
		// TODO Auto-generated method stub
		return "genero";
	}

	@Override
	public Genero construirObjetoConsultado(ResultSet resultado) throws SQLException {
		Genero genero = new Genero();
		genero.setIdGenero(resultado.getInt("idgenero"));
		genero.setDescricao(resultado.getString("descricao"));
		
		return genero;
	}

	@Override
	public void setValoresAtributosInsert(Genero entidade, PreparedStatement prepareStm) {
		try {
			prepareStm.setString(1, entidade.getDescricao() + "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setValoresAtributosUpdate(Genero entidade, PreparedStatement stmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getColunasInsert() {
		// TODO Auto-generated method stub
		return "descricao";
	}

	public Genero pesquisaPorDescricao(String string) {
		String sql = (" SELECT * from genero where descricao = '" + string+"';");
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Genero objetoPesquisado = null;

		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				objetoPesquisado = construirObjetoConsultado(resultado);
			}
		} catch (Exception e) {
			System.out.println("Erro pesquisa desrição " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}

		return objetoPesquisado;
	}

	public Genero pesquisaPorId(int n) {
		String sql = (" SELECT * from genero where idgenero = " + n + " ");
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Genero objetoPesquisado = null;

		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				objetoPesquisado = construirObjetoConsultado(resultado);
			}
		} catch (Exception e) {
			System.out.println("Erro pesquisa id" + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}

		return objetoPesquisado;
	}

}
