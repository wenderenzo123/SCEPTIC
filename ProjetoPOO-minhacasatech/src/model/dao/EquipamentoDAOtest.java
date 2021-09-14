package model.dao;
import model.vo.EquipamentoVO;
import model.vo.FuncionarioVO;
import model.vo.LocalVO;
import java.util.List;

public class EquipamentoDAOtest {
  public static void main(String[] args)  {
    //inserir_eq();
	  //listar_eq();
    //remover_eq();
    //alterar_eq();
	}
  private static void listar_eq(){
    EquipamentoDAO dao = new EquipamentoDAO();
    List<EquipamentoVO> list= dao.listar_eq();
	  for (EquipamentoVO vo_0: list) {
		System.out.println("Id: "+vo_0.getId()+ ", Nome: "+vo_0.getNome()+" , Preço: "+vo_0.getPreco());
	}
  }
  private static void inserir_eq(){
    EquipamentoVO vo = new EquipamentoVO();
		EquipamentoDAO dao = new EquipamentoDAO();
    FuncionarioVO fu = new FuncionarioVO();
    LocalVO  lo = new LocalVO();
    vo.setNome("Monitor");
    vo.setPeso(3);
    vo.setNumeroDeSerie(1233412);
    vo.setPreco(989);
		vo.setQuantidade(13);
    fu.setId(new Long (1));
    vo.setResponsavel(fu);
    lo.setId(new Long (5));
    vo.setLocal(lo);
		if(dao.inserir_eq(vo,lo,fu)) {
			System.out.println("Salvo com sucesso");
		}
		else {
			System.out.println("Erro ao salvar");
				
		}
  }
  private static void remover_eq(){
    EquipamentoVO vo = new EquipamentoVO();
    EquipamentoDAO dao = new EquipamentoDAO();
    vo.setId(new Long (2));
		if(dao.remover_eq(vo)) {
			System.out.println("Salvo com sucesso");
		}
		else {
			System.out.println("Erro ao salvar");
				
		}
  }
  private static void alterar_eq(){
    EquipamentoVO vo = new EquipamentoVO();
		EquipamentoDAO dao = new EquipamentoDAO();
    vo.setNome("Teclado");
    vo.setPreco(55);
    vo.setId(new Long (1));
		if(dao.alterar_eq(vo)) {
			System.out.println("Salvo com sucesso");
		}
		else {
			System.out.println("Erro ao salvar");
				
		}
  }
}
