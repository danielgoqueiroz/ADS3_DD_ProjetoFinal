package BO;

import java.util.ArrayList;
import DAO.ArtistaDAO;
import VO.Artista;

public class ArtistaBO {

	ArtistaDAO dao = new ArtistaDAO();
	
	public int inserir(Artista Artista) {		
		return dao.inserir(Artista);
	}
	
	public ArrayList<Artista> listarTodos() {
		ArtistaDAO dao = new ArtistaDAO();
		return dao.listarTodos();
	}

}
