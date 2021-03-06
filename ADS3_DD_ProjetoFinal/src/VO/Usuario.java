package VO;

public class Usuario {
	private int idUsuario;
	private String nome;
	private String nickname;
	private String email;
	private String telefone;
	private String senha;
	private EnumNivel nivel;

	public Usuario(int idUsuario, String nome, String nickname, String email, String telefone, String senha,
			EnumNivel nivel) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.nickname = nickname;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.nivel = nivel;
	}

	public Usuario() {
		super();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public EnumNivel getNivel() {
		return nivel;
	}

	public void setNivel(EnumNivel nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "Usu�rio logado: " + this.getNome();
	}
}
