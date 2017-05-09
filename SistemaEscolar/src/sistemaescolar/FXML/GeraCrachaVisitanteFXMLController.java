/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar.FXML;

import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import static codigosfonte.PessoaDAO.existsPessoaByCpf;

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
    Button gerarBtn;
    @FXML
    Button btnCpf;
    
    int hora;
    int min;
    
    @FXML
    public void verCpf() throws SQLException{
        StringBuilder msg = new StringBuilder("");
        errLabel.setText("");
        if(existsPessoaByCpf(cpfText.getText(), msg)){
            toggleMods(true);
            errLabel.setText("CPF encontrado na Base de Dados."); 
            GregorianCalendar gc = new GregorianCalendar();
            hora = gc.get(Calendar.HOUR_OF_DAY);
            min = gc.get(Calendar.MINUTE);
            if(min <= 9){
                hrInicioLabel.setText(""+hora+":0"+min);
            }else{
                hrInicioLabel.setText(""+hora+":"+min);
            }
            codeLabel2.setText(""+codigosfonte.CrachaDAO.getValidadeCode()+"");
        }else{
            errLabel.setText(msg.toString());
        }
    }
    
    @FXML
    public void gerar() throws SQLException{
        codigosfonte.CrachaDAO.createNewCracha(cpfText.getText(), Integer.parseInt(codeLabel2.getText()), hora, min);
        toggleMods(false);
        errLabel.setText("Crachá de visitante gerado!");
    }
    
    @FXML
    public void close(){
       Stage stage = (Stage) closeBtn.getScene().getWindow();
       stage.close();
    }
    
    public void toggleMods(Boolean mode){
        codeLabel.setVisible(mode);
        inicioLabel.setVisible(mode);
        hrInicioLabel.setVisible(mode);
        codeLabel2.setVisible(mode);
        cpfText.setEditable(!mode);
        btnCpf.setDisable(mode);
        gerarBtn.setDisable(!mode);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errLabel.setText("Verificar se o CPF está na Base de Dados");
        btnCpf.setShape(new Circle(1));
        btnCpf.setMaxSize(2, 2);
        toggleMods(false);
    }    
    
}
