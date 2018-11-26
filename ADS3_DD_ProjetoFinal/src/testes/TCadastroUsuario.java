package testes;

import java.sql.SQLException;


import VO.Usuario;

import view.ListarProducoesAssistidas;

public class TCadastroUsuario {

	public static void main(String[] args) throws SQLException {
		
		Usuario usr = new Usuario();
		usr.setIdUsuario(3);;
		
		ListarProducoesAssistidas  tela = new ListarProducoesAssistidas(usr);
		tela.setVisible(true);
		
		
		
	}

}
