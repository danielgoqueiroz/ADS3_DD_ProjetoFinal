package controller;

import BO.FilmesAssistidosBO;
import VO.FilmesAssistidos;

public class FilmesAssistidosController {

	public void cadastrarFilmeAssitido(FilmesAssistidos filmeAssitido) {
		FilmesAssistidosBO bo = new FilmesAssistidosBO();
		bo.cadastrarFilme(filmeAssitido);
		
	}

}
