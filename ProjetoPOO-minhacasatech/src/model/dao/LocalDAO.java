package model.dao;

import model.vo.LocalVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocalDAO extends BaseDAO{
	
	public void inserir_local(LocalVO vo) {
		conn = getConnection();
		String sql = "INSERT INTO locais (nome_loc,nome_comp_loc) VALUES (?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1,vo.getNome());
			ptst.setString(2, vo.getCompartimento());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public void remover_local(LocalVO vo) {
		conn = getConnection();
		String sql = "DELETE FROM Locais WHERE id_loc = ?";
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
	public List<LocalVO> listar_local() {
		conn = getConnection();
		String sql = "SELECT * FROM locais";
		Statement st;
		ResultSet rs;
		List<LocalVO> list = new ArrayList<LocalVO>();
		
		
		try {
			st = conn.createStatement();
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
	public void alterar_local(LocalVO vo) {
		conn = getConnection();
		String sql = "UPDATE locais SET nome_loc = ? where id_loc = ?";
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
