package BO;

import DAO.GeneroDAO;
import VO.Genero;

public class GeneroBO {

	GeneroDAO dao = new GeneroDAO();
	
	public int inserir(Genero genero) {
		
		return dao.inserir(genero);
	}

}
