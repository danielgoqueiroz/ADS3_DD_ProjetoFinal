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
		Producao p = new Producao();
		Usuario u = new Usuario();
		p.setIdProducao(1);
		u.setIdUsuario(5);
//		TelaInicial tela = new TelaInicial(u);
//		tela.show();
		ProducaoAssistida producaoAssitida = new ProducaoAssistida(u, p, 1);

		ProduçãoAssistidaController controle = new ProduçãoAssistidaController();
		controle.cadastrarProducaoAssitida(producaoAssitida);
		
	}

}
