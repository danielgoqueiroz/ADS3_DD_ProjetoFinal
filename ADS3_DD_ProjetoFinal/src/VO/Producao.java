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
	
	
	
	
}
