/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author ecsan
 */
public class UserConexaoBDNGTest {  
    @Test
    public void startConTest(){
        UserConexaoBD conUser = new UserConexaoBD();
        
        conUser.setUsuario("elss");
        conUser.setSenha("132333");
        
        boolean c = (conUser.startCon() != null);
        assertTrue(c);
    }
    
    @Test
    public void closeConTest(){
        UserConexaoBD conUser = new UserConexaoBD();
        
        conUser.setUsuario("elss");
        conUser.setSenha("132333");
        
        conUser.startCon();
        conUser.closeCon();
        conUser.getCon();
    }
}
