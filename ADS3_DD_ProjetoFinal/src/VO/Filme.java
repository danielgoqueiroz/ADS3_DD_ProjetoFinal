package src.VO;

public class Filme extends Producao{
	int idFilme;
	int Duracao;
	Genero[] generos;

	
	
	
	public Filme(String titulo, int ano, String[] genero, String diretor, String[] atores, String sinopse, String nota,
			int idFilme, int duracao, src.VO.Genero[] generos) {
		super(titulo, ano, genero, diretor, atores, sinopse, nota);
		this.idFilme = idFilme;
		Duracao = duracao;
		this.generos = generos;
	}

	
	public Filme() {
		super();
	}

	public int getDuracao() {
		return Duracao;
	}

	public void setDuracao(int duracao) {
		Duracao = duracao;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public String toString(Filme filme) {
		return filme.getTitulo() + "/" + filme.getAno();
		
	}
}
