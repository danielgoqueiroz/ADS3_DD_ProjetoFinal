package src.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.VO.Filme;
import src.VO.Usuario;

public class FilmeDAO extends BaseDAO<Filme> {


	@Override
	public String getColunasDelete() {
		// TODO Auto-generated method stub
		return " idfilme ";
	}

	@Override
	public String getColunaPrimaria() {
		// TODO Auto-generated method stub
		return " idfilme ";
	}

	
	@Override
	public String getInterrogacoesInsert() {
		// TODO Auto-generated method stub
		return " ?,?,?,?,?,?,? ";
	}

	@Override
	public String getNomeTabela() {
		// TODO Auto-generated method stub
		return " filme ";
	}
	
	@Override
	public String getColunasInsert() {
		return " titulo, ano, Genero ,Diretor , sinopse , Nota , Duracao ";
	}

		
	

	public Filme buscaFilmePorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public String getValoresEntidadesUpdate(Filme entidade) {
		String clausulaSet = " idfilme = ?, titulo = ? , ano = ? , Genero = ? ,Diretor = ?, atores = ?, sinopse = ?, Nota = ?, Duracao = ?";
				return clausulaSet;
	}

	@Override
	public void setValoresAtributosInsert(Filme entidade, PreparedStatement prepareStm) {
		try {
			prepareStm.setString(1, entidade.getTitulo() + "");
			prepareStm.setInt(2, entidade.getAno());
			prepareStm.setString(3, entidade.getGenero() + "");
			prepareStm.setString(4, entidade.getDiretor() + "");
			prepareStm.setString(5, entidade.getSinopse() + "");
			prepareStm.setString(6, entidade.getNota() + "");
			prepareStm.setInt(7, entidade.getDuracao());

			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void setValoresAtributosUpdate(Filme entidade, PreparedStatement stmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Filme construirObjetoConsultado(ResultSet resultado) throws SQLException {
		Filme filme = new Filme();
		filme.setIdFilme(resultado.getInt("idfilme"));
		filme.setTitulo(resultado.getString("titulo"));
		filme.setAno(resultado.getInt("ano"));
		filme.setGenero(resultado.getString("Genero"));
		filme.setDiretor(resultado.getString("Diretor"));
//		filme.setArtistas(resultado.getString("Artista"));
		
		return filme;
	}

	public Filme buscaFilme() {
		String sql = (" SELECT * FROM filme limit 1 ");
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Filme objetoPesquisado = null;
		
		try {
			resultado = stmt.executeQuery(sql);
			while(resultado.next()) {
				objetoPesquisado = construirObjetoConsultado(resultado);
			}
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		
		return objetoPesquisado;
	}

	public Filme buscaFilmeNaoAssistido(Usuario usuario) {
		String sql = (" SELECT idfilme, titulo,	ano, Genero, Diretor, atores, sinopse, Nota , Duracao "
				+ " FROM filme where idfilme not in (select idfilme from filmesassistidos where idusuario = " + usuario.getIdUsuario() + " ) order by rand() limit 1 ");
		
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Filme objetoPesquisado = null;
		
		try {
			resultado = stmt.executeQuery(sql);
			while(resultado.next()) {
				objetoPesquisado = construirObjetoConsultado(resultado);
			}
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}
		
		return objetoPesquisado;
	}

	
	

}
