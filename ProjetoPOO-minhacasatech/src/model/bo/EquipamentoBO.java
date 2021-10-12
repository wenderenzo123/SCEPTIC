package model.bo;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import model.InsertException;

import java.util.ArrayList;
import java.util.List;

import modelDAO.FuncionarioDAO;
import modelDAO.PessoaDAO;
import modelDAO.ClienteDAO;
import modelDAO.EquipamentoDAO;
import modelDAO.LocalDAO;
import model.vo.FuncionarioVO;
import model.vo.PessoaVO;
import model.vo.ClienteVO;
import model.vo.LocalVO;
import model.vo.EquipamentoVO;

public class EquipamentoBO implements BaseInterBO<EquipamentoVO> {
	EquipamentoDAO dao1 = new EquipamentoDAO();
	public void inserir(EquipamentoVO equipamento) throws SQLException {
		try {
			ResultSet rs = dao1.listar(equipamento);
			if(rs.next()) {
				throw new InsertException("Não será possivel");
			}
			else{
	         dao1.inserir(equipamento);
				}
			}
			catch (SQLException e){
		        throw new InsertException(e.getMessage());
		    }
		}
	public void remover(EquipamentoVO equipamento) throws SQLException{
		try {
	        ResultSet rs = dao1.listar(equipamento);
	        if (rs.next()){
	          throw new InsertException("Não será possivel");
	        }
	        else{
	          dao1.remover(equipamento);
	        }
	        }
	        catch (SQLException e){
	          throw new InsertException(e.getMessage());
	        }
  }
	public List<EquipamentoVO> listar(EquipamentoVO equipamento) throws SQLException {
		 List<EquipamentoVO> list = new ArrayList<EquipamentoVO>();
		 try {
			 ResultSet rs = dao1.listarPorId(equipamento);
			 while(rs.next()) {
				 EquipamentoVO vo2 = new EquipamentoVO();
				 equipamento.setId(rs.getLong("id_eq"));
				 equipamento.setNome(rs.getString("nome_eq"));
			
				//add as demais coisas a serem exibidas(num de series, preco, quant...) (olhar no BD)
				 /*
				FuncionarioVO fu = new FuncionarioVO();
				LocalVO  lo = new LocalVO();
				equipamento.setId(rs.getLong("id_eq"));
				equipamento.setNome(rs.getString("nome_eq"));
				equipamento.setPeso(rs.getDouble("peso_eq"));
				equipamento.setNumeroDeSerie(rs.getInt("num_serie_eq"));
				equipamento.setPreco(rs.getDouble("preco_eq"));
				equipamento.setQuantidade(rs.getInt("quant_eq"));
				fu.setId(rs.getLong("responsavel_id_respon"));
				lo.setId(rs.getLong("locais_id_loc"));
				*/
				list.add(vo2);
			 }
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return list;
	 }
	public void alterar(EquipamentoVO equipamento) throws SQLException{
		 try {
			 ResultSet rs = dao1.listar(equipamento);
		    if (rs.next()) {
		       throw new InsertException("Não será possivel");
		     }
		    else{
		       dao1.alterar(equipamento);
		     }
		     }
		    catch (SQLException e){
		      throw new InsertException(e.getMessage());
		  	}
  }
  @Override
  public List<EquipamentoVO> listarPorId(EquipamentoVO equipamento) throws SQLException {
		List<EquipamentoVO> list = new ArrayList<EquipamentoVO>();
		 try {
			 ResultSet rs = dao1.listar(equipamento);
			 while(rs.next()) {
				 EquipamentoVO vo2 = new EquipamentoVO();
				 equipamento.setId(rs.getLong("id_eq"));
				 list.add(vo2);
			 }
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return list;
	}
  @Override
  public List<EquipamentoVO> listarPorNome(EquipamentoVO equipamento) throws SQLException {
		List<EquipamentoVO> list = new ArrayList<EquipamentoVO>();
		 try {
			 ResultSet rs = dao1.listar(equipamento);
			 while(rs.next()) {
				 EquipamentoVO vo2 = new EquipamentoVO();
				 equipamento.setNome(rs.getString("nome_eq"));
				 list.add(vo2);
			 }
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return list;
	}
@Override
public List<EquipamentoVO> listar(ClienteVO vo) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
}
