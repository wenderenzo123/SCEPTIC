package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.FuncionarioVO;


public class FuncionarioDAO<VO extends FuncionarioVO> extends PessoaDAO{
	
public void inserir(FuncionarioVO vo) throws SQLException {
		super.inserir(vo);
		try {
			String sql = "INSERT INTO responsaveis (email,senha,tipo,pessoa_id_pes) values (?,?,?,?)";
			PreparedStatement ptst;
		  ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getEmail());
			ptst.setString(2, vo.getSenha());
			ptst.setInt(3, vo.getTipo());
			ptst.setLong(4, vo.getId());
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
			e.printStackTrace();
		}
	}
public void remover(FuncionarioVO vo) {
		try {
			String sql = "DELETE FROM responsaveis where id_res = ?";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			super.remover(vo);
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
public ResultSet listar() {
		String sql = "select * from responsaveis";
		ResultSet rs = null;
		Statement st;
		// List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
		try {
			st = getConnection().createStatement();
			System.out.println(st);
			rs=st.executeQuery(sql);
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt("id_res")+" Email: "+rs.getString("email")
				+" Tipo: "+rs.getString("tipo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public void alterar(FuncionarioVO vo) {
		try {
			String sql = "UPDATE responsaveis set tipo = ? where id_res = ?";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getTipo());
			ptst.setLong(2,vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}	