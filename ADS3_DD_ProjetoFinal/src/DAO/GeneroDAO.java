package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import VO.Filme;
import VO.Genero;

public class GeneroDAO extends BaseDAO<Genero>{


	@Override
	public String getColunasDelete() {
		// TODO Auto-generated method stub
		return " idGenero ";
	}

	@Override
	public String getColunaPrimaria() {
		// TODO Auto-generated method stub
		return " idGenero ";
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
		return " genero ";
	}

	@Override
	public Genero construirObjetoConsultado(ResultSet resultado) throws SQLException {
		Genero genero = new Genero();
		genero.setIdGenero(resultado.getInt("idGenero"));
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
		return " descricao ";
	}

}
