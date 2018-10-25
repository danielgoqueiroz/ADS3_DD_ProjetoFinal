package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import VO.Artista;

public class ArtistaDAO extends BaseDAO<Artista>{

	@Override
	public String getColunasDelete() {
		return " idartista ";
	}

	@Override
	public String getColunaPrimaria() {
		return " idartista ";
	}

	@Override
	public String getValoresEntidadesUpdate(Artista entidade) {
		String clausulaSet = " idartista = ?, nome = ? , dt_nascimento = ? ";
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
		artista.setIdArtista(resultado.getInt("idartista"));		
		artista.setNome(resultado.getString("nome"));
		artista.setDtNascimento(resultado.getDate("dt_nascimento"));		
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
		return " nome, dt_nascimento ";
	}

}
