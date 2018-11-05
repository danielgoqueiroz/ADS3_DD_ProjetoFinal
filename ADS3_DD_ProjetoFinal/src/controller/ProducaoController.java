package controller;

import java.sql.SQLException;

import BO.ProducaoBO;
import VO.Artista;
import VO.ArtistaProducao;
import VO.Producao;
import VO.Usuario;

public class ProducaoController {

	ProducaoBO bo = new ProducaoBO();

	public String salvar(Producao producao) throws SQLException {
		String validacao = validarProducao(producao);

		if (validacao == "") {
			if (producao.getIdProducao() > 0) {

				if (bo.atualizar(producao)) {
					validacao = "Producao atualizado com sucesso";
				} else {
					validacao = "Erro au atualizar o Producao";
				}
			} else {
				if (bo.inserir(producao)) {
					validacao = "Producao cadastrado com sucesso";

					ArtistaProducaoController controle = new ArtistaProducaoController();

					for (Artista artista : producao.getArtistas()) {

						ArtistaProducao ap = new ArtistaProducao();

						ap.setIdArtista(artista.getIdArtista());
						ap.setIdProducao(producao.getIdProducao());

						controle.salvar(ap);
					}

				} else {
					validacao = "Erro ao cadastrar Producao";
				}
			}
		} else {
			validacao = "Necessário preencher os seguintes campos: \n" + validacao;
		}
		return validacao;
	}

	private String validarProducao(Producao Producao) {
		String msg = "";
		if (Producao.getTitulo().isEmpty()) {
			msg += " Título \n";
		}
		if (Producao.getAno() < 1) {
			msg += " Ano \n";
		}
		if (Producao.getSinopse().isEmpty()) {
			msg += " Sinopese \n";
		}
		if (Producao.getGenero().getDescricao().isEmpty()) {
			msg += " Gênero \n";
		}
		if (Producao.getDiretor().isEmpty()) {
			msg += " Diretor \n";
		}
		if (Producao.getDuracao() < 1 && Producao.getQtdTemporadas() < 1) {
			msg += " Duração ou quantidade de temporadas \n";
		}

		return msg;
	}

	public Producao buscaProducao(int idProducao) {
		return bo.buscarProducao(idProducao);
	}

	public Producao buscaProducaoNaoAssistido(Usuario usuario) {
		return bo.buscarProducaoNaoAssistido(usuario);
	}
	
	public double BuscarMediaProducao(Producao p) {
		return bo.BuscarMediaProducao(p);
	}

}
