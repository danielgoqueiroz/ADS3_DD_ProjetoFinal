package src.BO;

import src.DAO.GeneroDAO;
import src.VO.Genero;

public class GeneroBO {

	GeneroDAO dao = new GeneroDAO();
	
	public int inserir(Genero genero) {
		
		return dao.inserir(genero);
	}

}
