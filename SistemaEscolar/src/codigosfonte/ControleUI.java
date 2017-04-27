package sistemaescolar;
/*
    CLASSE PRINCIPAL
    Nessa classe estarão os controladores referentes à interface do sistema.
*/
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControleUI extends Application {
    
    // STAGES
    private static Stage mainStage;
    private static Stage secondStage;
    
    //PARENTS PARA MANIPULAÇÃO DO FXML
    private static Parent loginFXML; 
    private static Parent homeFXML;
    private static Parent registerVFXML;
    private static Parent registerAFXML;
    private static Parent registerPFXML;
    private static Parent registerFFXML;
   
    //SCENES
    private static Scene loginScene;
    private static Scene homeScene;
    private static Scene registerVScene;
    private static Scene registerAScene;
    private static Scene registerPScene;
    private static Scene registerFScene;
    
    
    private static ControleUI INSTANCE = null;

     public static ControleUI getInstance(){
      return((INSTANCE == null)?INSTANCE = new ControleUI():INSTANCE);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {  // iniciar interface
        mainStage = primaryStage;
        initUI();
    }
    
    private void initUI() throws IOException{  // controlador de inicialização de interface
        mainStage.centerOnScreen();
        mainStage.setTitle("Sistema de Controle Escolar");
        secondStage = new Stage();
       
        try{
            loginFXML = FXMLLoader.load(getClass().getResource("FXML/LoginFXML.fxml"));
            loginScene = new Scene(loginFXML); 
        }catch(IOException e){
            System.out.println("Erro"+e);
        }
        showLogin();
    }
    
    public void showLogin(){
        mainStage.setScene(loginScene);
        mainStage.show();
    }
    
    public void showHome() throws IOException{
        homeFXML = FXMLLoader.load(getClass().getResource("FXML/HomeFXML.fxml"));
        homeScene = new Scene(homeFXML);
        mainStage.setScene(homeScene);
        mainStage.show();
    }
    
    public void showRegisterV() throws IOException{
        registerVFXML = FXMLLoader.load(getClass().getResource("FXML/CadastroVFXML.fxml"));
        registerVScene = new Scene(registerVFXML);
        secondStage.setScene(registerVScene);
        secondStage.show();
    }

    public void showRegisterA() throws IOException{
        registerAFXML = FXMLLoader.load(getClass().getResource("FXML/CadastroAFXML.fxml"));
        registerAScene = new Scene(registerAFXML);
        secondStage.setScene(registerAScene);
        secondStage.show();
    }
    
    public void showRegisterP() throws IOException{
        registerPFXML = FXMLLoader.load(getClass().getResource("FXML/CadastroPFXML.fxml"));
        registerPScene = new Scene(registerPFXML);
        secondStage.setScene(registerPScene);
        secondStage.show();
    }
    
    public void showRegisterF() throws IOException{
        registerFFXML = FXMLLoader.load(getClass().getResource("FXML/CadastroFFXML.fxml"));
        registerFScene = new Scene(registerFFXML);
        secondStage.setScene(registerFScene);
        secondStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}