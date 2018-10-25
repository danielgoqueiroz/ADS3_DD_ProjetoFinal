package src.BO;

import src.DAO.FilmesAssistidosDAO;
import src.VO.FilmesAssistidos;

public class FilmesAssistidosBO {

	public void cadastrarFilme(FilmesAssistidos filmeAssitido) {
		FilmesAssistidosDAO dao = new FilmesAssistidosDAO();
		dao.cadastrarFilmesAssitidos(filmeAssitido);
		
	}

}
