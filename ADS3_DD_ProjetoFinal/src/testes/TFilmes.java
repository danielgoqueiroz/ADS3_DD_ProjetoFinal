package testes;

import java.sql.SQLException;
import java.util.ArrayList;

import VO.Artista;
import VO.Filme;
import VO.Genero;
import controller.FilmeController;

public class TFilmes {

	public static void main(String[] args) throws SQLException {
		
		Filme filme = new Filme();
		ArrayList<Artista> artistas = criarArtistas();
//		filme.setArtistas(artistas);
//		filme.setTitulo("Teste");
//		filme.setAno(2018);
//		filme.setDiretor("EU");
//		filme.setDuracao(60);
//		filme.setSinopse("Um filme muito louco que está sendo testado");
//		filme.setNota("5");
		
		Genero gen1 = new Genero();
		Genero[] generos = {gen1};
		
		gen1.setDescricao("Comédia");
		
//		String genero;
//		filme.setGenero();
//		
		FilmeController controller = new FilmeController();
		System.out.println(controller.salvar(filme));
	}

	private static ArrayList<Artista> criarArtistas() {
		
		ArrayList<Artista> artistas = new ArrayList<>();
		
		Artista art1 = new Artista();
		art1.setNome("Daniel");
		art1.setFunção(new String[] {"Ator", "Diretor"});
		art1.setDtNascimento("1990-02-06");
		
		artistas.add(art1);
		
		return artistas;
	}

}
