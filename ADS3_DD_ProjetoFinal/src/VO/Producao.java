package VO;

import java.util.ArrayList;

public class Producao {
	
	private int idProducao;
	private String titulo;
	private int ano;
	private Genero genero;
	private String diretor;
	private ArrayList<Artista> artistas;
	private String sinopse;
	private byte[] capa;
	private int duracao;

	public Producao() {
		
	}
	
	public Producao(int idProducao, String titulo, int ano, Genero genero, String diretor, ArrayList<Artista> artistas, String sinopse,byte[] capa) {
		super();
		this.idProducao = idProducao;
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
		this.diretor = diretor;
		this.artistas = artistas;
		this.sinopse = sinopse;
		this.capa=capa;
	}
	
	public int getIdProducao() {
		return idProducao;
	}

	public void setIdProducao(int idProducao) {
		this.idProducao = idProducao;
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
	
	public byte[] getCapa() {
		return capa;
	}

	public void setCapa(byte[] bs) {
		this.capa = bs;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
}