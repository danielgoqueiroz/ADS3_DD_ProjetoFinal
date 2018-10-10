package src.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.VO.Filme;

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
		return " FILME ";
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
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
