package controller;

import BO.ProducaoAssitidasBO;
import VO.Producao;
import VO.ProducaoAssistida;
import VO.Usuario;

public class ProduçãoAssistidaController {

	public void cadastrarProducaoAssitida(ProducaoAssistida producaoAssitida) {
		ProducaoAssitidasBO bo = new ProducaoAssitidasBO();
		bo.cadastrarProducaoAssitida(producaoAssitida);
		
	}

}
