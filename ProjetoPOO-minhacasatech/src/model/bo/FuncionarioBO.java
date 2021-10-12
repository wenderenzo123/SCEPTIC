package model.bo;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import model.InsertException;

import java.util.ArrayList;
import java.util.List;

import model.dao.FuncionarioDAO;
import model.dao.PessoaDAO;
import model.dao.ClienteDAO;
import model.dao.LocalDAO;
import model.vo.FuncionarioVO;
import model.vo.PessoaVO;
import model.vo.ClienteVO;
import model.vo.LocalVO;


public class FuncionarioBO implements BaseInterBO<FuncionarioVO>{
	PessoaDAO dao3 = new FuncionarioDAO();
    public void inserir(FuncionarioVO funcionario) throws InsertException {
      try {
            ResultSet rs = dao3.listar();
            if (rs.next()){
              throw new InsertException("Não será possivel");
            }
            else{
              dao3.inserir(funcionario);
            }
      }
      catch (SQLException e){
        throw new InsertException(e.getMessage());
      }
    }
    public void remover(FuncionarioVO funcionario) throws InsertException{
      try {
        ResultSet rs = dao3.listar();
        if (rs.next()){
          throw new InsertException("Não será possivel");
        }
        else{
          dao3.remover(funcionario);
        }
        }
        catch (SQLException e){
          throw new InsertException(e.getMessage());
        }
    }
    public List<FuncionarioVO> listar() throws SQLException {
		 List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
		 try {
			 ResultSet rs = dao3.listar();
			 FuncionarioVO vo2 = new FuncionarioVO();
			 while(rs.next()) {
				 
				vo2.setId(rs.getLong("id_res"));
				vo2.setNome(rs.getString("nome"));
				//add as demais coisas a serem exibidas(num de series, preco, quant...) (olhar no BD)
				 list.add(vo2);
			 }
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return list;
	 }
    public void alterar(FuncionarioVO funcionario) throws InsertException{
    	 try {
			 ResultSet rs = dao3.listar();
		    if (rs.next()) {
		       throw new InsertException("Não será possivel");
		     }
		    else{
		       dao3.alterar(funcionario);
		     }
		     }
		    catch (SQLException e){
		      throw new InsertException(e.getMessage());
		  	}
    }
    @Override
    public List<FuncionarioVO> listarPorId(FuncionarioVO funcionario) throws SQLException {
		List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
		 try {
			 ResultSet rs = dao3.listarPorId(funcionario);
			 while(rs.next()) {
				 FuncionarioVO vo2 = new FuncionarioVO();
				 funcionario.setId(rs.getLong("id_res"));
				 list.add(vo2);
			 }
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return list;
	}
    @Override
    public List<FuncionarioVO> listarPorNome(FuncionarioVO funcionario) throws SQLException {
		List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
		 try {
			 ResultSet rs = dao3.listarPorNome(funcionario);
			 while(rs.next()) {
				 FuncionarioVO vo2 = new FuncionarioVO();
				 funcionario.setNome(rs.getString("nome"));
				 list.add(vo2);
			 }
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return list;
	}
}
