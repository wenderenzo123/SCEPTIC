package modelDAO;
import model.vo.EquipamentoVO;
import model.vo.FuncionarioVO;
import model.vo.LocalVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EquipamentoDAOtest {
  public static void main(String[] args) throws SQLException  {
    //inserirEq();
    //removerEq();
    //alterarEq();
	//listarEq();
	}
  private static void listarEq() throws SQLException{
    EquipamentoDAO dao = new EquipamentoDAO();
    ResultSet list= dao.listar();
  }

  private static void inserirEq() throws SQLException{
    EquipamentoVO vo = new EquipamentoVO();
	EquipamentoDAO dao = new EquipamentoDAO();
    FuncionarioVO fu = new FuncionarioVO();
    LocalVO  lo = new LocalVO();
    vo.setNome("Mouse");
    vo.setPeso(2.5);
    vo.setNumeroDeSerie(123423);
    vo.setPreco(22.5);
	vo.setQuantidade(25);
    lo.setId((long) 1);
    vo.setLocal(lo);
    fu.setId((long) 2);
    vo.setResponsavel(fu);
	dao.inserir(vo);
  }
	private static void removerEq() throws SQLException{
  		EquipamentoVO vo = new EquipamentoVO();
		EquipamentoDAO dao = new EquipamentoDAO();
		vo.setId((long) (5));
		dao.remover(vo);	
		}
	private static void alterarEq() throws SQLException{
		EquipamentoVO vo = new EquipamentoVO();
		EquipamentoDAO dao = new EquipamentoDAO();
		vo.setNome("Teclado");
		vo.setPreco(55);
		vo.setId((long) 7);
		dao.alterar(vo);
	}
}
