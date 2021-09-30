package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.ClienteVO;

public class ClienteDAO extends PessoaDAO<ClienteVO>{
	public void inserir(ClienteVO vo) {
		try {
			super.inserir(vo);
			String sql = "INSERT INTO  cliente (cpf_cli, id_pes) values (?,?)";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setInt(1, vo.getCPF());
			int affectedRows = ptst.executeUpdate();
			if(affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void remover(ClienteVO vo) {
		try {
			super.remover(vo);
			String sql = "DELETE FROM cliente where id_cli = ?";
			PreparedStatement ptst;
			ptst = getConnection.prepareStatement(sql, Sta);
			ptst.setLong(1, vo.getId());
			ptst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
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
	
	public boolean alterar_clien(ClienteVO vo) {
		conn = getConnection();
		String sql = "UPDATE cliente set nome_cli = ?, cpf_cli = ? where id_cli = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setInt(2, vo.getCPF());
			ptst.setLong(3, vo.getId());
			ptst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
