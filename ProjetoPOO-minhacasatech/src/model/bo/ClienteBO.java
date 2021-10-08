package model.bo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import model.InsertException;

import model.dao.ClienteDAO;
import model.vo.ClienteVO;

public class ClienteBO<VO extends ClienteVO> implements BaseInterBO<ClienteVO> {
	static private ClienteDAO dao0 = new ClienteDAO();
	
	public void inserir(ClienteVO Cliente) throws SQLException {
		try {
            ResultSet rs = dao0.listar();
            if (rs.next()){
              throw new InsertException("Não será possivel");
            }
            else{
              dao0.inserir_clien(Cliente);
            }
      }
      catch (SQLException e){
        throw new InsertException(e.getMessage());
      }
	}
	public void remover(ClienteVO cliente) throws SQLException{
	      try {
	        ResultSet rs = dao0.listar();
	        if (rs.next()){
	          throw new InsertException("Não será possivel");
	        }
	        else{
	          dao0.remover_clien(cliente);
	        }
	        }
	        catch (SQLException e){
	          throw new InsertException(e.getMessage());
	        }
	    }
	 
		@Override
		public ResultSet listar() throws SQLException {
		 ResultSet rs = dao0.listar();
		 List<ClienteVO> list = new ArrayList<ClienteVO>();
		 try {
			 while(rs.next()) {
				 ClienteVO vo = new ClienteVO();
				 vo.setId(rs.getLong("id_cli"));
				 vo.setNome(rs.getString("nome_cli"));
				 list.add(vo);
			 }
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return rs;
	 }
	public void alterar(ClienteVO cliente) throws SQLException{
	ResultSet rs = dao0.listar();
		 try {
		    if (rs.next()) {
		       throw new InsertException("Não será possivel");
		     }
		    else{
		       dao0.alterar(cliente);
		     }
		     }
		    catch (SQLException e){
		      throw new InsertException(e.getMessage());
		  	}
		}
	@Override
	public ResultSet listarPorId(ClienteVO entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultSet listarPorNome(ClienteVO entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}