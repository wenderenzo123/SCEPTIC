package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.vo.FuncionarioVO;


public class FuncionarioDAO extends PessoaDAO<FuncionarioVO>{
	
public boolean inserir_func(FuncionarioVO vo) {

		try {
			String sql = "INSERT INTO responsavel (email,senha,tipo) values (?,?,?),INSERT INTO pessoa (nome,endereco,tele) values (?,?,?) ";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql);
			
			ptst.setString(1, vo.getEmail());
			ptst.setString(2, vo.getSenha());
			ptst.setInt(3, vo.getTipo());
			ptst.setInt(6, vo.getTelefone());
			ptst.setString(4, vo.getNome());
			ptst.setString(5, vo.getEndereco());
			ptst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public void remover_func(FuncionarioVO vo) {
		try {
			super.remover(vo);
			String sql = "DELETE FROM cliente where pessoa_id_pes = ?";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet listar_func() {
		String sql = "select * from responsavel";
		ResultSet rs = null;
		Statement st;

		List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
		try {
			st = getConnection().createStatement();
			System.out.println(st);
			rs=st.executeQuery(sql);
			while(rs.next()) {
				FuncionarioVO vo = new FuncionarioVO();
				vo.setId(rs.getLong("id_resp"));
				vo.setNome(rs.getString("email"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	public void alterar_func(FuncionarioVO vo) {
		try {
			String sql = "UPDATE responsavel set nome_respon = ? where pessoa_id_pes = ?";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setLong(2,vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
