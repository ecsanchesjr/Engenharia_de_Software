/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar.FXML;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import static codigosfonte.CrachaDAO.searchCrachaByCode;

/**
 * FXML Controller class
 *
 * @author ecsan
 */
public class RenovarCrachaVisitanteFXMLController implements Initializable {

    @FXML
    Label errLabel;
    @FXML
    Label cpfLabel;
    @FXML
    Label reLabel;
    @FXML
    Label cpfTextLabel;
    @FXML
    Label reTextLabel;
    @FXML
    Label stateLabel;
    @FXML
    Label stateTextLabel;
    @FXML
    Button closeBtn;
    @FXML
    Button gerarBtn;
    @FXML
    Button renovBtn;
    @FXML
    Button verifCodeBtn;
    @FXML
    TextField codeText;
    
    int code;
    
    @FXML
    public void verificarCode() throws ParseException{
        StringBuilder msg = new StringBuilder("");
        try{
            code = Integer.parseInt(codeText.getText());
            if(searchCrachaByCode(code, msg)){
            errLabel.setText(msg.toString());
            gerarBtn.setVisible(false);
            reTextLabel.setText(" "+codigosfonte.CrachaDAO.getReByCrachaCode(code)+"");
            cpfTextLabel.setText(" "+codigosfonte.CrachaDAO.getCpfByCrachaCode(code));
            stateTextLabel.setText(" "+codigosfonte.Cracha.getStateCrachaByCode(code));
            toggleModes(true);
            if(codigosfonte.Cracha.getStateCrachaByCode(code).equals("VÁLIDO")){
                renovBtn.setDisable(true);
            }
        }else{
            errLabel.setText(msg.toString());
            gerarBtn.setVisible(true);
        }
        }catch(NumberFormatException e){
            errLabel.setText("Não foi digitado um número.");
        }
    }
    
    @FXML
    public void close(){
       Stage stage = (Stage) closeBtn.getScene().getWindow();
       stage.close();
    }
    
    @FXML
    public void renovar(){
        codigosfonte.CrachaDAO.renovCracha(code);
        errLabel.setStyle("-fx-font-size: 20px");
        errLabel.setText("Crachá de visitante renovado por mais 6 horas.");
        renovBtn.setDisable(true);
    }
    
    @FXML 
    public void gerar() throws IOException{
        codigosfonte.ControleUI.getInstance().showGeraCrachaV();
    }
    
    public void toggleModes(Boolean mode){
        cpfLabel.setVisible(mode);
        reLabel.setVisible(mode);
        cpfTextLabel.setVisible(mode);
        reTextLabel.setVisible(mode);
        renovBtn.setDisable(!mode);
        stateLabel.setVisible(mode);
        stateTextLabel.setVisible(mode);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errLabel.setText("Verificar se o crachá existe na Base de Dados.");
        gerarBtn.setVisible(false);
        verifCodeBtn.setShape(new Circle(1));
        verifCodeBtn.setMaxSize(2, 2);
        toggleModes(false);
    }    
    
}
