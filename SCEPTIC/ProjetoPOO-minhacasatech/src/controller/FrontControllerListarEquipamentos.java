package controller;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.EquipamentoBO;
import model.vo.EquipamentoVO;
import model.vo.FuncionarioVO;
import model.vo.LocalVO;
import model.vo.PessoaVO;
import view.Telas;

public class FrontControllerListarEquipamentos implements Initializable{
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    try {
      initTable();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  @FXML
  private TableView<EquipamentoVO> tblequipamentos;
  @FXML
  private TableColumn<EquipamentoVO,Long> clnid;
  @FXML
  private TableColumn<EquipamentoVO,String> clnnome;
  @FXML
  private TableColumn<EquipamentoVO,String> clnserie;
  @FXML
  private TableColumn<EquipamentoVO,PessoaVO> clnresponsavel;
  @FXML
  private TableColumn<EquipamentoVO,Double> clnpeso;
  @FXML
  private TableColumn<EquipamentoVO,Double> clnpreco;
  @FXML
  private TableColumn<EquipamentoVO,Integer> clnquantidade;
  @FXML
  private TableColumn<EquipamentoVO,LocalVO> clnlocal;
  
  public void initTable() throws SQLException{
    clnid.setCellValueFactory(new PropertyValueFactory<>("id"));
    clnnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    clnserie.setCellValueFactory(new PropertyValueFactory<>("numeroDeSerie"));
    clnresponsavel.setCellValueFactory(new PropertyValueFactory<>("nomeResponsavel"));
    clnpeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
    clnpreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
    clnquantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    clnlocal.setCellValueFactory(new PropertyValueFactory<>("nomeLocal"));
    EquipamentoBO Ebo = new EquipamentoBO();
    tblequipamentos.setItems(FXCollections.observableArrayList(Ebo.listar()));
  }
  public void  cadastrar(ActionEvent Event) throws Exception {
    Telas.telaCadastroEquipamento();
}
public void editar(ActionEvent Event) throws Exception {
  Telas.telaCadastroEquipamento();
}
public void  excluir(ActionEvent Event) throws Exception {
  ReadOnlyObjectProperty<EquipamentoVO> equi = tblequipamentos.getSelectionModel().selectedItemProperty();
  EquipamentoBO Ebo = new EquipamentoBO();
  System.out.println(equi.getValue().getId());
	Ebo.remover(equi.getValue().getId());
	}
  public void sair(ActionEvent Event) throws Exception {
    Telas.telaLogin();
  }
  public void inicio(ActionEvent Event) throws Exception {
  Telas.telaInicio();
  }
}