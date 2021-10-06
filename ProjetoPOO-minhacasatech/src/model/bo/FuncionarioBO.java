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
    public boolean inserir(VO funcionario) throws InsertException {
      try {
            ResultSet rs = dao0.listar_func();
            if (rs.next()){
              throw new InsertException("Não será possivel");
              return false;
            }
            else{
              dao0.inserir_func(funcionario);
              return true;
            }
      }
      catch (SQLException e){
        throw new InsertException(e.getMessage());
      }
    }
    public boolean excluir_funcionario(VO funcionario) throws InsertException{
      try {
        ResultSet rs = dao0.listar_func();
        if (rs.next()){
          throw new InsertException("Não será possivel");
          return false;
        }
        else{
          dao0.remover_func(funcionario);
          return true;
        }
        }
        catch (SQLException e){
          throw new InsertException(e.getMessage());
        }
    }
    public ResultSet listar(){
      ResultSet rs = dao0.listar_func();
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
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return list;
}
    public boolean alterar_funcionario(VO funcionario) throws InsertException{
      ResultSet rs = dao0.listar_func();
      try {
        if (rs.next()) {
          throw new InsertException("Não será possivel");
        }
        else{
          dao0.alterar_func(funcionario);
          return true;
        }
        }
        catch (SQLException e){
          throw new InsertException(e.getMessage());
        }
    }
}
