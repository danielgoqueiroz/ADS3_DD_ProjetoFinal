package controller;
import java.sql.SQLException;
import BO.ArtistaProducaoBO;
import VO.ArtistaProducao;
import VO.Producao;

public class ArtistaProducaoController {

	ArtistaProducaoBO bo = new ArtistaProducaoBO();
	
	public boolean salvar(ArtistaProducao artistaProducao) throws SQLException {
		int idGerado = bo.inserir(artistaProducao);
		return idGerado > 0;
	}

	public void ArtistasUpdate(Producao producao) {
		bo.ArtistasUpdate(producao);
	}
}
