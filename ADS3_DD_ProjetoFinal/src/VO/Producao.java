package VO;

public class Producao {
	String titulo;
	int ano;
	String[] Genero;
	String Diretor;
	String[] atores;
	String sinopse;
	String Nota;

	
	public Producao(String titulo, int ano, String[] genero, String diretor, String[] atores, String sinopse,
			String nota) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		Genero = genero;
		Diretor = diretor;
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

	public String[] getGenero() {
		return Genero;
	}

	public void setGenero(String[] genero) {
		Genero = genero;
	}

	public String getDiretor() {
		return Diretor;
	}

	public void setDiretor(String diretor) {
		Diretor = diretor;
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
