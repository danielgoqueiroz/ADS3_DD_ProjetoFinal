package testes;

import java.sql.SQLException;

import VO.EnumTipoProducao;
import VO.Genero;
import VO.Producao;
import controller.GeneroController;

public class TGenero {

	public static void main(String[] args) throws SQLException {
		
		Producao p = new Producao();
		EnumTipoProducao e = EnumTipoProducao.Filme;
		System.out.println(e);
	}

}
