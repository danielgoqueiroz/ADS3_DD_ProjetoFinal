package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import VO.ArtistaProducao;

public class ArtistaProducaoDAO extends BaseDAO<ArtistaProducao>{

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
		return " nome, dataNascimento ";
	}
}
