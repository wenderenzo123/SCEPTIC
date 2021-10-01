package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.vo.FuncionarioVO;


public class FuncionarioDAO extends PessoaDAO<FuncionarioVO>{
	
public void inserir_func(FuncionarioVO vo) {

		try {
			super.inserir(vo);
			String sql = "INSERT INTO responsavel (tel_respon,email,senha,tipo) values (?,?,?,?)";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setInt(1, vo.getTelefone());
			ptst.setString(2, vo.getEmail());
			ptst.setString(3, vo.getSenha());
			ptst.setInt(4, vo.getTipo());
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
	
	public ResultSet listar_func(FuncionarioVO vo) {
		ResultSet rs = null;
		try {
			super.inserir(vo);
			String sql = "select * from responsavel where pessoa_id_pes=?";
			PreparedStatement ptst;
			
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			System.out.println(ptst);
			rs = ptst.executeQuery(sql);
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
