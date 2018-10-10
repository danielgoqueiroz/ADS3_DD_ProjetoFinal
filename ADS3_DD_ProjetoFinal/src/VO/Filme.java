package src.VO;

public class Filme extends Producao{
	private int idFilme;
	private int duracao;
	private Genero[] generos;
	
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

	public Genero[] getGeneros() {
		return generos;
	}

	public void setGeneros(Genero[] generos) {
		this.generos = generos;
	}
	
	@Override
	public String toString() {
		return this.getTitulo() + "/" + this.getAno();		
	}
}