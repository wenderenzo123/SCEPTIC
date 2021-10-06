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
import model.dao.EquipamentoDAO;
import model.dao.LocalDAO;
import model.vo.FuncionarioVO;
import model.vo.PessoaVO;
import model.vo.ClienteVO;
import model.vo.LocalVO;
import model.vo.EquipamentoVO;

public class EquipamentoBO implements BaseInterBO<EquipamentoVO> {
  public void inserir(EquipamentoVO equipamento,FuncionarioVO funcionario,LocalVO local) {
		EquipamentoDAO dao = new EquipamentoDAO();
    dao.inserir_eq(equipamento, local, funcionario);
  }
  public void remover(EquipamentoVO equipamento){
    EquipamentoDAO dao = new EquipamentoDAO();
    dao.remover_eq(equipamento);
  }
  public List<EquipamentoVO> listar(){
    EquipamentoDAO dao = new EquipamentoDAO();
		ResultSet rs = dao.listar();
		List<EquipamentoVO> list = new ArrayList<EquipamentoVO>();
		try {
			while(rs.next()) {
        EquipamentoVO vo = new EquipamentoVO();
        FuncionarioVO fu = new FuncionarioVO();
				LocalVO  lo = new LocalVO();
        vo.setId(rs.getLong("id_eq"));
				vo.setNome(rs.getString("nome_eq"));
				vo.setPeso(rs.getDouble("peso_eq"));
				vo.setNumeroDeSerie(rs.getInt("num_serie_eq"));
				vo.setPreco(rs.getDouble("preco_eq"));
				vo.setQuantidade(rs.getInt("quant_eq"));
				fu.setId(rs.getLong("responsavel_id_respon"));
				lo.setId(rs.getLong("locais_id_loc"));
				list.add(vo);
      }
    }
    catch(SQLException e) {
			e.printStackTrace();
		}
    return list;
  }
  public void alterar(EquipamentoVO equipamento){
    EquipamentoDAO dao = new EquipamentoDAO();  
    dao.alterar_eq(equipamento);
  }
}
