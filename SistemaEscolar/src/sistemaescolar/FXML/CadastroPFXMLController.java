/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar.FXML;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static sistemaescolar.Constantes_Tipos.*;
import static sistemaescolar.PessoaDAO.insertPessoaP;
import static sistemaescolar.Valida.validaCadastroP;

/**
 * FXML Controller class
 *
 * @author ecsan
 */
public class CadastroPFXMLController implements Initializable {

    @FXML
    TextField textNome;
    @FXML
    TextField textCpf;
    @FXML
    TextField textRg;
    @FXML
    TextField textIdade;
    @FXML
    TextField textNick;
    @FXML
    PasswordField textPass1;
    @FXML
    PasswordField textPass2;
   
    @FXML
    Label errorLabel;
    
    @FXML
    Button fecharBtn;
    @FXML
    Button cadBtn;
    
    
    public void close(){
       Stage stage = (Stage) fecharBtn.getScene().getWindow();
       stage.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void Cadastro() throws SQLException{
        int idade;
        errorLabel.setText("");
        StringBuilder msg = new StringBuilder("");
        try{
            idade = Integer.parseInt(textIdade.getText());
            if(validaCadastroP(textNome.getText(), textCpf.getText(), textRg.getText(), idade, textNick.getText(), textPass1.getText(), textPass2.getText(), TIPO_PROFESSOR, msg)){
                insertPessoaP(textNome.getText(), textCpf.getText(), textRg.getText(), idade, textNick.getText(), textPass1.getText());
                textNome.setText("");
                textCpf.setText("");
                textRg.setText("");
                textIdade.setText("");
                textNick.setText("");
                textPass1.setText("");
                textPass2.setText("");
                errorLabel.setText("Cadastro de Professor concluído com sucesso.");
            }else{
                errorLabel.setText(msg.toString());
        }
        }catch(NumberFormatException e){
            errorLabel.setText("Idade Inválida");
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
    
}
