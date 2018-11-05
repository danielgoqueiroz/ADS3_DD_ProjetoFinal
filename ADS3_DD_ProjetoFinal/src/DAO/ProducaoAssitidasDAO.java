package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import VO.Producao;
import VO.ProducaoAssistida;
import VO.Usuario;

public class ProducaoAssitidasDAO extends BaseDAO<ProducaoAssistida> {

	public void cadastrarProducaoAssistidas(ProducaoAssistida producaoAssitida) {

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
	public String getValoresEntidadesUpdate(ProducaoAssistida entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProducaoAssistida construirObjetoConsultado(ResultSet resultado) throws SQLException {
		Producao producao = new Producao();
		Usuario usuario = new Usuario();
		ProducaoAssistida producaoAssistida = new ProducaoAssistida();

		producao.setIdProducao(resultado.getInt("idProducao"));
		usuario.setIdUsuario(resultado.getInt("idUsuario"));

		producaoAssistida.setNota(resultado.getInt("nota"));
		producaoAssistida.setProducao(producao);
		producaoAssistida.setUsuario(usuario);

		return producaoAssistida;

	}

	@Override
	public void setValoresAtributosInsert(ProducaoAssistida entidade, PreparedStatement prepareStm) {
		try {

			prepareStm.setInt(1, entidade.getUsuario().getIdUsuario());
			prepareStm.setInt(2, entidade.getProducao().getIdProducao());
			prepareStm.setInt(3, entidade.getNota());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setValoresAtributosUpdate(ProducaoAssistida entidade, PreparedStatement stmt) {
		// TODO Auto-generated method stub

	}

}
