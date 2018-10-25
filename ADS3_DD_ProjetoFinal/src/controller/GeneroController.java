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
				//					validacao = "Usuário atualizado com sucesso";
				//				} else {
				//					validacao = "Erro au atualizar o usuário";
				//				}
			} else {
				if (bo.inserir(genero) > 0) {
					validacao = "Gênero cadastrado com sucesso";
				} else {
					validacao = "Erro ao cadastrar gênero";
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
