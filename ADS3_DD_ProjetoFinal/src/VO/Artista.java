package src.VO;

public class Artista {
	int idartista;
	String nome;
	String[] função;
	String dt_nascimento;
	
	public Artista(int idartista, String nome, String[] função, String dt_nascimento) {
		super();
		this.idartista = idartista;
		this.nome = nome;
		this.função = função;
		this.dt_nascimento = dt_nascimento;
	}
	public Artista() {
		super();
	}
	
	
	public int getIdartista() {
		return idartista;
	}
	public void setIdartista(int idartista) {
		this.idartista = idartista;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String[] getFunção() {
		return função;
	}
	public void setFunção(String[] função) {
		this.função = função;
	}
	
	public String getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(String dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	
	
	
}
