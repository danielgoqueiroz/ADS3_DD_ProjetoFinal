package BO;

import java.util.ArrayList;

import DAO.GeneroDAO;
import VO.Genero;

public class GeneroBO {

	GeneroDAO dao = new GeneroDAO();
	
	public int inserir(Genero genero) {
		
		return dao.inserir(genero);
	}
	
	public ArrayList<Genero> listarTodos() {
		GeneroDAO dao = new GeneroDAO();
		return dao.listarTodos();
	}

	public Genero buscaGeneroPorNome(String string) {
		GeneroDAO dao = new GeneroDAO();
		return dao.buscaGeneroPorNome(string);
		
	}

}
