package model.dao;

import model.vo.LocalVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocalDAO extends BaseDAO{
	
	public boolean inserir_local(LocalVO vo) {
		String sql = "INSERT INTO locais (nome_loc,nome_comp_loc) VALUES (?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1,vo.getNome());
			ptst.setString(2, vo.getCompartimento());
			ptst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		
	}
	public boolean remover_local(LocalVO vo) {
		String sql = "DELETE FROM Locais WHERE id_loc = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1,vo.getId());
			ptst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public List<LocalVO> listar_local() {

		String sql = "SELECT * FROM locais";
		Statement st;
		ResultSet rs;
		List<LocalVO> list = new ArrayList<LocalVO>();
		
		
		try {
			st = getConnection().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				LocalVO vo = new LocalVO();
				vo.setId(rs.getLong("id_loc"));
				vo.setNome(rs.getString("nome_loc"));
				vo.setCompartimento(rs.getString("nome_comp_loc"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean alterar_local(LocalVO vo) {
		String sql = "UPDATE locais SET nome_loc = ?, nome_comp_loc = ? where id_loc = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1,vo.getNome());
			ptst.setString(2,vo.getCompartimento());
			ptst.setLong(3,vo.getId());
			ptst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
		
}
