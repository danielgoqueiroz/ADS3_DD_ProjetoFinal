package testes;

import java.sql.SQLException;

import com.sun.javafx.image.impl.General;

import DAO.GeneroDAO;
import VO.Producao;
import VO.ProducaoAssistida;
import VO.Usuario;
import controller.ProducaoController;
import controller.ProduçãoAssistidaController;
import controller.UsuarioController;
import view.TelaInicial;

public class TCadastroUsuario {

	public static void main(String[] args) throws SQLException {
		
		Usuario usr = new Usuario();
		usr.setIdUsuario(3);;
		
		TelaInicial tela = new TelaInicial(usr);
		tela.setVisible(true);
		
	}

}
