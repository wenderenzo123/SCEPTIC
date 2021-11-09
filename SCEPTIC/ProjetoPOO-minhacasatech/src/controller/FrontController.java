package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.bo.EquipamentoBO;
import model.bo.FuncionarioBO;
import model.vo.EquipamentoVO;
import model.vo.FuncionarioVO;
import view.TelaInicio;
import view.Telas;


public class FrontController {
    @FXML
    private Label erroAUT;
    @FXML
    private TextField login;
    @FXML
    private TextField senha;
    
    @FXML
    private TableView<EquipamentoVO> tabela;
    @FXML
    private TableColumn<EquipamentoVO, String> nome;
    @FXML
    private TableColumn<EquipamentoVO, Long> serie;
    @FXML
    private TableColumn<EquipamentoVO, String> responsavel;
    public void autenticar(ActionEvent event) throws Exception {
        FuncionarioBO<FuncionarioVO> funBO = new FuncionarioBO<FuncionarioVO>();
        if (login.getText().equals("") | senha.getText().equals("")) {
            erroAUT.setVisible(true);
        } else {
            FuncionarioVO vo = new FuncionarioVO();
            vo.setEmail(login.getText());
            vo.setSenha(senha.getText());

            try {
                vo = funBO.autenticar(vo);
                if (vo instanceof FuncionarioVO) {
                    if (vo.getTipo()==1) {
                        System.out.println(vo.getNome());
                        Telas.telaInicio();
                    }
                    else{
                        System.out.println(vo.getNome());
                        Telas.telaInicio();
                    }
                } else {
                    erroAUT.setVisible(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                erroAUT.setVisible(true);
            }
        }
    }
    public void initialize(URL url, ResourceBundle rb) throws SQLException {
		iniciarTabela();
	}
    private void iniciarTabela() throws SQLException {
        nome.setCellValueFactory(new PropertyValueFactory<>("nome_eq"));
        EquipamentoBO eq = new EquipamentoBO();
        tabela.setItems(FXCollections.observableArrayList(eq.listar()));
    }
}
