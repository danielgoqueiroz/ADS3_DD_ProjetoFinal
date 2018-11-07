package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import VO.EnumTipoProducao;
import VO.Producao;
import VO.Usuario;

public class ProducaoDAO extends BaseDAO<Producao> {
	// OK
	@Override
	public String getColunasDelete() {
		return "idProducao";
	}

	// OK
	@Override
	public String getColunaPrimaria() {
		return " idProducao ";
	}

	// OK
	@Override
	public String getInterrogacoesInsert() {
		return " ?,?,?,?,?,?,?,?,? ";
	}

	// OK
	@Override
	public String getNomeTabela() {
		return " producao ";
	}

	// OK
	@Override
	public String getColunasInsert() {
		return " tipo, titulo, ano, sinopse, genero, diretor, capa, duracao, qtdTemporada ";
	}

	// OK
	@Override
	public String getValoresEntidadesUpdate(Producao entidade) {
		return " tipo = ? , titulo = ? , ano = ? , sinopse = ? , genero = ? , diretor = ? , capa = ? , duracao = ? , qtdTemporada = ? ";
	}

	// OK
	@Override
	public void setValoresAtributosInsert(Producao entidade, PreparedStatement prepareStm) {
		try {
			prepareStm.setString(1, entidade.getTipo().toString() + "");
			prepareStm.setString(2, entidade.getTitulo() + "");
			prepareStm.setInt(3, entidade.getAno());
			prepareStm.setString(4, entidade.getSinopse() + "");
			prepareStm.setString(5, entidade.getGenero().getIdGenero() + "");
			prepareStm.setString(6, entidade.getDiretor() + "");
			prepareStm.setBytes(7, entidade.getCapa());
			prepareStm.setInt(8, entidade.getDuracao());
			prepareStm.setInt(9, entidade.getQtdTemporadas());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// OK
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
			System.out.println("Erro busca produ��o " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}

		return objetoPesquisado;
	}

	// OK
	@Override
	public Producao construirObjetoConsultado(ResultSet resultado) throws SQLException {
		Producao producao = new Producao();
		GeneroDAO genDao = new GeneroDAO();
		ArtistaDAO artDao = new ArtistaDAO();

		String tipo = resultado.getString("tipo") + "";

		String qtdTemporada = resultado.getString("qtdTemporada") + "";
		String duracao = resultado.getString("duracao") + "";

		producao.setIdProducao(resultado.getInt("idProducao"));
		producao.setTitulo(resultado.getString("titulo"));
		producao.setAno(resultado.getInt("ano"));
		producao.setSinopse(resultado.getString("sinopse"));
		producao.setGenero(genDao.pesquisaPorDescricao(resultado.getString("genero")));
		producao.setDiretor(resultado.getString("diretor"));
		producao.setCapa(resultado.getBytes("capa"));

		if (!duracao.isEmpty())
			producao.setDuracao(resultado.getInt("duracao"));

		if (!qtdTemporada.isEmpty())
			producao.setQtdTemporadas(resultado.getInt("qtdTemporada"));

		if (!tipo.isEmpty())
			producao.setTipo(EnumTipoProducao.valueOf(resultado.getString("tipo")));

		producao.setArtistas(artDao.buscaArtistasPorProducao(producao));

		return producao;
	}

	// OK
	public Producao buscaProducaoNaoAssistido(Usuario usuario) {
		String sql = (" SELECT idProducao," + getColunasInsert() + " FROM producao " 
         + "where idProducao not in (select idProducao from producoesAssistidas where idUsuario = " + usuario.getIdUsuario() + " ) " + "order by rand() limit 1 "
		);
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Producao objetoPesquisado = new Producao();

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

	// TODO
	@Override
	public void setValoresAtributosUpdate(Producao entidade, PreparedStatement stmt) {

	}

	public double BuscarMediaProducao(Producao p) 
	{
		double valor=0;
		
		String sql = (" SELECT avg(nota) nota FROM danie648_db_ads3_dd_filme.producoesAssistidas where idProducao =  " + p.getIdProducao());

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Producao objetoPesquisado = null;

		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				valor = resultado.getDouble("nota");
			}
		} catch (Exception e) {
			System.out.println("Erro busca produ��o " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}

		return valor;
		
	}
}