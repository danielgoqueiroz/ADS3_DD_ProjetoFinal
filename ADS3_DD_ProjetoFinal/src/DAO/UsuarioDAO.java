package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import VO.Usuario;

public class UsuarioDAO extends BaseDAO {

	@Override
	public String getColunasDelete() {
		// TODO Auto-generated method stub
		return "idusuario";
	}

	@Override
	public String getColunaPrimaria() {
		// TODO Auto-generated method stub
		return "idusuario";
	}

	@Override
	public String getValoresEntidadesUpdate(Object entidade) {
		String clausulaSet = (" idusuario = ?, nickname = ? , email = ?, senha = ?");
		return clausulaSet;
	}

	@Override
	public String getInterrogacoesInsert() {
		// TODO Auto-generated method stub
		return "?,?,?,?";
	}

	@Override
	public String getNomeTabela() {
		// TODO Auto-generated method stub
		return "USUARIO";
	}
	
	@Override
	public String getColunasInsert() {
		// TODO Auto-generated method stub
		return "idusuario , nickname, email, senha";
	}


	@Override
	public Object construirObjetoConsultado(ResultSet resultado) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValoresAtributosInsert(Object entidade, PreparedStatement prepareStm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValoresAtributosUpdate(Object entidade, PreparedStatement stmt) {
		// TODO Auto-generated method stub
		
	}

	public Usuario buscaUsuarioPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
