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

public class TCadastroUsuario {

	public static void main(String[] args) throws SQLException {
		
		Usuario usr = new Usuario();
		usr.setIdUsuario(3);;
		
		CadastrarReviews tela = new CadastrarReviews(usr);
		tela.setVisible(true);
		
	}

}
