package controller;

import java.sql.SQLException;

import BO.GeneroBO;
import VO.Genero;

public class GeneroController {

	GeneroBO bo = new GeneroBO();
	
	public String salvar(Genero genero) throws SQLException {
		String validacao = validarGenero(genero);

		if (validacao == "") {
			if (genero.getIdGenero() > 0) {
				//ATUALIZAR
				//				if (bo.atualizar(usuario)) {
				//					validacao = "Usu�rio atualizado com sucesso";
				//				} else {
				//					validacao = "Erro au atualizar o usu�rio";
				//				}
			} else {
				if (bo.inserir(genero) > 0) {
					validacao = "G�nero cadastrado com sucesso";
				} else {
					validacao = "Erro ao cadastrar g�nero";
				}
			}
		}
		return validacao;
	}

	private String validarGenero(Genero genero) {
		// TODO Auto-generated method stub
		return "";
	}

}
