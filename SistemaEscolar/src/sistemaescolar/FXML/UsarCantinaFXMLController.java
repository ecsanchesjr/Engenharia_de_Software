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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemaescolar.CantinaDAO;
import static sistemaescolar.Constantes_Cantina.*;
import sistemaescolar.Pessoa;
import sistemaescolar.PessoaDAO;

/**
 * FXML Controller class
 *
 * @author ecsan
 */
public class UsarCantinaFXMLController implements Initializable {

    @FXML
    TextField creditsTextField;
    @FXML
    TextField priceTextField;
    @FXML
    TextField balanceTextField;
    @FXML
    Button confirmBtn;
    @FXML
    Button closeBtn;
    @FXML
    MenuItem cafeP;
    @FXML
    MenuItem cafeM;
    @FXML
    MenuItem cafeG;
    @FXML
    MenuItem lancheNatural;
    @FXML
    MenuItem salgadoAssado;
    @FXML
    MenuItem salgadoFrito;
    @FXML
    Label errLabel;
    @FXML
    Label itemLabel;
       
    int re;
    float valorP, itemPrice, balance;
    DecimalFormat df = new DecimalFormat("#.00");
    
    
    @FXML
    public void close(){
       Stage stage = (Stage) closeBtn.getScene().getWindow();
       stage.close();
    }
    
    @FXML
    public void confirmBuy(){
        if(!(0 > (valorP - itemPrice))){
            PessoaDAO.reducePessoaCreditsByRe(re, valorP, itemPrice);
            errLabel.setText("Compra efetuada com sucesso.");
            valorP = PessoaDAO.getPessoaCreditsByRe(re);
            creditsTextField.setText("R$ "+df.format(valorP)+"");
        }else{
            errLabel.setText("Você não pode efetuar compra.");
        }
    }
    
    @FXML
    public void buyCafeP(){
        itemPrice = CantinaDAO.getPrecoCantinaItemByItemCode(CAFE_P);
        balance = valorP - itemPrice;
        priceTextField.setText("R$ "+df.format(itemPrice));
        balanceTextField.setText("R$ "+df.format(balance));
        confirmBtn.setDisable(false);
        itemLabel.setText("Café Pequeno");
    }
    
    @FXML
    public void buyCafeM(){
        itemPrice = CantinaDAO.getPrecoCantinaItemByItemCode(CAFE_M);
        balance = valorP - itemPrice;
        priceTextField.setText("R$ "+df.format(itemPrice));
        balanceTextField.setText("R$ "+df.format(balance));
        confirmBtn.setDisable(false);
        itemLabel.setText("Café Médio");
    }
    
    @FXML
    public void buyCafeG(){
        itemPrice = CantinaDAO.getPrecoCantinaItemByItemCode(CAFE_G);
        balance = valorP - itemPrice;
        priceTextField.setText("R$ "+df.format(itemPrice));
        balanceTextField.setText("R$ "+df.format(balance));
        confirmBtn.setDisable(false);
        itemLabel.setText("Café Grande");
    }
    
    @FXML
    public void buyLancheNatural(){
        itemPrice = CantinaDAO.getPrecoCantinaItemByItemCode(LANCHE_N);
        balance = valorP - itemPrice;
        priceTextField.setText("R$ "+df.format(itemPrice));
        balanceTextField.setText("R$ "+df.format(balance));
        confirmBtn.setDisable(false);
        itemLabel.setText("Lanche Natural");
    }
    
    @FXML
    public void buySalgadoAssado(){
        itemPrice = CantinaDAO.getPrecoCantinaItemByItemCode(SALGADO_A);
        balance = valorP - itemPrice;
        priceTextField.setText("R$ "+df.format(itemPrice));
        balanceTextField.setText("R$ "+df.format(balance));
        confirmBtn.setDisable(false);
        itemLabel.setText("Salgado Assado");
    }
    
    @FXML
    public void buySalgadoFrito(){
        itemPrice = CantinaDAO.getPrecoCantinaItemByItemCode(SALGADO_F);
        balance = valorP - itemPrice;
        priceTextField.setText("R$ "+df.format(itemPrice));
        balanceTextField.setText("R$ "+df.format(balance));
        confirmBtn.setDisable(false);
        itemLabel.setText("Salgado Frito");
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
        creditsTextField.setEditable(false);
        balanceTextField.setEditable(false);
        priceTextField.setEditable(false);
        confirmBtn.setDisable(true);
    }    
    
}
