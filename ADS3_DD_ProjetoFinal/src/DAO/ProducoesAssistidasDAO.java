package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import VO.Artista;
import VO.ArtistaProducao;
import VO.Producao;
import VO.ProducoesAssistidas;
import VO.Usuario;
import controller.ArtistaProducaoController;

public class ProducoesAssistidasDAO extends BaseDAO<ProducoesAssistidas> {

	public void cadastrarProducaoAssistidas(ProducoesAssistidas producaoAssitida) {

	}

	@Override
	public String getColunasDelete() {

		return "idproducao";
	}

	@Override
	public String getColunaPrimaria() {

		return "idproducoesAssistidas";
	}

	@Override
	public String getInterrogacoesInsert() {

		return " ?, ?, ? ";
	}

	@Override
	public String getNomeTabela() {

		return "producoesAssistidas";
	}

	@Override
	public String getColunasInsert() {

		return " idUsuario, idProducao, nota ";
	}

	@Override
	public String getValoresEntidadesUpdate(ProducoesAssistidas entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProducoesAssistidas construirObjetoConsultado(ResultSet resultado) throws SQLException {
		Producao producao = new Producao();
		Usuario usuario = new Usuario();
		ProducoesAssistidas producaoAssistida = new ProducoesAssistidas();

		producao.setIdProducao(resultado.getInt("idProducao"));
		usuario.setIdUsuario(resultado.getInt("idUsuario"));

		producaoAssistida.setNota(resultado.getInt("nota"));
		producaoAssistida.setProducao(producao);
		producaoAssistida.setUsuario(usuario);

		return producaoAssistida;

	}

	@Override
	public void setValoresAtributosInsert(ProducoesAssistidas entidade, PreparedStatement prepareStm) {
		try {

			prepareStm.setInt(1, entidade.getUsuario().getIdUsuario());
			prepareStm.setInt(2, entidade.getProducao().getIdProducao());
			prepareStm.setInt(3, entidade.getNota());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setValoresAtributosUpdate(ProducoesAssistidas entidade, PreparedStatement stmt) {
		// TODO Auto-generated method stub

	}
	
}
