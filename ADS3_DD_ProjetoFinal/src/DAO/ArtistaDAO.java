package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import VO.Artista;
import VO.Filme;
import VO.Producao;
import VO.Usuario;

public class ArtistaDAO extends BaseDAO<Artista>{

	@Override
	public String getColunasDelete() {
		return " idArtista ";
	}

	@Override
	public String getColunaPrimaria() {
		return " idArtista ";
	}

	@Override
	public String getValoresEntidadesUpdate(Artista entidade) {
		String clausulaSet = " idArtista = ?, nome = ? , dataNascimento = ? ";
		return clausulaSet;
	}

	@Override
	public String getInterrogacoesInsert() {
		return " ?, ? ";
	}

	@Override
	public String getNomeTabela() {
		return " artista ";
	}

	@Override
	public Artista construirObjetoConsultado(ResultSet resultado) throws SQLException {
		Artista artista = new Artista();
		artista.setIdArtista(resultado.getInt("idArtista"));		
		artista.setNome(resultado.getString("nome"));
		artista.setDtNascimento(resultado.getDate("dataNascimento"));		
		return artista;
	}

	@Override
	public void setValoresAtributosInsert(Artista entidade, PreparedStatement prepareStm) {
		try {
			
			prepareStm.setString(1, entidade.getNome());
			prepareStm.setDate(2, entidade.getDtNascimento());
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void setValoresAtributosUpdate(Artista entidade, PreparedStatement stmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getColunasInsert() {
		return " nome, dataNascimento ";
	}
	
	public ArrayList<Artista> buscaArtistasPorProducao(Producao producao) {
		String sql = (" SELECT T0.idArtista, T1.nome FROM producaoArtista T0 INNER JOIN artista T1 on T0.idArtista = T1.idArtista where T0.idProducao = " + producao.getIdProducao());
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		ArrayList<Artista> listArtistas = new ArrayList<>();
		
		try {
			resultado = stmt.executeQuery(sql);
			while(resultado.next()) {
				listArtistas.add(construirObjetoConsultado(resultado));
			}
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		
		return listArtistas;
	}

}
