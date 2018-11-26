package BO;

import java.util.ArrayList;
import DAO.ArtistaProducaoDAO;
import VO.ArtistaProducao;
import VO.Producao;

public class ArtistaProducaoBO {

	ArtistaProducaoDAO dao = new ArtistaProducaoDAO();
	
	public int inserir(ArtistaProducao Artista) {		
		return dao.inserir(Artista);
	}
	
	public ArrayList<ArtistaProducao> listarTodos() {
		ArtistaProducaoDAO dao = new ArtistaProducaoDAO();
		return dao.listarTodos();
	}
	
	public void ArtistasUpdate(Producao producao) {
		dao.ArtistasUpdate(producao);
	}

}
