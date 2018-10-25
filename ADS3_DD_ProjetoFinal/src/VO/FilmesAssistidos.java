package VO;

public class FilmesAssistidos {
	private Usuario usuario;
	private Filme filme;
	
	public FilmesAssistidos(Usuario usuario, Filme filme) {
		super();
		this.usuario = usuario;
		this.filme = filme;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	
	
}
