package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseInterBO<VO>{
  public void inserir(VO entity) throws SQLException;
	public void alterar(VO entity) throws SQLException;
	public void remover(VO entity) throws SQLException;
	public ResultSet listarPorId(VO entity) throws SQLException;
	public ResultSet listarPorNome(VO entity) throws SQLException;
	public ResultSet listar() throws SQLException;
}
