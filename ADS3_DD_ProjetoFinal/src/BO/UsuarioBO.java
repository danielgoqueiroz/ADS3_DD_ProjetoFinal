package BO;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.UsuarioDAO;
import VO.Usuario;



public class UsuarioBO {

	UsuarioDAO dao = new UsuarioDAO();
	
	public boolean inserir(Usuario usuario) throws SQLException {
		int idGerado = dao.inserir(usuario);
		return idGerado > 0;
	}
	
	public Usuario buscarUsuarioPorNome(String nome) {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario Usuario = dao.buscaUsuarioPorNome(nome);
		return Usuario;
	}

	public boolean atualizar(Usuario usuario) throws SQLException {
		boolean sucesso = dao.atualizar(usuario, usuario.getIdusuario());
		return sucesso;
	}
	

	public ArrayList<Usuario> listarUsuarios() {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.listarTodos();
	}

	
	public boolean excluirUsuario(int idUsuario) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.excluir(idUsuario);
	}
}
