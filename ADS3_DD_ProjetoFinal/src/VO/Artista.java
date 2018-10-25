package VO;

import java.sql.Date;

public class Artista {
	private int idArtista;
	private String nome;
	private Date dtNascimento;
	
	public Artista(int idArtista, String nome, Date dtNascimento) {
		super();
		this.idArtista = idArtista;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
	}
	public Artista() {
		super();
	}
	
	public int getIdArtista() {
		return idArtista;
	}
	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
}