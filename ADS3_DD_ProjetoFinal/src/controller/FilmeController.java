package controller;

import java.sql.SQLException;
import BO.FilmeBO;
import VO.Artista;
import VO.ArtistaProducao;
import VO.Filme;
import VO.Usuario;

public class FilmeController {

	FilmeBO bo = new FilmeBO();

	public String salvar(Filme filme) throws SQLException {
		String validacao = validarFilme(filme);

		if (validacao == "") {
			if (filme.getIdProducao() > 0) {

				if (bo.atualizar(filme)) {
					validacao = "Filme atualizado com sucesso";
				} else {
					validacao = "Erro ao atualizar o filme";
				}
			} else {
				if (bo.inserir(filme)) {
					validacao = "Filme cadastrado com sucesso";
					
					ArtistaProducaoController controle = new ArtistaProducaoController();
					
					for (Artista artista : filme.getArtistas()) {
						
						ArtistaProducao ap = new ArtistaProducao(); 
						
						ap.setIdArtista(artista.getIdArtista());
						ap.setIdProducao(filme.getIdProducao());
						
						controle.salvar(ap);
					}
					
				} else {
					validacao = "Erro ao cadastrar filme";
				}
			}
		}
		return validacao;
	}

	private String validarFilme(Filme filme) {
		return "";
	}

	public Filme buscaFilme(int idProducao) {
		return bo.buscarFilme(idProducao);
	}

	public Filme buscaFilmeNaoAssistido(Usuario usuario) {
		return bo.buscarFilmeNaoAssistido(usuario);
	}

}
