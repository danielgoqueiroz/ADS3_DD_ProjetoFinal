package src.VO;

public class Artista {
	int idartista;
	String nome;
	String[] fun��o;
	String dt_nascimento;
	
	public Artista(int idartista, String nome, String[] fun��o, String dt_nascimento) {
		super();
		this.idartista = idartista;
		this.nome = nome;
		this.fun��o = fun��o;
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
	public String[] getFun��o() {
		return fun��o;
	}
	public void setFun��o(String[] fun��o) {
		this.fun��o = fun��o;
	}
	
	public String getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(String dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	
	
	
}
