package VO;

public class ProducaoAssistida {
	private Usuario usuario;
	private Producao producao;
	private int nota;
	
	

	public ProducaoAssistida(Usuario usuario, Producao producao, int nota) {
		super();
		this.usuario = usuario;
		this.producao = producao;
		this.nota = nota;
	}
	
	

	public ProducaoAssistida() {
		super();
	}



	public int getNota() {
		return nota;
	}



	public void setNota(int nota) {
		this.nota = nota;
	}



	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Producao getProducao() {
		return producao;
	}

	public void setProducao(Producao producao) {
		this.producao = producao;
	}
	
	
	
}
