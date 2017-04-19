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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import codigosfonte.Valida;

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
    public void Login(){
        Connection con;
        StringBuilder msg = new StringBuilder("");
        /*
            MÉTODO QUE O BOTÃO LOGIN IRÁ CHAMAR APÓS CLICADO
        */
        
        if(Valida.validaLogin(Login.getText(), Password.getText(), msg)) { //Chama o método de teste para verificar se algum campo está vazio
            try{
                codigosfonte.UserConexaoBD conUser = new codigosfonte.UserConexaoBD();

                conUser.setUsuario(Login.getText().toLowerCase());
                conUser.setSenha(Password.getText());

                con = conUser.startCon();
                if(con==null){
                    labelMsg.setText("Senha incorreta ou usuário não cadastrado.");
                }else{  // ALTERAR ISSO QUANDO FOR MELHORAR O SISTEMA
                    labelMsg.setText("USUÁRIO CONECTADO!");
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
    public void getCadV(){
        codigosfonte.ControleUI.getInstance().showRegisterV();
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
