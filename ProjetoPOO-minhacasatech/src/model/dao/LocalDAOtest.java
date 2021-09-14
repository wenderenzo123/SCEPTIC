package model.dao;
import model.vo.LocalVO;
import java.util.List;
public class LocalDAOtest{
	public static void main(String[] args)  {
    //inserir_local();
		//listar_local();
    //remover_local();
    //alterar_local();
	}
  private static void listar_local(){
    LocalDAO dao = new LocalDAO();
    List<LocalVO> list= dao.listar_local();
	  for (LocalVO vo_0: list) {
		System.out.println("Id: "+vo_0.getId()+ ", Nome: "+vo_0.getNome()+", Compartimento: "+vo_0.getCompartimento());
	}
  }
  private static void inserir_local(){
    LocalVO vo = new LocalVO();
		LocalDAO dao = new LocalDAO();
    vo.setNome("Robin");
    vo.setCompartimento("Batcaverna");
		
		if(dao.inserir_local(vo)) {
			System.out.println("Salvo com sucesso");
		}
		else {
			System.out.println("Erro ao salvar");
				
		}
  }
  private static void remover_local(){
    LocalVO vo = new LocalVO();
		LocalDAO dao = new LocalDAO();
    vo.setId(new Long (9));
		if(dao.remover_local(vo)) {
			System.out.println("Salvo com sucesso");
		}
		else {
			System.out.println("Erro ao salvar");
				
		}
  }
  private static void alterar_local(){
    LocalVO vo = new LocalVO();
		LocalDAO dao = new LocalDAO();
    vo.setNome("Robin");
    vo.setCompartimento("teen titans");
    vo.setId(new Long (7));
		if(dao.alterar_local(vo)) {
			System.out.println("Salvo com sucesso");
		}
		else {
			System.out.println("Erro ao salvar");
				
		}
  }
}