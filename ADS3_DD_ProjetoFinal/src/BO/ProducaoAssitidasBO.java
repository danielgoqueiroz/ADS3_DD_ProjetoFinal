package BO;

import java.util.ArrayList;

import DAO.ProducoesAssistidasDAO;
import VO.Producao;
import VO.ProducoesAssistidas;
import VO.Usuario;

public class ProducaoAssitidasBO {
	ProducoesAssistidasDAO dao = new ProducoesAssistidasDAO();
	public void cadastrarProducaoAssitida(ProducoesAssistidas producaoAssitida) {		
		dao.inserir(producaoAssitida);
		
	}	
}
