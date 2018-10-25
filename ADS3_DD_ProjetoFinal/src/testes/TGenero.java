package src.testes;

import java.sql.SQLException;

import src.VO.Genero;
import src.controller.GeneroController;

public class TGenero {

	public static void main(String[] args) throws SQLException {
		
		Genero gen = new Genero();
		GeneroController controller = new GeneroController();
		
		gen.setDescricao("Terror");
		System.out.println(controller.salvar(gen) + "");
		
	}

}
