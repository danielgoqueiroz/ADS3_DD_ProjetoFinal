package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import VO.Usuario;

public class UsuarioDAO extends BaseDAO<Usuario> {

	@Override
	public String getColunasDelete() {
		return " idUsuario ";
	}

	@Override
	public String getColunaPrimaria() {
		return " idUsuario ";
	}

	
	@Override
	public String getInterrogacoesInsert() {
		return " ?,?,?,?,? ";
	}

	@Override
	public String getNomeTabela() {
		return " usuario ";
	}
	
	@Override
	public String getColunasInsert() {
		return " nome, nickname, email, telefone, senha ";
	}


	
	

	public Usuario buscaUsuarioPorNome(String nome) {
		return null;
	}

	

	@Override
	public String getValoresEntidadesUpdate(Usuario entidade) {
		String clausulaSet = (" idUsuario = ?, nickname = ? , email = ?, senha = ? ");
		return clausulaSet;
	}

	@Override
	public void setValoresAtributosInsert(Usuario entidade, PreparedStatement prepareStm) {
		try {
			prepareStm.setString(1, entidade.getNome());
			prepareStm.setString(2, entidade.getNickname());
			prepareStm.setString(3, entidade.getEmail());
			prepareStm.setString(4, entidade.getTelefone());
			prepareStm.setString(5, entidade.getSenha());
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void setValoresAtributosUpdate(Usuario entidade, PreparedStatement stmt) {
		
	}

	@Override
	public Usuario construirObjetoConsultado(ResultSet resultado) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(resultado.getInt("idUsuario"));
		usuario.setEmail(resultado.getString("email"));
		usuario.setNome(resultado.getString("nome"));
		usuario.setTelefone(resultado.getString("telefone"));
		usuario.setSenha(resultado.getString("senha"));
		usuario.setNickname(resultado.getString("nickname"));

		return usuario;
	}

	public Usuario buscaUsuarioPorNick(String nick) {
		String sql = (" SELECT * FROM danie648_db_ads3_dd_filme.usuario where nickname = '" + nick + "'");
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Usuario usuario = null;
		
		try {
			resultado = stmt.executeQuery(sql);
			while(resultado.next()) {
				usuario = construirObjetoConsultado(resultado);
//				usuario.setNome(resultado.getString(2));
				

			}
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		
		return usuario;
	}

	public Usuario realizarLogin(Usuario usuario) {
		String nick = usuario.getNickname() + "";
		String senha = usuario.getSenha() + "";
		System.out.println(senha.toString());
		String sql = (" SELECT * FROM danie648_db_ads3_dd_filme.usuario where nickname = '" + nick + "' and senha = " + senha );
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		
		
		try {
			resultado = stmt.executeQuery(sql);
			while(resultado.next()) {
				usuario = construirObjetoConsultado(resultado);
//				usuario.setNome(resultado.getString(2));
				

			}
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		
		return usuario;
	}

	public Usuario buscaUsuarioPorEmail(String email) {
String sql = (" SELECT * FROM danie648_db_ads3_dd_filme.usuario where email = '" + email + "'");
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Usuario usuario = null;
		
		try {
			resultado = stmt.executeQuery(sql);
			while(resultado.next()) {
				usuario = construirObjetoConsultado(resultado);
//				usuario.setNome(resultado.getString(2));
				

			}
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		
		return usuario;
		
		
	}

	
	

}
