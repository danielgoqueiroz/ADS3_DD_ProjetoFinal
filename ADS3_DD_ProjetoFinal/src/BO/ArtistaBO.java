package BO;

import java.util.ArrayList;
import DAO.ArtistaDAO;
import DAO.GeneroDAO;
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

	public Artista buscaArtistaPorNome(String string) {
		return dao.buscaArtistaPorNome(string); 
	}

	

}
