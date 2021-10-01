package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.ClienteVO;

public class ClienteDAO extends PessoaDAO<ClienteVO>{
	public void inserir_clien(ClienteVO vo) {
		try {
			super.inserir(vo);
			String sql = "INSERT INTO  cliente (cpf_cli, id_cli) values (?,?)";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setInt(1, vo.getCPF());
			int affectedRows = ptst.executeUpdate();
			if(affectedRows == 0) {
				throw new SQLException("A inser��o falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setId(generatedKeys.getLong(1));
			}
			else {
				throw new SQLException("A inser��o falhou. Nenhuma linha foi alterada.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void remover_clien(ClienteVO vo) {
		try {
			super.remover(vo);
			String sql = "DELETE FROM cliente where id_cli = ?";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet listar_clien(ClienteVO vo){
		ResultSet rs = null;
		try {
			super.inserir(vo);
			String sql = "select * from cliente where id_cli=?";
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
	
	public void alterar(ClienteVO vo) {
		try {
			String sql = "UPDATE cliente set nome = ? where id_cli = ?";
		  	PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setLong(2, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
