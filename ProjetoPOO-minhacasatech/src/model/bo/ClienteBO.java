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
	
	public boolean cadastrar_cliente(VO Cliente) throws InsertException {
		try {
            ResultSet rs = dao0.listar_clien();
            if (rs.next()){
              throw new InsertException("Não será possivel");
              return false;
            }
            else{
              dao0.inserir_clien(Cliente);
              return true;
            }
      }
      catch (SQLException e){
        throw new InsertException(e.getMessage());
      }
	}
	
	 public boolean excluir_cliente(VO cliente) throws InsertException{
	      try {
	        ResultSet rs = dao0.listar_clien();
	        if (rs.next()){
	          throw new InsertException("Não será possivel");
	          return false;
	        }
	        else{
	          dao0.remover_clien(cliente);
	          return true;
	        }
	        }
	        catch (SQLException e){
	          throw new InsertException(e.getMessage());
	        }
	    }
	 
	 public ResultSet Listar(){
		 ResultSet rs = dao0.listar_clien();
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
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		 return list;
	 }
	 public boolean alterar_cliente(VO cliente) throws InsertException{
		 ResultSet rs = dao0.listar_clien();
		 try {
		        if (rs.next()) {
		          throw new InsertException("Não será possivel");
		        }
		        else{
		          dao0.alterar(cliente);
		          return true;
		        }
		        }
		        catch (SQLException e){
		          throw new InsertException(e.getMessage());
		        }
		    }
	 }
}