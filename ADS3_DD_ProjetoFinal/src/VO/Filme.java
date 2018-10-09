package VO;

public class Filme extends Producao{
	int Duracao;

	public Filme(String titulo, int ano, String[] genero, String diretor, String[] atores, String sinopse, String nota,
			int duracao) {
		super(titulo, ano, genero, diretor, atores, sinopse, nota);
		Duracao = duracao;
	}

	public Filme(String titulo, int ano, String[] genero, String diretor, String[] atores, String sinopse,
			String nota) {
		super(titulo, ano, genero, diretor, atores, sinopse, nota);
	}

	public int getDuracao() {
		return Duracao;
	}

	public void setDuracao(int duracao) {
		Duracao = duracao;
	}

	
}
