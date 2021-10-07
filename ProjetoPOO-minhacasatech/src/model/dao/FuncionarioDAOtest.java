package model.dao;
import model.vo.FuncionarioVO;
import model.vo.PessoaVO;

import java.sql.SQLException;
import java.util.List;
public class FuncionarioDAOtest {
  public static void main(String[] args) throws SQLException  {
    inserir_func();
	  //listar_func();
    //remover_func();
    //alterar_func();
	}
  private static void listar_func(){
    FuncionarioDAO dao = new FuncionarioDAO();
    List<FuncionarioVO> list= dao.listar();
	  for (FuncionarioVO vo_0: list) {
		System.out.println("Id: "+vo_0.getId());
	}
  }
  private static void inserir_func() throws SQLException{
    FuncionarioVO vo = new FuncionarioVO();
    PessoaVO vo2 = new PessoaVO();
		FuncionarioDAO dao = new FuncionarioDAO();
    vo.setNome("Robin");
    vo.setEndereco("Superman N - 120");
    vo2.setTelefone(999);
    vo.setEmail("tech@gmail.com");
    vo.setSenha("tech123");
    vo.setTipo(0);
		dao.inserir(vo);
  }
  private static void remover_func(){
    FuncionarioVO vo = new FuncionarioVO();
		FuncionarioDAO dao = new FuncionarioDAO();
    vo.setId(new Long (2));
		if(dao.remover_func(vo)) {
			System.out.println("Salvo com sucesso");
		}
		else {
			System.out.println("Erro ao salvar");
				
		}
  }
  private static void alterar_func(){
    FuncionarioVO vo = new FuncionarioVO();
		FuncionarioDAO dao = new FuncionarioDAO();
    vo.setNome("Batman");
    vo.setId(new Long (3));
		if(dao.alterar_func(vo)) {
			System.out.println("Salvo com sucesso");
		}
		else {
			System.out.println("Erro ao salvar");
				
		}
  }
}

