package src.VO;

import java.util.ArrayList;

public class Series extends Producao{
	private int idSerie;
	private int temporada;
	private int capitulo;
	

	public Series() {
		
	}	
	
	public int getIdSerie() {
		return idSerie;
	}

	public void setIdSerie(int idSerie) {
		this.idSerie = idSerie;
	}

	public int getTemporada() {
		return temporada;
	}

	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}

	public int getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(int capitulo) {
		this.capitulo = capitulo;
	}

	public Series(String titulo, int ano, Genero genero, String diretor, ArrayList<Artista> artistas, String sinopse,String nota, int idSerie,int temporada, int capitulo) {
		super(titulo, ano, genero, diretor, artistas, sinopse, nota);
		this.idSerie=idSerie;
		this.temporada=temporada;
		this.capitulo=capitulo;
	}
		
}