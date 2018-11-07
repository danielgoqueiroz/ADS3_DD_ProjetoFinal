package controller;

import BO.ProducaoAssitidasBO;
import VO.Producao;
import VO.ProducoesAssistidas;
import VO.Usuario;

public class ProducoesAssistidasController {

	public void cadastrarProducaoAssitida(ProducoesAssistidas producaoAssitida) {
		ProducaoAssitidasBO bo = new ProducaoAssitidasBO();
		bo.cadastrarProducaoAssitida(producaoAssitida);
		
	}

}
