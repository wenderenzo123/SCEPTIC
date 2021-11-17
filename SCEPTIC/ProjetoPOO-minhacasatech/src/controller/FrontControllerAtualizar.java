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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import model.bo.ClienteBO;
import model.bo.EquipamentoBO;
import model.bo.FuncionarioBO;
import model.bo.LocalBO;
import model.vo.ClienteVO;
import model.vo.EquipamentoVO;
import model.vo.FuncionarioVO;
import model.vo.LocalVO;
import view.Telas;

public class FrontControllerAtualizar implements Initializable{
    

    

    @FXML
    private TextField nomeatuarespom;
    @FXML
    private TextArea endeatuarepon;
    @FXML
    private TextArea telefoneatuarespon;

    public void listarFuncionario(ActionEvent atualizarFuncionario) throws Exception {
        FuncionarioVO Fun = new FuncionarioVO();
        Fun.setNome(nomeatuarespom.getText());
        Fun.setEndereco(endeatuarepon.getText());
        Fun.setTelefone(telefoneatuarespon.getText());
        FuncionarioBO Fbo = new FuncionarioBO();
        Fbo.alterar(Fun);

    }

    @FXML
    private TextField nomeatuacli;
    @FXML
    private TextArea enderecoatuacli;
    @FXML
    private ComboBox<ClienteVO> clienatua;
    public void listarCliente() throws Exception {
        ClienteVO cli2 = new ClienteVO();
        ClienteBO Cbo= new ClienteBO();
        clienatua.setItems(FXCollections.observableArrayList(Cbo.listar()));
        System.out.println("clienatua.getId()");
        //cli.getValue().setNome(nomeatuacli.getText());
        //cli.getValue().setNome(enderecoatuacli.getText());
        // cli2.setNome(cli.getValue().getNome());
        // cli2.setEndereco(cli.getValue().getNome());
        // ClienteBO Cbo = new ClienteBO();
        // Cbo.alterar(cli2);
        // System.out.println(cli.getValue().getNome());
    }


    public void sair(ActionEvent Event) throws Exception{
        Telas.telaInicio();
    }
    public void inicio(ActionEvent Event) throws Exception {
        Telas.telaInicio();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            listarCliente();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    @FXML
     void atualizar(ActionEvent event) throws SQLException {
        clienatua.getSelectionModel().getSelectedItem().getId();
        ClienteBO cli = new ClienteBO();
        System.out.println(clienatua.getSelectionModel().getSelectedItem().getId());
        ClienteVO CL1 = new ClienteVO();
        CL1.setId(clienatua.getSelectionModel().getSelectedItem().getId());
        CL1.setNome(nomeatuacli.getText());
        CL1.setEndereco(enderecoatuacli.getText());
        cli.alterar(CL1);
    }
    
   
    

}
