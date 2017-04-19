/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import codigosfonte.ConexaoBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static codigosfonte.PessoaDAO.insertPessoaV;

/**
 *
 * @author ecsan
 */
public class PessoaDAONGTest {
    
    public PessoaDAONGTest() {
    }
    
    @Test
    public void insertPessoaVTest() throws SQLException{
        insertPessoaV("Elcio Cezario Sanches Junior",  "666.666.666-66", "77.777.777-7", 21);
        Connection con = ConexaoBD.getCon();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Pessoa WHERE pessoa_cpf = '666.666.666-66'");
        boolean control = (rs!=null);
        assertTrue(control);
    }   
}
