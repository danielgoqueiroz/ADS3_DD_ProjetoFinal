package BO;

import java.util.ArrayList;

import DAO.ProducoesAssistidasDAO;
import VO.ProducoesAssistidas;

public class ProducaoAssitidasBO {
	ProducoesAssistidasDAO dao = new ProducoesAssistidasDAO();
	public void cadastrarProducaoAssitida(ProducoesAssistidas producaoAssitida) {		
		dao.inserir(producaoAssitida);
		
	}	
}
