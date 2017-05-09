/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author marcelo
 */
public class CrachaNGTest {
    
    public CrachaNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Teste de método getStateCrachaByCode, da classe Cracha.
     */
    @Test
    public void testGetStateCrachaByCode() throws Exception {
        System.out.println("getStateCrachaByCode");
        int code = 1;
        String expResult = "VÁLIDO";
        String result = Cracha.getStateCrachaByCode(code);
        assertEquals(result, expResult);
        // TODO verifica o código de teste gerado e remove a chamada default para falha.
        //fail("O caso de teste \u00e9 um prot\u00f3tipo.");
    }
    
}
