/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import static codigosfonte.Constantes_Tipos.*;
import codigosfonte.Pessoa;

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
    MenuItem validaCracha;
    @FXML
    MenuItem geraCracha;
    @FXML
    MenuButton controlVisit;

       
    @FXML
    public void getCadV() throws IOException{
        codigosfonte.ControleUI.getInstance().showRegisterV();
    }
    
    @FXML
    public void getCadF() throws IOException{
        codigosfonte.ControleUI.getInstance().showRegisterF();
    }
    
    @FXML
    public void getCadP() throws IOException{
        codigosfonte.ControleUI.getInstance().showRegisterP();
    }
    
    @FXML
    public void getCadA() throws IOException{
        codigosfonte.ControleUI.getInstance().showRegisterA();
    }
    
    @FXML
    public void close(){
       Stage stage = (Stage) closeBtn.getScene().getWindow();
       stage.close();
    }
    
    @FXML
    public void renovarV() throws IOException{
        codigosfonte.ControleUI.getInstance().showRenovCrachaV();
    }
    
    @FXML
    public void geraV() throws IOException{
        codigosfonte.ControleUI.getInstance().showGeraCrachaV();
    }
    
    @FXML
    public void toggleModes(Boolean mode){
        cadVBtn.setVisible(mode);
        cadPBtn.setVisible(mode);
        cadABtn.setVisible(mode);
        cadFBtn.setVisible(mode);
        controlVisit.setVisible(mode);
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
            toggleModes(false);
        }else{
            toggleModes(true);
        }
    }    
}
