package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import BO.GeneroBO;
import VO.Genero;

public class GeneroController {

	GeneroBO bo = new GeneroBO();
	
	public String salvar(Genero genero) throws SQLException {
		String validacao = validarGenero(genero);

		if (validacao == "") {
			if (genero.getIdGenero() > 0) {

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
	
	public ArrayList<Genero> listarTodos() {
		return bo.listarTodos();
	}

	private String validarGenero(Genero genero) {
		String msg = "";
		if (bo.buscaGeneroPorNome(genero.getDescricao()) != null) {
			msg += "-Genero já cadastrado\n";
		};
		return "";
	}

	public Genero buscaGeneroPorNome(String string) {
		return bo.buscaGeneroPorNome(string);
		
	}

}
