package src.Testes;

import java.sql.SQLException;

import src.VO.Artista;
import src.VO.Filme;
import src.VO.Genero;
import src.controller.FilmeController;

public class Tfilmes {

	public static void main(String[] args) throws SQLException {
		
		Filme filme = new Filme();
		Artista art1 = new Artista();
		art1.setNome("Daniel");
		art1.setFunção(new String[] {"Ator", "Diretor"});
		art1.setDt_nascimento("1990-02-06");
		filme.setAtores(new String [] {"Daniel"});
		filme.setTitulo("Teste");
		filme.setAno(2018);
		filme.setDiretor("EU");
		filme.setDuracao(60);
		filme.setSinopse("Um filme muito louco que está sendo testado");
		filme.setNota("5");
		Genero gen1 = new Genero();
		Genero[] generos = {gen1};
		
		gen1.setDescricao("Comédia");
		
		
		filme.setGeneros(generos);

		
		FilmeController controller = new FilmeController();
		System.out.println(controller.salvar(filme));

	}

}
