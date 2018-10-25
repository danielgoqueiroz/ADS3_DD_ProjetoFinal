package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import BO.ArtistaBO;
import VO.Artista;

public class ArtistaController {

	ArtistaBO bo = new ArtistaBO();
	
	public String salvar(Artista Artista) throws SQLException {
		String validacao = validarArtista(Artista);

		if (validacao == "") {
			if (Artista.getIdArtista() > 0) {

			} else {
				if (bo.inserir(Artista) > 0) {
					validacao = "Artista cadastrado com sucesso";
				} else {
					validacao = "Erro ao cadastrar Artista";
				}
			}
		}
		return validacao;
	}
	
	public ArrayList<Artista> listarTodos() {
		return bo.listarTodos();
	}

	private String validarArtista(Artista Artista) {
		// TODO Auto-generated method stub
		return "";
	}

}
