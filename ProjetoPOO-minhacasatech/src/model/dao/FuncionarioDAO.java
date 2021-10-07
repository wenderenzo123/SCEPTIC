package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.vo.FuncionarioVO;


public class FuncionarioDAO<VO extends FuncionarioVO> extends PessoaDAO<VO>{
	
public void inserir(VO vo) throws SQLException {
		super.inserir(vo);
		try {
			String sql = "INSERT INTO responsavel (pessoa_id_pes,email,senha,tipo) values (?,?,?,?)";
			PreparedStatement ptst;
		  ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.setString(2, vo.getEmail());
			ptst.setString(3, vo.getSenha());
			ptst.setInt(4, vo.getTipo());
			

			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}
public ResultSet listar() {
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
