package sistemaescolar.FXML;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RootLayoutController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField Login;
    @FXML
    private PasswordField Password;
    @FXML
    private MenuItem Close;
    @FXML
    private Text Mensagem;
    @FXML
    private Button BtnLogin;
    

    @FXML
    public void Sair(){
        System.exit(0);
    }
    
    @FXML
    public void Login(){
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
