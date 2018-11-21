package controller;

import java.util.ArrayList;

import BO.ProducaoAssitidasBO;
import VO.Producao;
import VO.ProducoesAssistidas;
import VO.Usuario;

public class ProducoesAssistidasController {

	ProducaoAssitidasBO bo = new ProducaoAssitidasBO();
	
	public void cadastrarProducaoAssitida(ProducoesAssistidas producaoAssitida) {		
		bo.cadastrarProducaoAssitida(producaoAssitida);		
	}

}
