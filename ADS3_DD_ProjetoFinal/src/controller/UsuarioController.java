package controller;

import java.sql.SQLException;

import BO.UsuarioBO;
import VO.Usuario;

public class UsuarioController {

	private UsuarioBO bo = new UsuarioBO();

	public String salvar(Usuario usuario) throws SQLException {
		String validacao = validarUsuario(usuario);

		if (validacao == "") {
			if (usuario.getIdUsuario() > 0) {
				
				if (bo.atualizar(usuario)) {					
					validacao = "Usuário atualizado com sucesso!";
				}
			} else {
				if (bo.inserir(usuario)) {
					validacao = "Usuário cadastrado com sucesso!";
				} else {
					validacao = "Erro ao cadastrar usuário";
				}
			}
		}else {
			validacao = "Necessário preencher os seguintes campos: \n" + validacao;
		}
		return validacao;
	}

	private String validarUsuario(Usuario usuario) {
		String msg = "";		
		
		if (usuario.getNome().equals("")) {
			msg += " Nome \n";
		}
		if (usuario.getEmail().equals("")) {
			msg += " E-mail \n";
		}
		if (usuario.getNickname().equals("")) {
			msg += " Nickname \n";
		}
		if (usuario.getSenha().equals("")) {
			msg += " Senha \n";
		}
		if (usuario.getTelefone().equals("")) {
			msg += " Telefone \n";
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