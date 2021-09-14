package model.dao;
import model.vo.ClienteVO;
import java.util.List;

public class ClienteDAOtest {
  public static void main(String[] args)  {
    //inserir_clien();
	  //listar_clien();
    //remover_clien();
    //alterar_clien();
	}
  private static void listar_clien(){
    ClienteDAO dao = new ClienteDAO();
    List<ClienteVO> list= dao.listar_clien();
	  for (ClienteVO vo_0: list) {
		System.out.println("Id: "+vo_0.getId()+ ", Nome: "+vo_0.getNome()+", CPF: "+vo_0.getCPF());
	}
  }
  private static void inserir_clien(){
    ClienteVO vo = new ClienteVO();
		ClienteDAO dao = new ClienteDAO();
    vo.setNome("Harry");
    vo.setEndereco("Hogwarts");
    vo.setCPF(01723);
		
		if(dao.inserir_clien(vo)) {
			System.out.println("Salvo com sucesso");
		}
		else {
			System.out.println("Erro ao salvar");
				
		}
  }
  private static void remover_clien(){
    ClienteVO vo = new ClienteVO();
    ClienteDAO dao = new ClienteDAO();
    vo.setId(new Long (2));
		if(dao.remover_clien(vo)) {
			System.out.println("Salvo com sucesso");
		}
		else {
			System.out.println("Erro ao salvar");
				
		}
  }
  private static void alterar_clien(){
    ClienteVO vo = new ClienteVO();
		ClienteDAO dao = new ClienteDAO();
    vo.setNome("Hermione");
    vo.setCPF(934);
    vo.setId(new Long (1));
		if(dao.alterar_clien(vo)) {
			System.out.println("Salvo com sucesso");
		}
		else {
			System.out.println("Erro ao salvar");
				
		}
  }
}
