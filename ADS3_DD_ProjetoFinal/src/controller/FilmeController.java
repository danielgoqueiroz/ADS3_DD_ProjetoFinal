package src.controller;

import java.sql.SQLException;

import src.BO.FilmeBO;
import src.VO.Filme;

public class FilmeController {

	FilmeBO bo = new FilmeBO();
	
	public String salvar(Filme filme) throws SQLException {
		String validacao = validarFilme(filme);
		
		if (validacao == "") {
			if (filme.getIdFilme() > 0) {
				//ATUALIZAR
//				if (bo.atualizar(usuario)) {
//					validacao = "Usuário atualizado com sucesso";
//				} else {
//					validacao = "Erro au atualizar o usuário";
//				}
			
			} else {
				 if (bo.inserir(filme)) {
					 validacao = "Filme cadastrado com sucesso";
				 } else {
					 validacao = "Erro ao cadastrar filme";
				 }
			}
			
			
		}
		return validacao;
	}
		
		private String validarFilme(Filme filme) {
		// TODO Auto-generated method stub
		return "";
	}

		public Filme buscaFilme() {
			FilmeBO bo = new FilmeBO();
			
			return bo.buscarFilme();
		}


	
}
