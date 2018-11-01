package BO;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ProducaoDAO;
import VO.Producao;
import VO.Usuario;

public class ProducaoBO {

	ProducaoDAO dao = new ProducaoDAO();
	
	public boolean inserir(Producao producao) throws SQLException {
		int idGerado = dao.inserir(producao);
		return idGerado > 0;
	}

	public boolean atualizar(Producao producao) throws SQLException {
		return true;
	}
	

	public ArrayList<Producao> listarproducaos() {
		ProducaoDAO dao = new ProducaoDAO();
		return dao.listarTodos();
	}

	
	public boolean excluirproducao(int idproducao) {
		ProducaoDAO dao = new ProducaoDAO();
		return dao.excluir(idproducao);
	}

	public Producao buscarProducao(int idProducao) {
		return dao.buscaProducao(idProducao);
	}

	public Producao buscarProducaoNaoAssistido(Usuario usuario) {
		ProducaoDAO dao = new ProducaoDAO();
		return dao.buscaProducaoNaoAssistido(usuario);
	}

	
}
