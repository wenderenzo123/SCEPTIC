package model.bo;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import model.InsertException;

import java.util.ArrayList;
import java.util.List;

import model.dao.FuncionarioDAO;
import model.dao.PessoaDAO;
import model.dao.ClienteDAO;
import model.dao.LocalDAO;
import model.vo.FuncionarioVO;
import model.vo.PessoaVO;
import model.vo.ClienteVO;
import model.vo.LocalVO;


public class FuncionarioBO<VO extends FuncionarioVO> implements BaseInterBO<VO>{
    static private FuncionarioDAO dao0 = new FuncionarioDAO();
    public void inserir(VO funcionario) throws InsertException {
      try {
            ResultSet rs = dao0.listar();
            if (rs.next()){
              throw new InsertException("Não será possivel");
            }
            else{
              dao0.inserir(funcionario);
            }
      }
      catch (SQLException e){
        throw new InsertException(e.getMessage());
      }
    }
    public void remover(VO funcionario) throws InsertException{
      try {
        ResultSet rs = dao0.listar();
        if (rs.next()){
          throw new InsertException("Não será possivel");
        }
        else{
          dao0.remover(funcionario);
        }
        }
        catch (SQLException e){
          throw new InsertException(e.getMessage());
        }
    }
    public ResultSet listar(){
      ResultSet rs = dao0.listar();
      List<FuncionarioVO> list = new ArrayList<FuncionarioVO>();
      try{
        while(rs.next()) {
          FuncionarioVO vo = new FuncionarioVO();
          vo.setId(rs.getLong("id_resp"));
          vo.setNome(rs.getString("nome_resp"));
          list.add(vo);
        }
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
}
    public void alterar(VO funcionario) throws InsertException{
      ResultSet rs = dao0.listar();
      try {
        if (rs.next()) {
          throw new InsertException("Não será possivel");
        }
        else{
          dao0.alterar(funcionario);
        }
        }
        catch (SQLException e){
          throw new InsertException(e.getMessage());
        }
    }
    @Override
    public ResultSet listarPorId(VO entity) throws SQLException {
      return null;
    }
    @Override
    public ResultSet listarPorNome(VO entity) throws SQLException {
      return null;
    }
}
