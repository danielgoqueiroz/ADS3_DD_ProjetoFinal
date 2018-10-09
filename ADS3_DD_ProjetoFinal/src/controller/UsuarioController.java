package controller;

import java.sql.SQLException;

import BO.UsuarioBO;
import VO.Usuario;

public class UsuarioController {

	UsuarioBO bo = new UsuarioBO();
	
	public String salvar(Usuario usuario) throws SQLException {
		String validacao = validarFuncioanrio(usuario);
		
		if (validacao == "") {
			if (usuario.getIdusuario() > 0) {
				//ATUALIZAR
//				if (bo.atualizar(usuario)) {
//					validacao = "Usu�rio atualizado com sucesso";
//				} else {
//					validacao = "Erro au atualizar o usu�rio";
//				}
			
			} else {
				 if (bo.inserir(usuario)) {
					 validacao = "Usu�rio cadastrado com sucesso";
				 } else {
					 validacao = "Erro ao cadastrar usu�rio";
				 }
			}
			
			
		}
		return validacao;
	}
		
		private String validarFuncioanrio(Usuario usuario) {
			
			return "";
		}
}

	