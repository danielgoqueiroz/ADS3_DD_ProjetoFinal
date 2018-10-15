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
		
		return "";
	}
}