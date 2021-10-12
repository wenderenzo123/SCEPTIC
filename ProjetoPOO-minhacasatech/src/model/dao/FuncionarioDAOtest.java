package model.dao;
import model.vo.FuncionarioVO;
import model.vo.PessoaVO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAOtest {
  public static void main(String[] args) throws SQLException  {
    //inserir_func();
    //remover_func();
    //alterar_func();
    //listar_func();
	}
  
  private static void inserir_func() throws SQLException{
    FuncionarioVO vo = new FuncionarioVO();
		FuncionarioDAO dao = new FuncionarioDAO();
    vo.setNome("Robin");
    vo.setEndereco("Superman N - 120");
    vo.setTelefone("99999999");
    vo.setEmail("tech@gmail.com");
    vo.setSenha("tech123");
    vo.setTipo(1);
		dao.inserir(vo);
  }
  private static void remover_func(){
    FuncionarioVO vo = new FuncionarioVO();
		FuncionarioDAO dao = new FuncionarioDAO();
    vo.setId((long)1);
	  dao.remover(vo);
  }
  private static void alterar_func(){
    FuncionarioVO vo = new FuncionarioVO();
		FuncionarioDAO dao = new FuncionarioDAO();
    vo.setTipo(0);
    vo.setId((long) 3);
		dao.alterar(vo);
  }
  private static void listar_func(){
    FuncionarioDAO dao = new FuncionarioDAO();
    ResultSet list = dao.listar();
	//   for (FuncionarioVO vo_0: list) {
	// 	System.out.println("Id: "+vo_0.getId());
	// }
  }
}

