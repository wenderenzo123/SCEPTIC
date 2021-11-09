package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.InsertException;
import model.dao.CompraDAO;
import model.vo.CompraVO;

public class CompraBO implements BaseInterBO<CompraVO>{
  CompraDAO dao = new CompraDAO();

  @Override
  public void inserir(CompraVO compra) throws SQLException {
    try {
			ResultSet rs = dao.listar();
			if(rs.next()) {
				throw new InsertException("Não será possivel");
			}
			else{
	         dao.inserir(compra);
				}
			}
			catch (SQLException e){
		        throw new InsertException(e.getMessage());
		    }
  }

  @Override
  public void alterar(CompraVO compra) throws SQLException {
    try {
      ResultSet rs = dao.listar();
      if (rs.next()){
        throw new InsertException("Não será possivel");
      }
      else{
        dao.remover(compra);
      }
      }
      catch (SQLException e){
        throw new InsertException(e.getMessage());
      }
    
  }

  @Override
  public void remover(CompraVO compra) throws SQLException {
    try {
      ResultSet rs = dao.listar();
      if (rs.next()){
        throw new InsertException("Não será possivel");
      }
      else{
        dao.remover(compra);
      }
      }
      catch (SQLException e){
        throw new InsertException(e.getMessage());
      }
    
  }

  @Override
  public List<CompraVO> listarPorId(CompraVO entity) throws SQLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<CompraVO> listarPorNome(CompraVO entity) throws SQLException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<CompraVO> listar() throws SQLException {
    List<CompraVO> list = new ArrayList<CompraVO>();
    CompraVO vo2 = new CompraVO();
    try {
      ResultSet rs = dao.listar();
      while(rs.next()) {
        vo2.setDataCompra("dt_compra");
        list.add(vo2);
      }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }
}
