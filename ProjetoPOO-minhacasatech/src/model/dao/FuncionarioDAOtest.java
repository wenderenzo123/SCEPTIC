package model.dao;
import model.vo.FuncionarioVO;
import java.util.List;
public class FuncionarioDAOtest {
  public static void main(String[] args)  {
    //inserir_func();
	  listar_func();
    //remover_func();
    //alterar_func();
	}
  private static void listar_func(){
    FuncionarioDAO dao = new FuncionarioDAO();
    List<FuncionarioVO> list= dao.listar_func();
	  for (FuncionarioVO vo_0: list) {
		System.out.println("Id: "+vo_0.getId());
	}
  }
  private static void inserir_func(){
    FuncionarioVO vo = new FuncionarioVO();
		FuncionarioDAO dao = new FuncionarioDAO();
    vo.setNome("Robin");
    vo.setEndereco("Superman N - 120");
    vo.setTelefone(999);
    vo.setEmail("tech@gmail.com");
    vo.setSenha("tech123");
    vo.setTipo(0);
		
		if(dao.inserir_func(vo)) {
			System.out.println("Salvo com sucesso");
		}
		else {
			System.out.println("Erro ao salvar");
				
		}
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

