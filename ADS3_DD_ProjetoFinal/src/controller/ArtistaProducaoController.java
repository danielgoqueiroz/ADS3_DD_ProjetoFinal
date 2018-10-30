package controller;
import java.sql.SQLException;
import BO.ArtistaProducaoBO;
import VO.ArtistaProducao;

public class ArtistaProducaoController {

	ArtistaProducaoBO bo = new ArtistaProducaoBO();
	
	public boolean salvar(ArtistaProducao artistaProducao) throws SQLException {
		int idGerado = bo.inserir(artistaProducao);
		return idGerado > 0;
	}
}
