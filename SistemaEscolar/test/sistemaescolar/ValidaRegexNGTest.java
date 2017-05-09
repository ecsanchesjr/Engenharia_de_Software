/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import sistemaescolar.ValidaRegex;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
/**
 *
 * @author Ana Flavia
 */
public class ValidaRegexNGTest {
    
    ValidaRegex validaregex = new ValidaRegex();
    
    public ValidaRegexNGTest() {
    }
    
    @Test
    public void validaNumerosTest(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(ValidaRegex.validaNumeros("52", msg));
    }
    
    @Test
    public void validaNumerosTest2(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(ValidaRegex.validaNumeros("f", msg));
    }
    

}
