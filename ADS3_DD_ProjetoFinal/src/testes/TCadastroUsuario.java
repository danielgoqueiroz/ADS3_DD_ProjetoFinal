package testes;

import java.sql.SQLException;

import com.sun.javafx.image.impl.General;

import DAO.GeneroDAO;
import VO.Producao;
import VO.ProducoesAssistidas;
import VO.Usuario;
import controller.ProducaoController;
import controller.ProducoesAssistidasController;
import controller.UsuarioController;
import view.CadastrarReviews;
import view.ListarProducoesAssistidas;

public class TCadastroUsuario {

	public static void main(String[] args) throws SQLException {
		
		Usuario usr = new Usuario();
		usr.setIdUsuario(3);;
		
		ListarProducoesAssistidas  tela = new ListarProducoesAssistidas(usr);
		tela.setVisible(true);
		
		
		
	}

}
