package src.VO;

public class Producao {
	
	String titulo;
	int ano;
	Genero[] generos;
	String diretor;
	Artista[] artistas;
	String sinopse;
	String Nota;
	private String[] atores;
	

	
	public Producao(String titulo, int ano, String[] genero, String diretor, String[] atores, String sinopse,
			String nota) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.generos = generos;
		diretor = diretor;
		this.atores = atores;
		this.sinopse = sinopse;
		Nota = nota;
	}
	
	
	public Producao() {
		super();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Genero[] getGenero() {
		return generos;
	}

	public void setGeneros(Genero[] generos) {
		this.generos = generos;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String[] getAtores() {
		return atores;
	}

	public void setAtores(String[] atores) {
		this.atores = atores;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getNota() {
		return Nota;
	}

	public void setNota(String nota) {
		Nota = nota;
	}
	
	
	
	
}
