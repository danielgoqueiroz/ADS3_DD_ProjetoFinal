package VO;

import java.util.ArrayList;

public class Producao {
	
	private String titulo;
	private int ano;
	private Genero genero;
	private String diretor;
	private ArrayList<Artista> artistas;
	private String sinopse;
	private String nota;
	
	
	public Producao() {
		
	}
	
	public Producao(String titulo, int ano, Genero genero, String diretor, ArrayList<Artista> artistas, String sinopse,String nota) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
		this.diretor = diretor;
		this.artistas = artistas;
		this.sinopse = sinopse;
		this.nota = nota;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public ArrayList<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(ArrayList<Artista> artistas) {
		this.artistas = artistas;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}	
	
}