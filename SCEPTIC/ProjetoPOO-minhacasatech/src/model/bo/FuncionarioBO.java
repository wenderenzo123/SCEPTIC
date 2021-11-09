package model.bo;

import java.sql.SQLException;
import java.sql.ResultSet;
import model.InsertException;

import java.util.ArrayList;
import java.util.List;

import model.dao.FuncionarioDAO;
import model.dao.PessoaDAO;
import model.vo.FuncionarioVO;

public class FuncionarioBO<VO extends FuncionarioVO> implements BaseInterBO<FuncionarioVO> {
	PessoaDAO dao3 = new FuncionarioDAO();
	FuncionarioDAO dao = new FuncionarioDAO();

	public FuncionarioVO autenticar(FuncionarioVO vo) throws Exception {
		ResultSet rs = dao.listarLogin(vo);
		try {
			if (rs.next()) {
				if (rs.getString("email").equals(vo.getEmail()) & rs.getString("senha").equals(vo.getSenha())) {
					FuncionarioVO fun = new FuncionarioVO();
					fun.setEmail(rs.getString("email"));
					fun.setSenha(rs.getString("senha"));
					fun.setNome(rs.getString("nome"));
					fun.setEndereco(rs.getString("endereco"));
					fun.setTelefone(rs.getString("tele"));
					fun.setTipo(rs.getInt("tipo"));
					return fun;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void inserir(FuncionarioVO funcionario) throws InsertException {
		try {
			ResultSet rs = dao.listar();
			if (rs.next()) {
				throw new InsertException("Não será possivel");
			} else {
				dao.inserir(funcionario);
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void remover(FuncionarioVO funcionario) throws InsertException {
		try {
			ResultSet rs = dao3.listar();
			if (rs.next()) {
				throw new InsertException("Não será possivel");
			} else {
				dao3.remover(funcionario);
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public List<FuncionarioVO> listar() throws SQLException {
		List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
		try {
			ResultSet rs = dao3.listar();
			FuncionarioVO vo2 = new FuncionarioVO();
			while (rs.next()) {

				vo2.setId(rs.getLong("id_res"));
				vo2.setNome(rs.getString("nome"));
				// add as demais coisas a serem exibidas(num de series, preco, quant...) (olhar
				// no BD)
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void alterar(FuncionarioVO funcionario) throws InsertException {
		try {
			ResultSet rs = dao3.listar();
			if (rs.next()) {
				throw new InsertException("Não será possivel");
			} else {
				dao3.alterar(funcionario);
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	@Override
	public List<FuncionarioVO> listarPorId(FuncionarioVO funcionario) throws SQLException {
		List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
		try {
			ResultSet rs = dao3.listarPorId(funcionario);
			while (rs.next()) {
				FuncionarioVO vo2 = new FuncionarioVO();
				funcionario.setId(rs.getLong("id_res"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<FuncionarioVO> listarPorNome(FuncionarioVO funcionario) throws SQLException {
		List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
		try {
			ResultSet rs = dao3.listarPorNome(funcionario);
			while (rs.next()) {
				FuncionarioVO vo2 = new FuncionarioVO();
				funcionario.setNome(rs.getString("nome"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<FuncionarioVO> listarPorLogin(FuncionarioVO funcionario) throws SQLException {
		List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
		try {
			ResultSet rs = dao.listarLogin(funcionario);
			while (rs.next()) {
				FuncionarioVO vo2 = new FuncionarioVO();
				funcionario.setId(rs.getLong("id_res"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setSenha(rs.getString("senha"));
				funcionario.setTipo(rs.getInt("tipo"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setTelefone(rs.getString("telefone"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
