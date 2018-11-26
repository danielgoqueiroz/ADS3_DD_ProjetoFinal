package BO;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ProducaoDAO;
import DAO.ProducoesAssistidasDAO;
import VO.Genero;
import VO.Producao;
import VO.Usuario;

public class ProducaoBO {

	ProducaoDAO dao = new ProducaoDAO();

	public boolean inserir(Producao producao) throws SQLException {
		int idGerado = dao.inserir(producao);

		boolean inserido = false;

		if (idGerado > 0) {
			producao.setIdProducao(idGerado);
			inserido = true;
		}
		return inserido;
	}

	public boolean atualizar(Producao producao) throws SQLException {
		return dao.atualizar(producao,producao.getIdProducao());
	}

	public ArrayList<Producao> listarproducaos() {
		ProducaoDAO dao = new ProducaoDAO();
		return dao.listarTodos();
	}

	public boolean excluirproducao(int idproducao) {
		return dao.excluir(idproducao);
	}

	public Producao buscarProducao(int idProducao) {
		return dao.buscaProducao(idProducao);
	}

	public Producao buscarProducaoNaoAssistido(Usuario usuario) {		
		return dao.buscaProducaoNaoAssistido(usuario);
	}
	
	public ArrayList<Producao> buscaProducoesNaoAssistidas(Usuario usuario) {		
		return dao.buscaProducoesNaoAssistidas(usuario);
	}
	
	public double BuscarMediaProducao(Producao p) {
		return dao.BuscarMediaProducao(p);
	}
	
	public ArrayList<Producao> buscarProducoesAssistidas(Usuario usuario) {
		return dao.buscarProducoesAssistidas(usuario);
	}
	
	public ArrayList<Producao> buscarProducoes() {
		return dao.listarTodos();
	}

	public ArrayList<Producao> buscarProducoesAssistidas(Usuario usuario, int genero) {
		return dao.buscarProducoesAssistidas(usuario, genero);
	}

}
