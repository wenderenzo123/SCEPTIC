package view;
import controller.FrontController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Telas extends Application{
  private static Stage primaryStage;

  public static Stage getPrimaryStage() {
    return primaryStage;
  }

  public static void setPrimaryStage(Stage primaryStage) {
    Telas.primaryStage = primaryStage;
  }
  public static void main(String[] args){
    launch();
  }
  public void start(Stage primaryStage) throws Exception {
    setPrimaryStage(primaryStage);
    primaryStage.setTitle("SCEPTIC");
    primaryStage.show();
    telaLogin();
    //telaCadastroEquipamento();
    //telaCadastroLocal();
    //telaCadastroFuncionario();
    //telaCadastroCliente();
  }

  private static void telaLogin() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaDeLogin.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  }
  public static void telaInicio() throws Exception {
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaInicio.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  };
  public static void telaEquipamento() throws Exception {
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaEquipamento.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  };
  public static void telaCadastroEquipamento() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/CadastroEquipamento.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  } 
  public static void telaCadastroLocal() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/CadastroLocal.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  } 
  public static void telaCadastroFuncionario() throws Exception{
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/CadastroResponsavel.fxml"));
    Scene cena = new Scene(root);
    primaryStage.setScene(cena);
  } 
  public static void telaCadastroCliente() throws Exception{
    
    Parent root = FXMLLoader.load(Telas.class.getResource("VE/CadastroCliente.fxml"));
    Scene cena = new Scene(root);
    
    primaryStage.setScene(cena);
  } 
  
}
