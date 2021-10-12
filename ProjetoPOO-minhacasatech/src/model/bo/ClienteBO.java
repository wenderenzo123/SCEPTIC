package model.bo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import model.InsertException;
import modelDAO.ClienteDAO;
import modelDAO.PessoaDAO;
import model.vo.ClienteVO;

public class ClienteBO implements BaseInterBO<ClienteVO> {
	PessoaDAO dao0 = new ClienteDAO();
	public void inserir(ClienteVO Cliente) throws SQLException {
		try {
            ResultSet rs = dao0.listar(Cliente);
            if (rs.next()){
              throw new InsertException("Não será possivel");
            }
            else{
              dao0.inserir(Cliente);
            }
      }
      catch (SQLException e){
        throw new InsertException(e.getMessage());
      }
	}
	public void remover(ClienteVO cliente) throws SQLException{
	      try {
	        ResultSet rs = dao0.listar(cliente);
	        if (rs.next()){
	          throw new InsertException("Não será possivel");
	        }
	        else{
	          dao0.remover(cliente);
	        }
	        }
	        catch (SQLException e){
	          throw new InsertException(e.getMessage());
	        }
	    }
	 
		@Override
	public List<ClienteVO> listar(ClienteVO cliente) throws SQLException {
		 List<ClienteVO> list = new ArrayList<ClienteVO>();
		 try {
			 ResultSet rs = dao0.listar(cliente);
			 while(rs.next()) {
				 ClienteVO vo2 = new ClienteVO();
				 cliente.setId(rs.getLong("id_cli"));
				 cliente.setNome(rs.getString("nome"));
				//add as demais coisas a serem exibidas(num de series, preco, quant...) (olhar no BD)
				 list.add(vo2);
			 }
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return list;
	 }
	public void alterar(ClienteVO cliente) throws SQLException{
		 try {
			 ResultSet rs = dao0.listar(cliente);
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
	public List<ClienteVO> listarPorId(ClienteVO cliente) throws SQLException {
		List<ClienteVO> list = new ArrayList<ClienteVO>();
		 try {
			 ResultSet rs = dao0.listar(cliente);
			 while(rs.next()) {
				 ClienteVO vo2 = new ClienteVO();
				 cliente.setId(rs.getLong("id_cli"));
				 list.add(vo2);
			 }
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return list;
	}
	@Override
	public List<ClienteVO> listarPorNome(ClienteVO cliente) throws SQLException {
		List<ClienteVO> list = new ArrayList<ClienteVO>();
		 try {
			 ResultSet rs = dao0.listar(cliente);
			 while(rs.next()) {
				 ClienteVO vo2 = new ClienteVO();
				 cliente.setNome(rs.getString("nome"));
				 list.add(vo2);
			 }
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return list;
	}
	
}