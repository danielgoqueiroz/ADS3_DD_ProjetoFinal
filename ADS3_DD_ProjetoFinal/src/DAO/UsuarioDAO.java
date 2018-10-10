package src.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.VO.Usuario;

public class UsuarioDAO extends BaseDAO<Usuario> {

	@Override
	public String getColunasDelete() {
		// TODO Auto-generated method stub
		return " idusuario ";
	}

	@Override
	public String getColunaPrimaria() {
		// TODO Auto-generated method stub
		return " idusuario ";
	}

	
	@Override
	public String getInterrogacoesInsert() {
		// TODO Auto-generated method stub
		return " ?,?,?,?,? ";
	}

	@Override
	public String getNomeTabela() {
		// TODO Auto-generated method stub
		return " USUARIO ";
	}
	
	@Override
	public String getColunasInsert() {
		return " nome, nickname, email, telefone, senha ";
	}


	
	

	public Usuario buscaUsuarioPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public String getValoresEntidadesUpdate(Usuario entidade) {
		String clausulaSet = (" idusuario = ?, nickname = ? , email = ?, senha = ? ");
		return clausulaSet;
	}

	@Override
	public void setValoresAtributosInsert(Usuario entidade, PreparedStatement prepareStm) {
		try {
			prepareStm.setString(1, entidade.getNome() + "");
			prepareStm.setString(2, entidade.getNickname() + "");
			prepareStm.setString(3, entidade.getEmail() + "");
			prepareStm.setString(4, entidade.getTelefone() + "");
			prepareStm.setString(5, entidade.getSenha() + "");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void setValoresAtributosUpdate(Usuario entidade, PreparedStatement stmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario construirObjetoConsultado(ResultSet resultado) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
