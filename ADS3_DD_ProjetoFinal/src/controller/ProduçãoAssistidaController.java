package controller;

import BO.ProducaoAssitidasBO;
import VO.Producao;
import VO.ProducaoAssistida;
import VO.Usuario;

public class Produ��oAssistidaController {

	public void cadastrarProducaoAssitida(ProducaoAssistida producaoAssitida) {
		ProducaoAssitidasBO bo = new ProducaoAssitidasBO();
		bo.cadastrarProducaoAssitida(producaoAssitida);
		
	}

}
