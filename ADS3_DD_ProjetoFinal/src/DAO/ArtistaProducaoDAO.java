package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import VO.Artista;
import VO.ArtistaProducao;
import VO.Producao;
import controller.ArtistaProducaoController;

public class ArtistaProducaoDAO extends BaseDAO<ArtistaProducao> {

	@Override
	public String getColunasDelete() {
		return " idProducaoArtista ";
	}

	@Override
	public String getColunaPrimaria() {
		return " idProducaoArtista ";
	}

	@Override
	public String getValoresEntidadesUpdate(ArtistaProducao entidade) {
		return "";
	}

	@Override
	public String getInterrogacoesInsert() {
		return " ?, ? ";
	}

	@Override
	public String getNomeTabela() {
		return " producaoArtista ";
	}

	@Override
	public ArtistaProducao construirObjetoConsultado(ResultSet resultado) throws SQLException {
		ArtistaProducao artistaProducao = new ArtistaProducao();
		artistaProducao.setIdArtista(resultado.getInt("idArtista"));
		artistaProducao.setIdProducao(resultado.getInt("idProducao"));
		return artistaProducao;
	}

	@Override
	public void setValoresAtributosInsert(ArtistaProducao entidade, PreparedStatement prepareStm) {
		try {

			prepareStm.setInt(1, entidade.getIdProducao());
			prepareStm.setInt(2, entidade.getIdArtista());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setValoresAtributosUpdate(ArtistaProducao entidade, PreparedStatement stmt) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getColunasInsert() {
		return " idProducao, idArtista ";
	}

	public void ArtistasUpdate(Producao producao) {
		try {
			
			ArtistasDelete(producao);
			ArtistasAdd(producao);
		} catch (SQLException e) {
			System.out.println("Erro " + e.getMessage());
		} finally {
			
		}
		
		
	}

	private void ArtistasDelete(Producao producao) {
		String sql = (" DELETE FROM producaoartista WHERE idProducao= "+ producao.getIdProducao());
		
		Connection conn = Banco.getConnection();
		PreparedStatement prepareStm = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);		
		try {			
			prepareStm.executeUpdate();			
		} catch (SQLException e) {
			System.out.println("Erro " + e.getMessage());
		} finally {
			Banco.closeStatement(prepareStm);
			Banco.closeConnection(conn);
		}
	}
	
	private void ArtistasAdd(Producao producao) throws SQLException {
		
		ArtistaProducaoController controle = new ArtistaProducaoController();

		for (Artista artista : producao.getArtistas()) {

			ArtistaProducao ap = new ArtistaProducao();

			ap.setIdArtista(artista.getIdArtista());
			ap.setIdProducao(producao.getIdProducao());

			controle.salvar(ap);
		}
	}	


}
