/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import sistemaescolar.PessoaDAO;
import sistemaescolar.ConexaoBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static sistemaescolar.PessoaDAO.insertPessoaA;
import static sistemaescolar.PessoaDAO.insertPessoaF;
import static sistemaescolar.PessoaDAO.insertPessoaP;
import static sistemaescolar.PessoaDAO.insertPessoaV;
import static sistemaescolar.PessoaDAO.togglePermissionState;
import static sistemaescolar.PessoaDAO.insertPessoaCreditsByRe;
import static sistemaescolar.PessoaDAO.reducePessoaCreditsByRe;
import static sistemaescolar.PessoaDAO.getPessoaCreditsByRe;
/**
 *
 * @author ecsan
 */
public class PessoaDAONGTest {
    
    PessoaDAO pessoadao = new PessoaDAO();

    @Test
    public void getPessoaReTest1() throws SQLException{
        Connection con = ConexaoBD.getCon();
        Statement s = con.createStatement();
        assertEquals(20,PessoaDAO.getPessoaRe("111.111.111-11"));
    }   
    
    @Test
    public void getPessoaReTest2() throws SQLException{
        Connection con = ConexaoBD.getCon();
        Statement s = con.createStatement();
        assertEquals(0,PessoaDAO.getPessoaRe("341.152.132-11"));
    }   
    
    @Test
    public void insertPessoaVTest() throws SQLException{
        insertPessoaV("Elcio Cezario Sanches Junior",  "666.666.666-66", "77.777.777-7", 21);
        Connection con = ConexaoBD.getCon();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Pessoa WHERE pessoa_cpf = '666.666.666-66'");
        boolean control = (rs!=null);
        PessoaDAO.deletePessoaTest();
        assertTrue(control);
    }   
    
    @Test
    public void insertPessoaATest() throws SQLException{
        insertPessoaA("Elss aaaaa",  "555.555.555-55", "66.777.777-7", 21, "elcio@umemail.com","elss" ,"123");
        Connection con = ConexaoBD.getCon();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Pessoa WHERE pessoa_cpf = '555.555.555-55'");
        boolean control = (rs!=null);
        PessoaDAO.deletePessoaTest();
        assertTrue(control);
    }   
    
    @Test
    public void insertPessoaPTest() throws SQLException{
        insertPessoaP("Professor",  "555.555.563-55", "66.777.727-7", 22, "pr5o","pro");
        Connection con = ConexaoBD.getCon();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Pessoa WHERE pessoa_cpf = '555.555.563-55'");
        boolean control = (rs!=null);
        PessoaDAO.deletePessoaTest();
        assertTrue(control);
    } 
    
    @Test
    public void insertPessoaFTest() throws SQLException{
        insertPessoaF("Funio",  "555.555.555-35", "66.757.777-7", 22, "dddd","pro");
        Connection con = ConexaoBD.getCon();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Pessoa WHERE pessoa_cpf = '555.555.555-35'");
        boolean control = (rs!=null);
        PessoaDAO.deletePessoaTest();
        assertTrue(control);
    } 
    
    @Test
    public void existsPessoaByCpfTest() throws SQLException{
        StringBuilder msg = new StringBuilder("");
        assertFalse(PessoaDAO.existsPessoaByCpf("",msg));
    }
    
    @Test
    public void existsPessoaByCpfTest2() throws SQLException{
        StringBuilder msg = new StringBuilder("");
        assertFalse(PessoaDAO.existsPessoaByCpf("946.235.756-75",msg));
    }
    
    @Test(priority=2)
    public void existsPessoaByCpfTest3() throws SQLException{
        StringBuilder msg = new StringBuilder("");
        assertTrue(PessoaDAO.existsPessoaByCpf("333.333.333-33",msg));
    }
    
    @Test
    public void existsPessoaByCpfTest4() throws SQLException{
        StringBuilder msg = new StringBuilder("");
        assertFalse(PessoaDAO.existsPessoaByCpf("111.111.111-11",msg));
    }
    
    @Test
    public void togglePermissionStateTest() throws SQLException{
        togglePermissionState(25);
        Connection con = ConexaoBD.getCon();
        Statement s = con.createStatement();

    }
    
    @Test
    public void getPermissionStateTest() throws SQLException{
        assertTrue(PessoaDAO.getPermissionState(20));
    }
    
    @Test
    public void getPermissionStateTest2() throws SQLException{
        assertFalse(PessoaDAO.getPermissionState(25));
    }
     
    @Test
    public void insertPessoaCreditsByReTest() throws SQLException{
        insertPessoaCreditsByRe(25,25,25);
        Connection con = ConexaoBD.getCon();
        Statement s = con.createStatement();

    }
    
    @Test
    public void reducePessoaCreditsByReTest() throws SQLException{
        reducePessoaCreditsByRe(25,50,25);
        Connection con = ConexaoBD.getCon();
        Statement s = con.createStatement();
    }
        
    @Test
    public void getPessoaCreditsByReTest1() throws SQLException{      
        assertEquals(Float.toString(PessoaDAO.getPessoaCreditsByRe(20)),"75.0");
    }
    
    @Test
    public void getPessoaCreditsByReTest2() throws SQLException{
        assertEquals(Float.toString(PessoaDAO.getPessoaCreditsByRe(224)),"0.0");
    }
}