package VO;

public class Artista {
	private int idArtista;
	private String nome;

	public Artista(int idArtista, String nome) {
		super();
		this.idArtista = idArtista;
		this.nome = nome;
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
}