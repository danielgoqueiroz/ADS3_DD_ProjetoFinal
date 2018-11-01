package controller;

import java.sql.SQLException;

import BO.ProducaoBO;
import VO.Producao;
import VO.Usuario;

public class ProducaoController {

	ProducaoBO bo = new ProducaoBO();

	public String salvar(Producao Producao) throws SQLException {
		String validacao = validarProducao(Producao);

		if (validacao == "") {
			if (Producao.getIdProducao() > 0) {

				if (bo.atualizar(Producao)) {
					validacao = "Producao atualizado com sucesso";
				} else {
					validacao = "Erro au atualizar o Producao";
				}
			} else {
				if (bo.inserir(Producao)) {
					validacao = "Producao cadastrado com sucesso";
				} else {
					validacao = "Erro ao cadastrar Producao";
				}
			}
		}
		return validacao;
	}

	private String validarProducao(Producao Producao) {
		return "";
	}

	public Producao buscaProducao(int idProducao) {
		return bo.buscarProducao(idProducao);
	}

	public Producao buscaProducaoNaoAssistido(Usuario usuario) {
		return bo.buscarProducaoNaoAssistido(usuario);
	}

}
