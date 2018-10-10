package src.VO;

public class Artista {
	private int idArtista;
	private String nome;
	private String[] funcao;
	private String dtNascimento;
	
	public Artista(int idArtista, String nome, String[] funcao, String dtNascimento) {
		super();
		this.idArtista = idArtista;
		this.nome = nome;
		this.funcao = funcao;
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
	public String[] getFuncao() {
		return funcao;
	}
	public void setFunção(String[] funcao) {
		this.funcao = funcao;
	}
	
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	
	
}
