/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import sistemaescolar.Valida;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 *
 * @author Ana Flavia
 */
public class ValidaNGTest {
    
    Valida valida = new Valida();
    
    public ValidaNGTest() {
    }
    
    @Test
    public void validaLoginTest(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaLogin("Elss", "132333",msg));
    }
    
    @Test
    public void validaLoginTest2(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaLogin("Joao152", "utf1524",msg));
    }
    
    @Test
    public void validaLoginTest3(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaLogin("", "utf1524",msg));
    }
    
    @Test
    public void validaLoginTest4(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaLogin("Ana", "",msg));
    }    
    
    @Test
    public void validaPasswordTest(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaPassword("Ana", "152",msg));
    }    
    
    @Test
    public void validaPasswordTest2(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaPassword("", "152",msg));
    }    
    
    @Test
    public void validaPasswordTest3(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaPassword("Ana", "85152",msg));
    }    
    
    @Test
    public void validaPasswordTest4(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaPassword("Ana", "",msg));
    }    
    
    @Test
    public void validaPasswordTest5(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaPassword("Ana", "851525584512566856258",msg));
    } 
   
    @Test
    public void validaNomeTest(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaNome("Joao",msg));
    } 
    
    @Test
    public void validaNomeTest2(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaNome("J0ao",msg));
    } 
    
    @Test
    public void validaNomeTest3(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaNome("",msg));
    } 
    
    @Test
    public void validaNomeTest4(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaNome("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",msg));
    } 
    
    @Test
    public void validaCPFTest(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCpf("",msg));
    } 
    
    @Test
    public void validaCPFTest2(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCpf("78549685624",msg));
    } 
    
    @Test
    public void validaCPFTest3(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaCpf("123.456.789-01",msg));
    } 
    
    @Test
    public void validaRGTest(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaRg("", msg));
    } 
    
    @Test
    public void validaRGTest2(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaRg("12.123.123-9", msg));
    } 
    
    @Test
    public void validaIdadeTest(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaIdade(12, msg));
    } 
    
    @Test
    public void validaIdadeTest2(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaIdade(0, msg));
    } 
    
    @Test
    public void validaIdadeTest3(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaIdade(200, msg));
    } 
    
    @Test
    public void validaCadastroTest(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaCadastroV("Maria","152.653.253-52", "12.658.659-9", 52, 5, msg));
    } 
    
    @Test
    public void validaCadastroTest2(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroV("Dunha João da Silva","152.653.253-52", "12.658.659-9", 60, 3, msg));
    }
    
    @Test
    public void validaCadastroTest3(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroV("Dunha3","152.653.253-52", "12.658.659-9", 60, 5, msg));
    }
    
    @Test
    public void validaCadastroTest4(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroV("Dunha","Batata", "12.658.659-9", 60, 5, msg));
    }
    
    @Test
    public void validaCadastroTest5(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroV("Dunha","152.653.253-52", "12.658.659-9", 201, 5, msg));
    }
    
    @Test
    public void validaCadastroTest6(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroV("Dunha","152.653.253-52", "12.658.659-9", -1, 5, msg));
    }
    
    @Test
    public void validaCadastroTest7(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroV("Dunha","152.653.253-52", "", -1, 5, msg));
    }
}
