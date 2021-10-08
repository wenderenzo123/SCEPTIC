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
  public void inserir(EquipamentoVO equipamento) throws SQLException {
		EquipamentoDAO dao = new EquipamentoDAO();
    dao.inserir(equipamento);
  }
  public void remover(EquipamentoVO equipamento) throws SQLException{
    EquipamentoDAO dao = new EquipamentoDAO();
    dao.remover(equipamento);
  }
  public ResultSet listar() throws SQLException{
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
    return rs;
  }
  public void alterar(EquipamentoVO equipamento) throws SQLException{
    EquipamentoDAO dao = new EquipamentoDAO();  
    dao.alterar(equipamento);
  }
  @Override
  public ResultSet listarPorId(EquipamentoVO entity) throws SQLException {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public ResultSet listarPorNome(EquipamentoVO entity) throws SQLException {
    // TODO Auto-generated method stub
    return null;
  }
}
