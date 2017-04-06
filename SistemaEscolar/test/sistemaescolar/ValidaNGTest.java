/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Ana Flavia
 */
public class ValidaNGTest {
    
    public ValidaNGTest() {
    }
    
    @org.junit.Test
    public void validaLoginTest(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaLogin("Elss", "132333",msg));
    }
    
    @org.junit.Test
    public void validaLoginTest2(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaLogin("Joao152", "utf1524",msg));
    }
    
    @org.junit.Test
    public void validaLoginTest3(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaLogin("", "utf1524",msg));
    }
    
    @org.junit.Test
    public void validaLoginTest4(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaLogin("Ana", "",msg));
    }    
    
    @org.junit.Test
    public void validaPasswordTest(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaPassword("Ana", "152",msg));
    }    
    
    @org.junit.Test
    public void validaPasswordTest2(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaPassword("", "152",msg));
    }    
    
    @org.junit.Test
    public void validaPasswordTest3(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaPassword("Ana", "85152",msg));
    }    
    
    @org.junit.Test
    public void validaPasswordTest4(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaPassword("Ana", "",msg));
    }    
    
    @org.junit.Test
    public void validaPasswordTest5(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaPassword("Ana", "851525584512566856258",msg));
    }    
}
