/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import java.sql.SQLException;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author ecsan
 */
public class UserConexaoBDNGTest {  
    @Test
    public void startConTest() throws SQLException{
        UserConexaoBD conUser = new UserConexaoBD();
        
        conUser.setUsuario("elss");
        conUser.setSenha("123");
        
        boolean c = conUser.startCon();
        assertTrue(c);
    }
    
    @Test
    public void closeConTest() throws SQLException{
        UserConexaoBD conUser = new UserConexaoBD();
        
        conUser.setUsuario("elss");
        conUser.setSenha("132333");
        
        conUser.startCon();
        conUser.closeCon();
        conUser.getCon();
    }
}
