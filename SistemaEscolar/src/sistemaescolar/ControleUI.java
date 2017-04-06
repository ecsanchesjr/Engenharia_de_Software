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
    private static Parent registerVFXML;
   
    //SCENES
    private static Scene loginScene;
    private static Scene registerVScene;
    
    
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
            registerVFXML = FXMLLoader.load(getClass().getResource("FXML/CadastroVFXML.fxml"));
            
            registerVScene = new Scene(registerVFXML);
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
    
    public void showRegisterV(){
        secondStage.setScene(registerVScene);
        secondStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}