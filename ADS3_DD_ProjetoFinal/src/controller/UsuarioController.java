package controller;

import java.sql.SQLException;

import BO.UsuarioBO;
import VO.Usuario;

public class UsuarioController {

	private UsuarioBO bo = new UsuarioBO();

	public String salvar(Usuario usuario) throws SQLException {
		String validacao = validarFuncioanrio(usuario);

		if (validacao == "") {
			if (usuario.getIdUsuario() > 0) {
			} else {
				if (bo.inserir(usuario)) {
					validacao = "Usuário cadastrado com sucesso";
				} else {
					validacao = "Erro ao cadastrar usuário";
				}
			}
		}
		return validacao;
	}

	private String validarFuncioanrio(Usuario usuario) {
		if (usuario.getNome().equals("")) {
		}
		if (usuario.getEmail().equals("")) {
		}
		if (usuario.getNickname().equals("")) {
		}
		if (usuario.getSenha().equals("")) {
		}
		if (usuario.getTelefone().equals("")) {
		}
		return "";
	}

	public Usuario verificaNickUsuario(String nick) {
		UsuarioBO bo = new UsuarioBO();
		return bo.verificaNickName(nick);
	}

	public Usuario realizaLogin(Usuario usuario) {
		UsuarioBO bo = new UsuarioBO();
		return bo.realizarLogin(usuario);

	}

	public Usuario verificaEmailUsuario(String email) {
		UsuarioBO bo = new UsuarioBO();
		return bo.verificaEmailUsuario(email);
	}
}