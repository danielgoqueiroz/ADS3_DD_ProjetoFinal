package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import VO.EnumTipoProducao;
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
		return " ?,?,?,?,?,?,?,?,? ";
	}

	@Override
	public String getNomeTabela() {
		return " producao ";
	}

	@Override
	public String getColunasInsert() {
		return " tipo, titulo, ano, sinopse, genero, diretor, duracao, qtdTemporada, capa ";
	}

	@Override
	public String getValoresEntidadesUpdate(Producao entidade) {
		if (entidade.getCapa() != null)
			return " tipo = ? , titulo = ? , ano = ? , sinopse = ? , genero = ? , diretor = ? , duracao = ? , qtdTemporada = ? , capa = ? ";

		return " tipo = ? , titulo = ? , ano = ? , sinopse = ? , genero = ? , diretor = ? , duracao = ? , qtdTemporada = ? ";
	}

	@Override
	public void setValoresAtributosInsert(Producao entidade, PreparedStatement prepareStm) {
		try {
			prepareStm.setString(1, entidade.getTipo().toString() + "");
			prepareStm.setString(2, entidade.getTitulo() + "");
			prepareStm.setInt(3, entidade.getAno());
			prepareStm.setString(4, entidade.getSinopse() + "");
			prepareStm.setString(5, entidade.getGenero().getIdGenero() + "");
			prepareStm.setString(6, entidade.getDiretor() + "");
			prepareStm.setInt(7, entidade.getDuracao());
			prepareStm.setInt(8, entidade.getQtdTemporadas());
			prepareStm.setBytes(9, entidade.getCapa());	

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		producao.setGenero(genDao.pesquisaPorId(resultado.getInt("genero")));
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

	public Producao buscaProducaoNaoAssistido(Usuario usuario) {
		String sql = (" SELECT idProducao," + getColunasInsert() + " FROM producao "
				+ "where idProducao not in (select idProducao from producoesAssistidas where idUsuario = "
				+ usuario.getIdUsuario() + " ) " + "order by rand() limit 1 ");
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

	public ArrayList<Producao> buscaProducoesNaoAssistidas(Usuario usuario) {
		ArrayList<Producao> producoes = new ArrayList<>();
		String sql = (" SELECT idProducao," + getColunasInsert() + " FROM producao "
				+ "where idProducao not in (select idProducao from producoesAssistidas where idUsuario = "
				+ usuario.getIdUsuario() + " ) " + "order by rand()");
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Producao objetoPesquisado = new Producao();

		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				objetoPesquisado = construirObjetoConsultado(resultado);
				producoes.add(objetoPesquisado);
			}
		} catch (Exception e) {
			System.out.println("Erro buscaProd. " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}

		return producoes;
	}

	@Override
	public void setValoresAtributosUpdate(Producao entidade, PreparedStatement stmt) {
		try {
			stmt.setString(1, entidade.getTipo().toString() + "");
			stmt.setString(2, entidade.getTitulo() + "");
			stmt.setInt(3, entidade.getAno());
			stmt.setString(4, entidade.getSinopse() + "");
			stmt.setString(5, entidade.getGenero().getIdGenero() + "");
			stmt.setString(6, entidade.getDiretor() + "");
			stmt.setInt(7, entidade.getDuracao());
			stmt.setInt(8, entidade.getQtdTemporadas());
			if (entidade.getCapa() != null)
				stmt.setBytes(9, entidade.getCapa());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public double BuscarMediaProducao(Producao p) {
		double valor = 0;

		String sql = (" SELECT avg(nota) nota FROM producoesAssistidas where idProducao =  " + p.getIdProducao());

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				valor = resultado.getDouble("nota");
			}
		} catch (Exception e) {
			System.out.println("Erro busca produção " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}

		return valor;

	}

	public ArrayList<Producao> buscarProducoesAssistidas(Usuario usuario) {

		ArrayList<Producao> producoes = new ArrayList<Producao>();

		String sql = (" SELECT * from producao inner join producoesAssistidas on producoesAssistidas.idproducao = producao.idproducao "
				+ "inner join usuario on usuario.idusuario = producoesAssistidas.idusuario where usuario.idusuario = "+ usuario.getIdUsuario()+"; ");
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Producao objetoPesquisado = new Producao();

		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {

				objetoPesquisado = construirObjetoConsultado(resultado);
				objetoPesquisado.setNota(resultado.getDouble("nota"));

				producoes.add(objetoPesquisado);

			}
		} catch (Exception e) {
			System.out.println("Erro buscaProd. " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}

		return producoes;
	}

	@Override
	public ArrayList<Producao> listarTodos() {
		String sql = ("SELECT * FROM  producao");

		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;

		ArrayList<Producao> listaObjetos = new ArrayList<>();
		try {
			resultado = stmt.executeQuery();
			while (resultado.next()) {
				Producao objeto = construirObjetoConsultado(resultado);
				listaObjetos.add(objeto);
			}
		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaObjetos;
	}

	public ArrayList<Producao> buscarProducoesAssistidas(Usuario usuario, int genero) {
		ArrayList<Producao> producoes = new ArrayList<Producao>();

		String sql = ("SELECT * from producao inner join producoesAssistidas on producoesAssistidas.idproducao = producao.idproducao "
				+ "inner join usuario on usuario.idusuario = producoesAssistidas.idusuario where usuario.idusuario = "+ usuario.getIdUsuario() + " and producao.genero = '" + genero + "'");
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		Producao objetoPesquisado = new Producao();

		try {
			resultado = stmt.executeQuery(sql);
			while (resultado.next()) {

				objetoPesquisado = construirObjetoConsultado(resultado);
				objetoPesquisado.setNota(resultado.getDouble("nota"));

				producoes.add(objetoPesquisado);

			}
		} catch (Exception e) {
			System.out.println("Erro buscaProd. " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(stmt);
		}

		return producoes;
	}
}
