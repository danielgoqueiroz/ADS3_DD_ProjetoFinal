package BO;

import java.util.ArrayList;

import DAO.ProducoesAssistidasDAO;
import VO.Producao;
import VO.ProducoesAssistidas;
import VO.Usuario;

public class ProducaoAssitidasBO {

	public void cadastrarProducaoAssitida(ProducoesAssistidas producaoAssitida) {
		ProducoesAssistidasDAO dao = new ProducoesAssistidasDAO();
		dao.inserir(producaoAssitida);
		
	}
	
}
