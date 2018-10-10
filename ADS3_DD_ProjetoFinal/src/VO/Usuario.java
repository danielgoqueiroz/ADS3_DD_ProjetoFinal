package src.VO;

public class Usuario {
	int idusuario;
	String nome;
	String nickname;
	String email;
	String telefone;
	String senha;
	
	



	public Usuario(int idusuario, String nome, String nickname, String email, String telefone, String senha) {
		super();
		this.idusuario = idusuario;
		this.nome = nome;
		this.nickname = nickname;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}
	
	
	public Usuario() {
		super();
	}


	public int getIdusuario() {
		return idusuario;
	}



	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}






	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString(){
		return this.getNome() + " " + this.getTelefone();
	};
	
	
}
