/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CantinaDAO {
    
    /*
        Retorna o preço do item a partir do código de produto dele.
    */
    public static float getPrecoCantinaItemByItemCode(int codeItem){
        try{
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet busca = s.executeQuery("SELECT cantina_precoitem FROM Cantina WHERE cantina_codeitem='" +codeItem+ "'");
            busca.first();
            return(Float.parseFloat(busca.getString("cantina_precoitem")));
        }catch(SQLException e){
            System.out.println("Erro de PreçoSQL: " +e.toString());
        }
        catch(NumberFormatException ex){
            System.out.println("Erro do Preço.");
        }
        return(0);
    }
}
