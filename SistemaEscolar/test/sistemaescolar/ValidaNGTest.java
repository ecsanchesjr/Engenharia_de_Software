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
    
    // ATÉ AQUI TAVA CERTO
    
    @Test
    public void validaCadastroATest(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 12, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest2(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha565","152.653.253-52", "515245125", 12, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest3(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("","152.653.253-52", "515245125", 12, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest4(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("454545","152.653.253-52", "515245125", 12, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest5(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha$#$","152.653.253-52", "515245125", 12, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest6(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253", "515245125", 12, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest7(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653253-52", "515245125", 12, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest8(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","", "515245125", 12, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest9(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52jkjkj", "515245125", 12, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest10(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.2&¨&53-52", "515245125", 12, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest11(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "", 12, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest12(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaCadastroA("Dunha","152.653.253-52", "51524512klkl5", 12, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest13(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaCadastroA("Dunha","152.653.253-52", "5152451#$#$25", 12, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest14(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 1255, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest15(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", -12, "agys@gc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest16(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 12, "" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest17(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 12, "agys@gc" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest18(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 12, "agygc.com" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest19(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 12, "agys@gc.565" , "anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest20(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 12, "agys@gc.com" , "an", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest21(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 12, "agys@gc.com" , "", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest22(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 12, "agys@gc.com" , "5656", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest23(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 12, "agys@gc.com" , "$#$anasa", "12342", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest24(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 12, "agys@gc.com" , "anasa", "123442", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest25(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 12, "agys@gc.com" , "anasa", "", "12342", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest26(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 12, "agys@gc.com" , "anasa", "12342", "", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest27(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 12, "agys@gc.com" , "anasa", "", "", 4,  msg));
    }
    
    @Test
    public void validaCadastroATest28(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroA("Dunha","152.653.253-52", "515245125", 12, "agys@gc.com" , "anasa", "12342", "12342", 2,  msg));
    }
    
    @Test
    public void validaCadastroPTest(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaCadastroP("Dunha","152.653.253-52", "5848216", 45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest2(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha23","152.653.253-52", "5848216", 45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest3(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("","152.653.253-52", "5848216", 45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest4(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("D@#","152.653.253-52", "5848216", 45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest5(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("8459","152.653.253-52", "5848216", 45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest6(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","152.653.253", "5848216", 45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest7(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","", "5848216", 45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest8(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","152653.253", "5848216", 45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest9(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","as152.653.253-12", "5848216", 45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest10(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","sasd", "5848216", 45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest11(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaCadastroP("Dunha","152.653.253-52", "5848216as", 45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest12(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","152.653.253-52", "", 45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest13(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaCadastroP("Dunha","152.653.253-52", "dsfd", 45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest14(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaCadastroP("Dunha","152.653.253-52", "@#f53", 45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest15(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","152.653.253-52", "5848216", 202, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest16(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","152.653.253-52", "5848216", -45, "vini123" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest17(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","152.653.253-52", "5848216", 45, "" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest18(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","152.653.253-52", "5848216", 45, "vi" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest19(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","152.653.253-52", "5848216", 45, "4523" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest20(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","152.653.253-52", "5848216", 45, "@#da" , "1526", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest21(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","152.653.253-52", "5848216", 45, "vini123" , "1526", "11526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest22(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","152.653.253-52", "5848216", 45, "vini123" , "", "1526", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest23(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","152.653.253-52", "5848216", 45, "vini123" , "1526", "", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest24(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","152.653.253-52", "5848216", 45, "vini123" , "", "", 3,  msg));
    }
    
    @Test
    public void validaCadastroPTest25(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroP("Dunha","152.653.253-52", "5848216", 45, "vini123" , "1526", "1526", 4,  msg));
    }
    
    @Test
    public void validaCadastroFTest(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaCadastroF("Dunha","152.653.253-52", "5848216", 45, "vini123" , "1526", "1526", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest2(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha31","152.653.253-52", "5848216", 45, "vini123" , "1526", "1526", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest3(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("","152.653.253-52", "5848216", 45, "vini123" , "1526", "1526", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest4(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("3213","152.653.253-52", "5848216", 45, "vini123" , "1526", "1526", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest5(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha@#","152.653.253-52", "5848216", 45, "vini123" , "1526", "1526", 2,  msg));
    }
    
     @Test
    public void validaCadastroFTest6(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152.653.253", "5848216", 45, "vini123" , "1526", "1526", 2,  msg));
    }
    
     @Test
    public void validaCadastroFTest7(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152.653253-52", "5848216", 45, "vini123" , "1526", "1526", 2,  msg));
    }
    
     @Test
    public void validaCadastroFTest8(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152sd", "5848216", 45, "vini123" , "1526", "1526", 2,  msg));
    }
    
     @Test
    public void validaCadastroFTest9(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","", "5848216", 45, "vini123" , "1526", "1526", 2,  msg));
    }
    
     @Test
    public void validaCadastroFTest10(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","@#fsa", "5848216", 45, "vini123" , "1526", "1526", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest11(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152.653.253-52", "", 45, "vini123" , "1526", "1526", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest12(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaCadastroF("Dunha","152.653.253-52", "58482gf16", 45, "vini123" , "1526", "1526", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest13(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaCadastroF("Dunha","152.653.253-52", "584!@8216", 45, "vini123" , "1526", "1526", 2,  msg));
    }
    
     @Test
    public void validaCadastroFTest14(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152.653.253-52", "5848216", -45, "vini123" , "1526", "1526", 2,  msg));
    }
    
     @Test
    public void validaCadastroFTest15(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152.653.253-52", "5848216", 445, "vini123" , "1526", "1526", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest16(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152.653.253-52", "5848216", 45, "123" , "1526", "1526", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest17(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152.653.253-52", "5848216", 45, "" , "1526", "1526", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest18(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152.653.253-52", "5848216", 45, "vb" , "1526", "1526", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest19(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152.653.253-52", "5848216", 45, "@#ds" , "1526", "1526", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest20(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152.653.253-52", "5848216", 45, "vini123" , "15526", "1526", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest21(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152.653.253-52", "5848216", 45, "shuahd" , "", "1526", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest22(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152.653.253-52", "5848216", 45, "batata" , "1526", "", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest23(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152.653.253-52", "5848216", 45, "ana1234" , "", "", 2,  msg));
    }
    
    @Test
    public void validaCadastroFTest24(){
        StringBuilder msg = new StringBuilder("");
        assertFalse(Valida.validaCadastroF("Dunha","152.653.253-52", "5848216", 45, "vini123" , "1526", "1526", 5,  msg));
    }
}

