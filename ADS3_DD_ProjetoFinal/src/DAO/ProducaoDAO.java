package DAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import VO.Producao;
import VO.Usuario;

public class ProducaoDAO extends BaseDAO<Producao> {

	@Override
	public String getColunasDelete() {
		return "idProducao";
	}

	@Override
	public String getColunaPrimaria() {
		return " idProducao ";
	}

	@Override
	public String getInterrogacoesInsert() {
		return " ?,?,?,?,?,?,? ";
	}

	@Override
	public String getNomeTabela() {
		return " idProducao ";
	}

	@Override
	public String getColunasInsert() {
		return " titulo, ano, genero, diretor, sinopse, capa, duracao ";
	}

	@Override
	public String getValoresEntidadesUpdate(Producao entidade) {
		return " titulo = ? , ano = ? , genero = ? ,diretor = ?, sinopse = ?, capa = ?, duracao = ? ";
	}

	@Override
	public void setValoresAtributosInsert(Producao entidade, PreparedStatement prepareStm) {
		try {			
//			File image = new File(entidade.getCapa());
//			
//			FileInputStream fis = new FileInputStream(image);
			
			prepareStm.setString(1, entidade.getTitulo() + "");
			prepareStm.setInt(2, entidade.getAno());
			prepareStm.setString(3, entidade.getGenero().getIdGenero() + "");
			prepareStm.setString(4, entidade.getDiretor() + "");
			prepareStm.setString(5, entidade.getSinopse() + "");
			prepareStm.setBytes(7, entidade.getCapa());
//			prepareStm.setBinaryStream(3, (InputStream) fis, (int) (image.length()));
			prepareStm.setInt(7, entidade.getDuracao());

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setValoresAtributosUpdate(Producao entidade, PreparedStatement stmt) {

	}

	@Override
	public Producao construirObjetoConsultado(ResultSet resultado) throws SQLException {
		Producao Producao = new Producao();
		GeneroDAO genDao = new GeneroDAO();
		ArtistaDAO artDao = new ArtistaDAO();

		Producao.setIdProducao(resultado.getInt("idProducao"));
		Producao.setTitulo(resultado.getString("titulo"));
		Producao.setAno(resultado.getInt("ano"));
		Producao.setDiretor(resultado.getString("diretor"));
		Producao.setSinopse(resultado.getString("sinopse"));

		Producao.setGenero(genDao.pesquisaPorDescricao(resultado.getString("genero")));		
		Producao.setArtistas(artDao.buscaArtistasPorProducao(Producao));
		Producao.setCapa(resultado.getBytes("capa"));
		Producao.setDuracao(resultado.getInt("duracao"));
		
		return Producao;
	}

	public Producao buscaProducao(int idProducao) {
		String sql = (" SELECT * FROM producao where idProducao = " + idProducao);

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Producao objetoPesquisado = null;

		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				objetoPesquisado = construirObjetoConsultado(resultado);
			}
		} catch (Exception e) {
			System.out.println("Erro busca produção " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}

		return objetoPesquisado;
	}

	public Producao buscaProducaoNaoAssistido(Usuario usuario) {
		String sql = (" SELECT idProducao,  titulo, genero, ano, diretor, sinopse, capa, duracao, sinopse, qtdTemporada FROM producao "
				+ "where idProducao not in (select idProducao from producoesAssistidas where idUsuario = " + usuario.getIdUsuario() + " ) "
						+ "order by rand() limit 1 ");
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Producao objetoPesquisado = null;

		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				objetoPesquisado = construirObjetoConsultado(resultado);
			}
		} catch (Exception e) {
			System.out.println("Erro buscaProd. " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}

		return objetoPesquisado;
	}

}
