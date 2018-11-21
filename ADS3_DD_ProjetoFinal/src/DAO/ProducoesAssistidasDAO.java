package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import VO.Artista;
import VO.ArtistaProducao;
import VO.Producao;
import VO.ProducoesAssistidas;
import VO.Usuario;
import controller.ArtistaProducaoController;

public class ProducoesAssistidasDAO extends BaseDAO<ProducoesAssistidas> {

	public void cadastrarProducaoAssistidas(ProducoesAssistidas producaoAssitida) {

	}

	@Override
	public String getColunasDelete() {

		return "idproducao";
	}

	@Override
	public String getColunaPrimaria() {

		return "idproducoesAssistidas";
	}

	@Override
	public String getInterrogacoesInsert() {

		return " ?, ?, ? ";
	}

	@Override
	public String getNomeTabela() {

		return "producoesAssistidas";
	}

	@Override
	public String getColunasInsert() {

		return " idUsuario, idProducao, nota ";
	}

	@Override
	public String getValoresEntidadesUpdate(ProducoesAssistidas entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProducoesAssistidas construirObjetoConsultado(ResultSet resultado) throws SQLException {
		Producao producao = new Producao();
		Usuario usuario = new Usuario();
		ProducoesAssistidas producaoAssistida = new ProducoesAssistidas();

		producao.setIdProducao(resultado.getInt("idProducao"));
		usuario.setIdUsuario(resultado.getInt("idUsuario"));

		producaoAssistida.setNota(resultado.getInt("nota"));
		producaoAssistida.setProducao(producao);
		producaoAssistida.setUsuario(usuario);

		return producaoAssistida;

	}

	@Override
	public void setValoresAtributosInsert(ProducoesAssistidas entidade, PreparedStatement prepareStm) {
		try {

			prepareStm.setInt(1, entidade.getUsuario().getIdUsuario());
			prepareStm.setInt(2, entidade.getProducao().getIdProducao());
			prepareStm.setInt(3, entidade.getNota());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setValoresAtributosUpdate(ProducoesAssistidas entidade, PreparedStatement stmt) {
		// TODO Auto-generated method stub

	}
	
	public void ArtistasUpdate(Producao producao) throws SQLException {
		ArtistasDelete(producao);
		ArtistasAdd(producao);
	}

	private void ArtistasDelete(Producao producao) {
		String sql = (" DELETE FROM producaoartista WHERE idProducao= "+ producao.getIdProducao());
		
		Connection conn = Banco.getConnection();
		PreparedStatement prepareStm = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);
		int idEntidade = -1;
		
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
