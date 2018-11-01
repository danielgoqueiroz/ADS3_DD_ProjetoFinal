package BO;

import java.util.ArrayList;
import DAO.ArtistaDAO;
import DAO.ArtistaProducaoDAO;
import VO.Artista;
import VO.ArtistaProducao;

public class ArtistaProducaoBO {

	ArtistaProducaoDAO dao = new ArtistaProducaoDAO();
	
	public int inserir(ArtistaProducao Artista) {		
		return dao.inserir(Artista);
	}
	
	public ArrayList<ArtistaProducao> listarTodos() {
		ArtistaProducaoDAO dao = new ArtistaProducaoDAO();
		return dao.listarTodos();
	}

}
