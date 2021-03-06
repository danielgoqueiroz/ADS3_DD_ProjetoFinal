package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import VO.EnumNivel;
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
		return " ?,?,?,?,?,? ";
	}

	@Override
	public String getNomeTabela() {
		return " usuario ";
	}

	@Override
	public String getColunasInsert() {
		return " nome, nickname, email, telefone, senha, nivel ";
	}

	@Override
	public String getValoresEntidadesUpdate(Usuario entidade) {
		String clausulaSet = (" nome = ? , email = ?, telefone = ?, senha = ?, nickname = ? ");
		return clausulaSet;
	}

	@Override
	public void setValoresAtributosInsert(Usuario entidade, PreparedStatement prepareStm) {
		try {
			prepareStm.setString(1, entidade.getNome() + "");
			prepareStm.setString(2, entidade.getNickname() + "");
			prepareStm.setString(3, entidade.getEmail() + "");
			prepareStm.setString(4, entidade.getTelefone() + "");
			prepareStm.setString(5, entidade.getSenha() + "");
			prepareStm.setString(6, entidade.getNivel().toString() + "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setValoresAtributosUpdate(Usuario entidade, PreparedStatement stmt) {
		try {
			stmt.setString(1, entidade.getNome()+ "");			
			stmt.setString(2, entidade.getEmail());
			stmt.setString(3, entidade.getTelefone() + "");
			stmt.setString(4, entidade.getSenha() + "");
			stmt.setString(5, entidade.getNickname() + "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Usuario construirObjetoConsultado(ResultSet resultado) throws SQLException {

		Usuario usuario = new Usuario();
		usuario.setIdUsuario(resultado.getInt("idUsuario"));
		usuario.setNome(resultado.getString("nome"));
		usuario.setNickname(resultado.getString("nickname"));
		usuario.setEmail(resultado.getString("email"));
		usuario.setTelefone(resultado.getString("telefone"));
		usuario.setSenha(resultado.getString("senha"));
		usuario.setNivel(EnumNivel.valueOf(resultado.getString("nivel")));

		return usuario;
	}

	public Usuario buscaUsuarioPorNick(String nick) {
		String sql = (" SELECT * FROM usuario where nickname = '" + nick + "'");

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Usuario usuario = null;

		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				usuario = construirObjetoConsultado(resultado);
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
		String sql = (" SELECT * FROM usuario where nickname = '" + nick + "' and senha = "
				+ senha);

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;

		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				usuario = construirObjetoConsultado(resultado);

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
		String sql = (" SELECT * FROM usuario where email = '" + email + "'");

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Usuario usuario = null;

		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				usuario = construirObjetoConsultado(resultado);
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
