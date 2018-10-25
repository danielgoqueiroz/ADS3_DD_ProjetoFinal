package BO;

import DAO.FilmesAssistidosDAO;
import VO.FilmesAssistidos;

public class FilmesAssistidosBO {

	public void cadastrarFilme(FilmesAssistidos filmeAssitido) {
		FilmesAssistidosDAO dao = new FilmesAssistidosDAO();
		dao.cadastrarFilmesAssistidos(filmeAssitido);
	}
}