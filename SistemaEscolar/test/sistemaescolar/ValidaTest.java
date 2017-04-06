/* batata teste
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. >>>>>>>>>>>>>> TESTEANDOO <<<<<<<<<<<<<<<<<<
 */
package sistemaescolar;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ecsan
 */
public class ValidaTest {
    
    public ValidaTest(){
    }
    
    @Test
    public void validaLoginTest(){
        StringBuilder msg = new StringBuilder("");
        assertTrue(Valida.validaLogin("Elss", "132333",msg));
    }
}
