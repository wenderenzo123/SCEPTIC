package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.vo.FuncionarioVO;


public class FuncionarioDAO extends BaseDAO{
	
	public boolean inserir_func(FuncionarioVO vo) {
		conn = getConnection();
		String sql = "INSERT INTO responsavel (nome_respon,end_respon,tel_respon,email,senha,tipo) values (?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereco());
			ptst.setInt(3, vo.getTelefone());
			ptst.setString(4, vo.getEmail());
			ptst.setString(5, vo.getSenha());
			ptst.setInt(6, vo.getTipo());
			ptst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public boolean remover_func(FuncionarioVO vo) {
		conn = getConnection();
		String sql = "DELETE FROM responsavel where id_respon = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1,vo.getId());
			ptst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public List<FuncionarioVO> listar_func() {
		conn = getConnection();
		String sql = "SELECT * FROM responsavel ";
		Statement st;
		ResultSet rs;
		List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
		
		try {
			st = conn.createStatement();
			rs= st.executeQuery(sql);
			while(rs.next()) {
				FuncionarioVO vo = new FuncionarioVO();
				vo.setId(rs.getLong("id_respon"));
				vo.setNome(rs.getString("nome_respon"));
				vo.setTelefone(rs.getInt("tel_respon"));
				vo.setEndereco(rs.getString("end_respon"));
				vo.setEmail(rs.getString("email"));
				vo.setTipo(rs.getInt("tipo"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public boolean alterar_func(FuncionarioVO vo) {
		conn = getConnection();
		String sql = "UPDATE responsavel set nome_respon = ? where id_respon = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setLong(2,vo.getId());
			ptst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}	
