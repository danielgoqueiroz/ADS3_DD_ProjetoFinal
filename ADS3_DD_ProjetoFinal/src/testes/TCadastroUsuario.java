package src.testes;

import java.sql.SQLException;

import src.VO.Usuario;
import src.controller.UsuarioController;

public class TCadastroUsuario {

	public static void main(String[] args) throws SQLException {
		Usuario user1 = new Usuario();
		user1.setNome("Daniel");
		user1.setEmail("d@123.com");
		user1.setNickname("Daniel");
		user1.setSenha("12345");
		user1.setTelefone("32165497");
		System.out.println(user1);
		
		UsuarioController controle = new UsuarioController();
		System.out.println(controle.salvar(user1));
		
	}

}