/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar.FXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import static sistemaescolar.Valida.validaCpf;

/**
 * FXML Controller class
 *
 * @author ecsan
 */
public class GeraCrachaVisitanteFXMLController implements Initializable {

    @FXML
    Label errLabel;
    @FXML
    Label hrInicioLabel;
    @FXML
    Label codeLabel;
    @FXML
    Label inicioLabel;
    @FXML
    Label codeLabel2;
    @FXML
    TextField cpfText;
    @FXML
    Button closeBtn;
    @FXML
    Button geraBtn;
    @FXML
    RadioButton cpfVerif;
    
    StringBuilder msg;
    
    @FXML
    public void verCpf(){
        if(validaCpf(cpfText.getText(), msg)){
            toggleMods(true);
            errLabel.setText("CPF encontrado na Base de Dados.");
            /* VERIFICAR NO BANCO */

        }else{
            errLabel.setText(msg.toString());
        }
    }
    
    public void toggleMods(Boolean mode){
        codeLabel.setVisible(mode);
        inicioLabel.setVisible(mode);
        hrInicioLabel.setVisible(mode);
        codeLabel2.setVisible(mode);
        cpfText.setEditable(!mode);
        cpfVerif.setDisable(mode);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toggleMods(false);
    }    
    
}
