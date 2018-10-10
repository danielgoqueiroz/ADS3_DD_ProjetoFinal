package src.VO;

import java.util.ArrayList;

public class Producao {
	
	private String titulo;
	private int ano;
	private Genero[] generos;
	private String diretor;
	private ArrayList<Artista> artistas;
	private String sinopse;
	private String nota;
	
	public Producao(String titulo, int ano, Genero[] generos, String diretor, ArrayList<Artista> artistas, String sinopse,String nota) {
		this.titulo = titulo;
		this.ano = ano;
		this.generos = generos;
		this.diretor = diretor;
		this.artistas = artistas;
		this.sinopse = sinopse;
		this.nota = nota;
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