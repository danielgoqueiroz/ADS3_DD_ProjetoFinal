package controller;

import BO.ProducaoAssitidasBO;
import VO.ProducaoAssistida;

public class FilmesAssistidosController {

	public void cadastrarProducaoAssistidaPorUsuario(ProducaoAssistida producaoAssitida) {
		ProducaoAssitidasBO bo = new ProducaoAssitidasBO();
		bo.cadastrarProducaoAssitida(producaoAssitida);
		
	}

}
