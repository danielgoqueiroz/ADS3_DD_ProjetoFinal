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

	private String validarArtista(Artista artista) {
		String mensagem = "";
		if(bo.buscaArtistaPorNome(artista.getNome() + "" ) != null) {
			mensagem += " Artista ja cadastrado ";
		}
		
		bo.buscaArtistaPorNome(artista.getNome());
		
		return "";
	}

	public Artista buscarArtistaPorNome(String string) {
		return bo.buscaArtistaPorNome(string);
	}

}
