package src.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import src.DAO.FilmeDAO;
import src.VO.Filme;
import src.VO.Usuario;

public class FilmeBO {

	FilmeDAO dao = new FilmeDAO();
	
	public boolean inserir(Filme filme) throws SQLException {
		int idGerado = dao.inserir(filme);
		return idGerado > 0;
	}
	
	public Filme buscarFilmePorNome(String nome) {
		FilmeDAO dao = new FilmeDAO();
		Filme Filme = dao.buscaFilmePorNome(nome);
		return Filme;
	}

	public boolean atualizar(Filme filme) throws SQLException {
		boolean sucesso = dao.atualizar(filme, filme.getIdFilme());
		return sucesso;
	}
	

	public ArrayList<Filme> listarFilmes() {
		FilmeDAO dao = new FilmeDAO();
		return dao.listarTodos();
	}

	
	public boolean excluirFilme(int idFilme) {
		FilmeDAO dao = new FilmeDAO();
		return dao.excluir(idFilme);
	}

	public Filme buscarFilme() {
		FilmeDAO dao = new FilmeDAO();
		return dao.buscaFilme();
	}

	public Filme buscarFilmeNaoAssistido(Usuario usuario) {
		FilmeDAO dao = new FilmeDAO();
		return dao.buscaFilmeNaoAssistido(usuario);
	}

}
