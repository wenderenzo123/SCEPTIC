package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.EquipamentoVO;
import model.vo.FuncionarioVO;
import model.vo.LocalVO;

public class EquipamentoDAO extends BaseDAO {

	public void inserir_eq(EquipamentoVO vo,LocalVO lo, FuncionarioVO fu) {
		conn = getConnection();
		String sql = "INSERT INTO equipamentos (nome_eq,peso_eq,num_serie_eq,preco_eq,quant_eq,responsavel_id_respon,locais_id_loc) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,vo.getNome());
			ptst.setDouble(2,vo.getPeso());
			ptst.setInt(3,vo.getNumeroDeSerie());
			ptst.setDouble(4,vo.getPreco());
			ptst.setInt(5,vo.getQuantidade());
			ptst.setLong(6,fu.getId());
			ptst.setLong(7,lo.getId());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public void remover_eq(EquipamentoVO vo) {
		conn = getConnection();
		String sql = "DELETE FROM equipamentos WHERE id_loc = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1,vo.getId());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<EquipamentoVO> listar_local() {
		conn = getConnection();
		String sql = "SELECT * FROM equipamentos";
		Statement st;
		ResultSet rs;
		List<EquipamentoVO> list = new ArrayList<EquipamentoVO>();
		
		
		try {
			st = conn.createStatement();
			rs=st.executeQuery(sql);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void alterar_eq(EquipamentoVO vo) {
		conn = getConnection();
		String sql = "UPDATE equipamentos SET nome_eq = ? where id_eq = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,vo.getNome());
			ptst.setLong(2,vo.getId());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}