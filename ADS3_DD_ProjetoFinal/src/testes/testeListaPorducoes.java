package testes;

import java.awt.List;
import java.util.ArrayList;

import DAO.ProducaoDAO;
import VO.Geradorplanilhas;
import VO.Producao;

public class testeListaPorducoes {

	public static void main(String[] args) {
		
		ArrayList<Producao> producoes = new ArrayList<Producao>();
		ProducaoDAO dao = new ProducaoDAO();
		
		producoes = dao.listarTodos();
		
		Geradorplanilhas planilha = new Geradorplanilhas();
		
		planilha.gerarPlanilhasProducao(producoes, "D:\\Aluno\\teste");
		

	}

}
