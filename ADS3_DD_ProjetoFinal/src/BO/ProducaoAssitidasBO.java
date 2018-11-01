package BO;

import DAO.ProducaoAssitidasDAO;
import VO.ProducaoAssistida;

public class ProducaoAssitidasBO {

	public void cadastrarProducaoAssitida(ProducaoAssistida producaoAssitida) {
		ProducaoAssitidasDAO dao = new ProducaoAssitidasDAO();
		dao.inserir(producaoAssitida);
		
	}

	
	
}
