package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import VO.Filme;
import VO.Usuario;

public class FilmeDAO extends BaseDAO<Filme> {

	@Override
	public String getColunasDelete() {
		return " idProducao ";
	}

	@Override
	public String getColunaPrimaria() {
		return " idProducao ";
	}

	@Override
	public String getInterrogacoesInsert() {
		return " ?,?,?,?,?,? ";
	}

	@Override
	public String getNomeTabela() {
		return " idProducao ";
	}

	@Override
	public String getColunasInsert() {
		return " titulo, ano, genero, diretor, sinopse, duracao ";
	}

	@Override
	public String getValoresEntidadesUpdate(Filme entidade) {
		return " titulo = ? , ano = ? , genero = ? ,diretor = ?, sinopse = ?, duracao = ? ";
	}

	@Override
	public void setValoresAtributosInsert(Filme entidade, PreparedStatement prepareStm) {
		try {
			prepareStm.setString(1, entidade.getTitulo() + "");
			prepareStm.setInt(2, entidade.getAno());
			prepareStm.setString(3, entidade.getGenero().getIdGenero() + "");
			prepareStm.setString(4, entidade.getDiretor() + "");
			prepareStm.setString(5, entidade.getSinopse() + "");
			prepareStm.setInt(6, entidade.getDuracao());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setValoresAtributosUpdate(Filme entidade, PreparedStatement stmt) {

	}

	@Override
	public Filme construirObjetoConsultado(ResultSet resultado) throws SQLException {
		Filme filme = new Filme();
		GeneroDAO genDao = new GeneroDAO();
		ArtistaDAO artDao = new ArtistaDAO();

		filme.setIdProducao(resultado.getInt("idProducao"));
		filme.setTitulo(resultado.getString("titulo"));
		filme.setAno(resultado.getInt("ano"));
		filme.setDiretor(resultado.getString("diretor"));
		filme.setGenero(genDao.pesquisaPorId(Integer.parseInt(resultado.getString("genero"))));
		filme.setArtistas(artDao.buscaArtistasPorProducao(filme));

		return filme;
	}

	public Filme buscaFilme(int idProducao) {
		String sql = (" SELECT * FROM producao where idProducao = " + idProducao);

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Filme objetoPesquisado = null;

		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
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
		String sql = (" SELECT idProducao, titulo,	ano, genero, diretor, sinopse, duracao FROM producao where idProducao not in (select idProducao from producoesAssistidos where idUsuario = " + usuario.getIdUsuario() + " ) order by rand() limit 1 ");

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Filme objetoPesquisado = null;

		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
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
