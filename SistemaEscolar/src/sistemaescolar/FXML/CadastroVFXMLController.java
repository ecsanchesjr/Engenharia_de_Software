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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static codigosfonte.Constantes_Tipos.TIPO_VISITANTE;
import static codigosfonte.PessoaDAO.insertPessoaV;
import static codigosfonte.Valida.validaCadastroV;

/**
 * FXML Controller class
 *
 * @author ecsan
 */
public class CadastroVFXMLController implements Initializable {
    @FXML
    TextField textNome;
    @FXML
    TextField textCpf;
    @FXML
    TextField textRg;
    @FXML
    TextField textIdade;
   
    @FXML
    Label errorLabel;
    
    @FXML
    Button fecharBtn;
    @FXML
    Button cadBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void close(){
       Stage stage = (Stage) fecharBtn.getScene().getWindow();
       stage.close();
    }
    
    public void Cadastro() throws SQLException{
        int idade;
        errorLabel.setText("");
        StringBuilder msg = new StringBuilder("");
        try{
            idade = Integer.parseInt(textIdade.getText());
            if(validaCadastroV(textNome.getText(), textCpf.getText(), textRg.getText(), idade, TIPO_VISITANTE, msg)){
                insertPessoaV(textNome.getText(), textCpf.getText(), textRg.getText(), idade);
                textNome.setText("");
                textCpf.setText("");
                textRg.setText("");
                textIdade.setText("");
                errorLabel.setText("Cadastro de Visitante concluído com sucesso.");
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