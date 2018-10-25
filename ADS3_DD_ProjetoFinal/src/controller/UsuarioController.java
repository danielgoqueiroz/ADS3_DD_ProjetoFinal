package src.controller;

import java.sql.SQLException;

import src.BO.UsuarioBO;
import src.VO.Usuario;

public class UsuarioController {

	private UsuarioBO bo = new UsuarioBO();

	public String salvar(Usuario usuario) throws SQLException {
		String validacao = validarFuncioanrio(usuario);
		
		if (validacao == "") {
			if (usuario.getIdUsuario() > 0) {
				//ATUALIZAR
				//				if (bo.atualizar(usuario)) {
				//					validacao = "Usuário atualizado com sucesso";
				//				} else {
				//					validacao = "Erro au atualizar o usuário";
				//				}
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
		String msg = "";
		if (usuario.getNome().equals("")) {
			msg+="Campo NOME vazio.\n";
		}
		if (usuario.getEmail().equals("")) {
			msg+="Campo EMAIL vazio.\n";
		}
		if (usuario.getNickname().equals("")) {
			msg+="Campo NICKNAME vazio.\n";
		}
		if (usuario.getSenha().equals("")) {
			msg+="Campo SENHA vazio.\n";
		}
		if (usuario.getTelefone().equals("")) {
			msg+="Campo TELEFONE vazio.\n";
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