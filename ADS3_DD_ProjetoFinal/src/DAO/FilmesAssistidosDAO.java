package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.VO.FilmesAssistidos;

public class FilmesAssistidosDAO {

	public int cadastrarFilmesAssitidos(FilmesAssistidos filmeAssitido) {
		
			String sql = (" INSERT INTO filmesassitidos (idusuario, idfilme, nota) VALUES ( " + filmeAssitido.getUsuario().getIdUsuario() +"," + filmeAssitido.getFilme().getIdFilme() + ", " + filmeAssitido.getFilme().getNota() + " );"); 
			
			Connection conn = Banco.getConnection();
			PreparedStatement prepareStm = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);
			int idEntidade = -1;
			
			try {
//				this.setValoresAtributosInsert(entidade, prepareStm);
				prepareStm.executeUpdate();
				ResultSet rs = prepareStm.getGeneratedKeys();
				
				if(rs.next()) {
					idEntidade = rs.getInt(1);
				} 
				
			} catch (SQLException e) {
				System.out.println("Erro " + e.getMessage());
			} finally {
				Banco.closeStatement(prepareStm);
				Banco.closeConnection(conn);
			}
			
			return idEntidade;
		
		
	}

}
