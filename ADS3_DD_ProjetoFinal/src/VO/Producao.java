package VO;

import java.util.ArrayList;

public class Producao {
	
	
	private int idProducao;
	private String titulo;
	private int ano;
	private Genero genero;
	private String diretor;
	private EnumTipoProducao tipo;
	private ArrayList<Artista> artistas;
	private String sinopse;
	private byte[] capa;
	private int duracao;
	private int qtdTemporadas;
	private double nota;

	public Producao() {
		
	}
	
	public Producao(int idProducao, String titulo, int ano, Genero genero, String diretor, EnumTipoProducao tipo , int duracao, int qtdTemporadas, ArrayList<Artista> artistas, String sinopse,byte[] capa) {
		super();
		this.idProducao = idProducao;
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
		this.diretor = diretor;
		this.artistas = artistas;
		this.sinopse = sinopse;
		this.capa=capa;
		this.duracao = duracao;
		this.qtdTemporadas = qtdTemporadas;
		this.setTipo(tipo);
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
	
	@Override 
	public String toString() {
		// TODO Auto-generated method stub
		return this.getTitulo() + " - "+ this.getAno() + " - "+ this.getDuracao() + "min.";
	}

	public int getQtdTemporadas() {
		return qtdTemporadas;
	}

	public void setQtdTemporadas(int qtdTemporadas) {
		this.qtdTemporadas = qtdTemporadas;
	}

	public EnumTipoProducao getTipo() {
		return tipo;
	}

	public void setTipo(EnumTipoProducao tipo) {
		this.tipo = tipo;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
}