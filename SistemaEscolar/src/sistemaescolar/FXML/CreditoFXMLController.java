/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar.FXML;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sistemaescolar.Pessoa;
import sistemaescolar.PessoaDAO;

/**
 * FXML Controller class
 *
 * @author ecsan
 */
public class CreditoFXMLController implements Initializable {
    
    @FXML
    Button closeBtn;
    @FXML
    Button addCreditsBtn;
    @FXML
    Button addConfirmBtn;
    @FXML
    TextField creditsTextField;
    @FXML
    TextField cardTextField;
    @FXML
    TextField addCreditsTextField;
    @FXML
    AnchorPane addCreditsAnchorPane;
    @FXML
    Label errLabel;
    @FXML
    Label confirmLabel;
    
    float valorP;
    int re;
    DecimalFormat df = new DecimalFormat("#.00");
    
    @FXML
    public void close(){
       Stage stage = (Stage) closeBtn.getScene().getWindow();
       stage.close();
    }
    
    @FXML
    public void addCredits(){
        addCreditsAnchorPane.setVisible(true);
    }
    
    @FXML
    public void addCreditsConfirm(){
        try{
            float valorN = Float.parseFloat(addCreditsTextField.getText());
            errLabel.setText("Insira apenas números e ponto.");
            PessoaDAO.insertPessoaCreditsByRe(re, valorN, valorP);
            errLabel.setText("Crédito inserido com sucesso.");
            addCreditsAnchorPane.setVisible(false);
            cardTextField.setText("");
            addCreditsTextField.setText("");
            creditsTextField.setText("R$ "+df.format(PessoaDAO.getPessoaCreditsByRe(re))+"");
            confirmLabel.setText("Crédito inserido com sucesso.");
        }catch(NumberFormatException e){
            errLabel.setText("Erro de Inserção.");
            addCreditsTextField.setText("");
            addCreditsTextField.requestFocus();
            cardTextField.setText("");
        }
    }
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        re = Pessoa.getInstance().getRe();
        valorP = PessoaDAO.getPessoaCreditsByRe(re);
        if(valorP == 0){
            creditsTextField.setText("R$ 0,00");
        }else{
            creditsTextField.setText("R$ "+df.format(valorP)+"");
        }
        addCreditsAnchorPane.setVisible(false);
        creditsTextField.setEditable(false);
    }    
    
}
