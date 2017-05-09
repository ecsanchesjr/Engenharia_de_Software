/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import java.text.ParseException;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
/**
 *
 * @author marcelo
 */
public class CrachaNGTest {

    @Test
    public void testGetStateCrachaByCode() throws ParseException{
        int code = 1;
        String expResult = "INVÁLIDO";
        String result = Cracha.getStateCrachaByCode(code);
        assertEquals(result, expResult);
    }
    
    @Test
    public void testGetStateCrachabyCode2() throws ParseException{
        int code = 2;
        String expResult = "VÁLIDO";
        String result = Cracha.getStateCrachaByCode(code);
        assertEquals(result, expResult);
    }
    
    @Test
    public void testGetStateCrachaByCode3() throws ParseException{
        int code = 3;
        String expResult = "INVÁLIDO";
        String result = Cracha.getStateCrachaByCode(code);
        assertEquals(result, expResult);
    }
    
}
