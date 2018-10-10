package src.VO;

public class Series extends Producao{
	private int idSerie;
	private int temporada;
	private int capitulo;
	
	public Series(String titulo, int ano, Genero[] generos, String diretor, Artista[] artistas, String sinopse,String nota, int idSerie,int temporada, int capitulo) {
		super(titulo, ano, generos, diretor, artistas, sinopse, nota);
		this.idSerie=idSerie;
		this.temporada=temporada;
		this.capitulo=capitulo;
	}	
}
