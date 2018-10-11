package src.testes;

import java.sql.SQLException;
import java.util.ArrayList;

import src.VO.Artista;
import src.VO.Genero;
import src.VO.Series;

public class TSeries {

	public static void main(String[] args) throws SQLException {
	
		Series serie = new Series();
		ArrayList<Artista> artistas = criarArtistas();
		ArrayList<Genero> generos = criarGeneros();
		serie.setArtistas(artistas);
		serie.setAno(2018);
		serie.setCapitulo(22);
		serie.setTemporada(5);
		serie.setTitulo("testee");
		serie.setNota("5");
		serie.setSinopse("filme top no teste");
		
		
	}

	private static ArrayList<Genero> criarGeneros() 
	{
		
		ArrayList<Genero> generos = new ArrayList<Genero>();
		
		Genero gen = new Genero();
		gen.setDescricao("Comédia");
		
		Genero gen1 = new Genero();
		gen.setDescricao("Ação");
		
			
		generos.add(gen);
		generos.add(gen1);
		
		return generos;
	}

	private static ArrayList<Artista> criarArtistas() {
		
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		
		Artista art1 = new Artista();
		art1.setNome("Henrique");
		art1.setDtNascimento("02/05/1992");
		art1.setFunção(new String[] {"Ator"});
		
		Artista art2 = new Artista();
		art2.setNome("Tiago");
		art2.setDtNascimento("12/12/1990");
		art1.setFunção(new String[] {"Diretor"});	
		
		artistas.add(art1);
		artistas.add(art2);
		
		return artistas;
		
	}

}
