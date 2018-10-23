package src.VO;

public class Filme extends Producao{
	private int idFilme;
	private int duracao;
//	private Genero[] generos;
	private String genero;
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String string) {
		this.genero = string;
	}

	public Filme() {
		super();
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

//	public Genero[] getGeneros() {
//		return generos;
//	}
//
//	public void setGeneros(Genero[] generos) {
//		this.generos = generos;
//	}
	
	@Override
	public String toString() {
		return this.getIdFilme() + " " + this.getTitulo() + " " + this.getAno();		
	}
}