package BO;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.SerieDAO;
import VO.Serie;

public class SerieBO 
{	
	SerieDAO dao = new SerieDAO();
	
	public boolean inserir(Serie filme) throws SQLException {
		int idGerado = dao.inserir(filme);
		return idGerado > 0;
	}

	public boolean atualizar(Serie filme) throws SQLException {
		return true;
	}	

	public ArrayList<Serie> listarSeries() {
		SerieDAO dao = new SerieDAO();
		return dao.listarTodos();
	}

	
	public boolean excluirSerie(int idSerie) {
		SerieDAO dao = new SerieDAO();
		return dao.excluir(idSerie);
	}
}
