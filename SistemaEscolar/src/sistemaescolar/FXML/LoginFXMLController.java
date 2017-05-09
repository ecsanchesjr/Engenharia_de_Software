package sistemaescolar.FXML;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sistemaescolar.Pessoa;
import sistemaescolar.UserConexaoBD;
import sistemaescolar.Valida;
import java.io.IOException;


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
    public void Login() throws IOException{
        boolean con;
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
                if(con == false){
                    labelMsg.setText("Senha incorreta ou usuário não cadastrado.");
                }else{  // ALTERAR ISSO QUANDO FOR MELHORAR O SISTEMA
                    //labelMsg.setText("USUÁRIO CONECTADO!");
                    Pessoa.getInstance().setUser(Login.getText().toLowerCase());
                    Pessoa.getInstance().setTipo(UserConexaoBD.getPessoaType(Pessoa.getInstance().getUser()));
                    Pessoa.getInstance().setNome(UserConexaoBD.getPessoaName(Pessoa.getInstance().getUser()));
                    Pessoa.getInstance().setRe(UserConexaoBD.getPessoaRe(Pessoa.getInstance().getUser()));
                   
                    sistemaescolar.ControleUI.getInstance().showHome();
                    Login.setText("");
                    Password.setText("");
                }
            }catch(SQLException e){
                System.out.println("Erro: "+e);
            }
        }else{
            labelMsg.setText(msg.toString());
                    
        }
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}
