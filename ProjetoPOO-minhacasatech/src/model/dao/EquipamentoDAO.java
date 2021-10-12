package model.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.EquipamentoVO;
import model.vo.FuncionarioVO;
import model.vo.LocalVO;

public class EquipamentoDAO extends BaseDAO<EquipamentoVO> {

	@Override
	public void inserir(EquipamentoVO vo) throws SQLException {
		String sql = "INSERT INTO equipamentos (nome_eq,peso_eq,num_serie_eq,preco_eq,quant_eq,responsaveis_id_res,locais_id_loc) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1,vo.getNome());
			ptst.setDouble(2,vo.getPeso());
			ptst.setInt(3,vo.getNumeroDeSerie());
			ptst.setDouble(4,vo.getPreco());
			ptst.setInt(5,vo.getQuantidade());
			ptst.setLong(6,vo.getResponsavel().getId());
			ptst.setLong(7,vo.getLocal().getId());
			
			int affectedRows = ptst.executeUpdate();
			if(affectedRows ==0) {
				throw new SQLException("Cadastro falhou");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setId(generatedKeys.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ResultSet listar() throws SQLException {
		String sql = "SELECT * FROM equipamentos";
		Statement st;
		ResultSet rs = null;
		// List<EquipamentoVO> list = new ArrayList<EquipamentoVO>();
		try {
			st = getConnection().createStatement();
			rs=st.executeQuery(sql);
			st = getConnection().createStatement();
			System.out.println(st);
			rs=st.executeQuery(sql);
			while(rs.next()) {
				System.out.println("Id: "+rs.getInt("id_eq") + " Nome: "+rs.getString("nome_eq") +
				 " Peso: "+rs.getInt("peso_eq") +" Preço: "+rs.getInt("preco_eq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public void alterar(EquipamentoVO vo) throws SQLException {
		String sql = "UPDATE equipamentos SET nome_eq = ?, preco_eq = ? where id_eq = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1,vo.getNome());
			ptst.setDouble(2,vo.getPreco());
			ptst.setLong(3,vo.getId());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void remover(EquipamentoVO vo) throws SQLException {
		String sql = "DELETE FROM equipamentos WHERE id_eq = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, vo.getId());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ResultSet listarPorId(EquipamentoVO vo) throws SQLException {
		
		return null;
	}
	@Override
	public ResultSet listarPorNome(EquipamentoVO vo) throws SQLException {
		
		return null;
	}

}
