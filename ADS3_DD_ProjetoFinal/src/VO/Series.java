package VO;

public class Series extends Producao{
	int temporada;
	int captulo;
	
	
	public Series(String titulo, int ano, String[] genero, String diretor, String[] atores, String sinopse, String nota,
			int temporada, int captulo) {
		super(titulo, ano, genero, diretor, atores, sinopse, nota);
		this.temporada = temporada;
		this.captulo = captulo;
	}
	
	
	public Series(String titulo, int ano, String[] genero, String diretor, String[] atores, String sinopse,
			String nota) {
		super(titulo, ano, genero, diretor, atores, sinopse, nota);
	}
	
	
	public int getTemporada() {
		return temporada;
	}
	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}
	public int getCaptulo() {
		return captulo;
	}
	public void setCaptulo(int captulo) {
		this.captulo = captulo;
	}
	
	
}
