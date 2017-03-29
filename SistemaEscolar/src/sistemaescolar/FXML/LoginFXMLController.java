package sistemaescolar.FXML;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sistemaescolar.Valida;

public class LoginFXMLController implements Initializable {

    @FXML
    Label label;
    @FXML
    Label labelMsg;
    @FXML
    TextField Login;
    @FXML
    PasswordField Password;
    @FXML
    MenuItem Close;
    @FXML
    Button BtnLogin;
    @FXML
    Button BtnRegister;
    

    @FXML
    public void Sair(){
        System.exit(0);
    }
  
    @FXML
    public void Login(){
        Connection con;
        StringBuilder msg = new StringBuilder("");
        /*
            MÉTODO QUE O BOTÃO LOGIN IRÁ CHAMAR APÓS CLICADO
        */
        
        if(Valida.validaLogin(Login.getText(), Password.getText(), msg)) { //Chama o método de teste para verificar se algum campo está vazio
            try{
                sistemaescolar.UserConexaoBD conUser = new sistemaescolar.UserConexaoBD();

                conUser.setUsuario(Login.getText().toLowerCase());
                conUser.setSenha(Password.getText());

                con = conUser.startCon();
                if(con==null){
                    labelMsg.setText("Senha incorreta ou usuário não cadastrado.");
                }else{  // ALTERAR ISSO QUANDO FOR MELHORAR O SISTEMA
                    
                    Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                    dialogoInfo.setTitle("CONEXÃO FEITA COM SUCESSO");
                    dialogoInfo.setHeaderText("Usuário e Senha corretos.");
                    dialogoInfo.setContentText("Conectado!");
                    dialogoInfo.showAndWait();
                    labelMsg.setText("");
                    Login.setText("");
                    Password.setText("");
                }
            }catch(Exception e){
                System.out.println("Erro: "+e);
            }
        }else{
            labelMsg.setText(msg.toString());
                    
        }
    }
    
    @FXML
    public void getRegister(){
        sistemaescolar.ControleUI.getInstance().showRegister();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
