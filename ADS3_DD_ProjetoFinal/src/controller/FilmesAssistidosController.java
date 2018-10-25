package src.controller;

import src.BO.FilmesAssistidosBO;
import src.VO.FilmesAssistidos;

public class FilmesAssistidosController {

	public void cadastrarFilmeAssitido(FilmesAssistidos filmeAssitido) {
		FilmesAssistidosBO bo = new FilmesAssistidosBO();
		bo.cadastrarFilme(filmeAssitido);
		
	}

}
