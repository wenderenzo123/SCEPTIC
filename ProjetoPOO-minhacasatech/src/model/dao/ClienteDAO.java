package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.ClienteVO;

public class ClienteDAO extends BaseDAO{
	
	public void inserir_clien(ClienteVO vo) {
		conn = getConnection();
		String sql = "INSERT INTO  cliente (nome_cli,end_cli,cpf_cli) values (?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereco());
			ptst.setInt(3, vo.getCPF());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void remover_clien(ClienteVO vo) {
		conn = getConnection();
		String sql = "DELETE FROM cliente where id_cli = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ClienteVO> listar_clien(){
		conn = getConnection();
		String sql = "SELECT * FROM cliente ";
		Statement st;
		ResultSet rs;
		List<ClienteVO> list = new ArrayList<ClienteVO>();
		
		try {
			st = conn.createStatement();
			rs= st.executeQuery(sql);
			while(rs.next()) {
				ClienteVO vo = new ClienteVO();
				vo.setId(rs.getLong("id_cli"));
				vo.setNome(rs.getString("nome_cli"));
				vo.setEndereco(rs.getString("end_cli"));
				vo.setCPF(rs.getInt("cpf_cli"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void alterar_clien(ClienteVO vo) {
		conn = getConnection();
		String sql = "UPDATE cliente set nome_cli = ? where id_cli = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setLong(2, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
