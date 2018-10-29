package BO;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.FilmeDAO;
import VO.Filme;
import VO.Usuario;

public class FilmeBO {

	FilmeDAO dao = new FilmeDAO();
	
	public boolean inserir(Filme filme) throws SQLException {
		int idGerado = dao.inserir(filme);
		return idGerado > 0;
	}

	public boolean atualizar(Filme filme) throws SQLException {
		return true;
	}
	

	public ArrayList<Filme> listarFilmes() {
		FilmeDAO dao = new FilmeDAO();
		return dao.listarTodos();
	}

	
	public boolean excluirFilme(int idFilme) {
		FilmeDAO dao = new FilmeDAO();
		return dao.excluir(idFilme);
	}

	public Filme buscarFilme(int idProducao) {
		return dao.buscaFilme(idProducao);
	}

	public Filme buscarFilmeNaoAssistido(Usuario usuario) {
		FilmeDAO dao = new FilmeDAO();
		return dao.buscaFilmeNaoAssistido(usuario);
	}

}
