/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar.FXML;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static sistemaescolar.Constantes_Tipos.*;
import sistemaescolar.Pessoa;

public class HomeFXMLController implements Initializable {

    @FXML
    Label typeLabel;
    @FXML
    Label nameLabel;
    @FXML
    Label reLabel;
    @FXML
    Button cadVBtn;
    @FXML
    Button cadABtn;
    @FXML
    Button cadPBtn;
    @FXML
    Button cadFBtn;
    @FXML
    Button closeBtn;

       
    @FXML
    public void getCadV() throws IOException{
        sistemaescolar.ControleUI.getInstance().showRegisterV();
    }
    
    @FXML
    public void getCadF() throws IOException{
        sistemaescolar.ControleUI.getInstance().showRegisterF();
    }
    
    @FXML
    public void getCadP() throws IOException{
        sistemaescolar.ControleUI.getInstance().showRegisterP();
    }
    
    @FXML
    public void getCadA() throws IOException{
        sistemaescolar.ControleUI.getInstance().showRegisterA();
    }
    
    @FXML
    public void close(){
       Stage stage = (Stage) closeBtn.getScene().getWindow();
       stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int t = Pessoa.getInstance().getTipo();
        switch (t) {
            case TIPO_ALUNO:
                typeLabel.setText("Usuário Aluno");
                break;
            case TIPO_FUNCIONARIO:
                typeLabel.setText("Usuário Funcionário");
                break;
            case TIPO_PROFESSOR:
                typeLabel.setText("Usuário Professor");
                break;
            case TIPO_DIRETOR:
                typeLabel.setText("Usuário Diretor");
                break;
            default:
                break;
        }
        nameLabel.setText(Pessoa.getInstance().getNome());
        reLabel.setText(""+Pessoa.getInstance().getRe()+"");

        if(t != TIPO_DIRETOR && t != TIPO_FUNCIONARIO){
            cadVBtn.setVisible(false);
            cadPBtn.setVisible(false);
            cadABtn.setVisible(false);
            cadFBtn.setVisible(false);
        }else{
            cadVBtn.setVisible(true);
            cadPBtn.setVisible(true);
            cadABtn.setVisible(true);
            cadFBtn.setVisible(true);
        }
    }

    
}
