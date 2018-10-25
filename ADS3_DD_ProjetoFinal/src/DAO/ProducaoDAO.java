package src.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.VO.Filme;

public class ProducaoDAO  extends BaseDAO<Filme> {

	@Override
	public String getColunasDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColunaPrimaria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValoresEntidadesUpdate(Filme entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInterrogacoesInsert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNomeTabela() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filme construirObjetoConsultado(ResultSet resultado) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValoresAtributosInsert(Filme entidade, PreparedStatement prepareStm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValoresAtributosUpdate(Filme entidade, PreparedStatement stmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getColunasInsert() {
		// TODO Auto-generated method stub
		return null;
	}

}
