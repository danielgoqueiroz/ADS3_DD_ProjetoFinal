package testes;
import java.sql.SQLException;
import java.util.ArrayList;
import VO.Artista;
import VO.Genero;
import VO.Serie;

public class TSeries {

	public static void main(String[] args) throws SQLException {
	
		Serie serie = new Serie();
		ArrayList<Artista> artistas = criarArtistas();
		ArrayList<Genero> generos = criarGeneros();
//		serie.setArtistas(artistas);
//		serie.setAno(2018);
//		serie.setCapitulo(22);
//		serie.setTemporada(5);
//		serie.setTitulo("testee");
//		serie.setNota("5");
//		serie.setSinopse("filme top no teste");
		
		
	}

	private static ArrayList<Genero> criarGeneros() 
	{
		
		ArrayList<Genero> generos = new ArrayList<Genero>();
		
		Genero gen = new Genero();
		gen.setDescricao("Com�dia");
		
		Genero gen1 = new Genero();
		gen.setDescricao("A��o");
		
			
		generos.add(gen);
		generos.add(gen1);
		
		return generos;
	}

	private static ArrayList<Artista> criarArtistas() {
		
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		
		Artista art1 = new Artista();
		art1.setNome("Henrique");
		//art1.setDtNascimento("02/05/1992");
		
		Artista art2 = new Artista();
		art2.setNome("Tiago");
		//art2.setDtNascimento("12/12/1990");	
		
		artistas.add(art1);
		artistas.add(art2);
		
		return artistas;
		
	}

}
