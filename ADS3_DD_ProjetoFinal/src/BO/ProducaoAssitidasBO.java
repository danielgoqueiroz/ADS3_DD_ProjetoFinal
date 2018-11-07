package BO;

import DAO.ProducoesAssistidasDAO;
import VO.ProducoesAssistidas;

public class ProducaoAssitidasBO {

	public void cadastrarProducaoAssitida(ProducoesAssistidas producaoAssitida) {
		ProducoesAssistidasDAO dao = new ProducoesAssistidasDAO();
		dao.inserir(producaoAssitida);
		
	}

	
	
}
