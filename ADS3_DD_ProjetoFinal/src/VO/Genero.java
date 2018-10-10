package src.VO;

public class Genero {

	private int idgenero ;
	private String descricao;
		
		public Genero(int idgenero, String descricao) {
			super();
			this.idgenero = idgenero;
			this.descricao = descricao;
		}

		public Genero() {
			super();
		}

		public int getIdgenero() {
			return idgenero;
		}

		public void setIdgenero(int idgenero) {
			this.idgenero = idgenero;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		
}
