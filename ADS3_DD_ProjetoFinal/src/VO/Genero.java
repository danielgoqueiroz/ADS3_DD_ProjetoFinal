package VO;

public class Genero {

	private int idGenero;
	private String descricao;
		
		public Genero(int idgenero, String descricao) {
			super();
			this.idGenero = idgenero;
			this.descricao = descricao;
		}

		public Genero() {
			super();
		}

		public int getIdGenero() {
			return idGenero;
		}

		public void setIdGenero(int idGenero) {
			this.idGenero = idGenero;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		@Override
		public String toString() {
			return this.getIdGenero() + " "+this.getDescricao();
		}
		
}
