package src.testes;

import src.VO.Genero;
import src.controller.GeneroController;

public class TGenero {

	public static void main(String[] args) {
		
		Genero gen = new Genero();
		GeneroController controller = new GeneroController();
		
		gen.setDescricao("Terror");
		System.out.println(controller.salvar(gen) + "");
		
	}

}
