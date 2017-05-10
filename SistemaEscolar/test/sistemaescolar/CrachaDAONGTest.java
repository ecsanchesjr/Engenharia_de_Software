/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static sistemaescolar.CrachaDAO.getCpfByCrachaCode;
import static sistemaescolar.CrachaDAO.getDateByCode;
import static sistemaescolar.CrachaDAO.getReByCrachaCode;
import static sistemaescolar.CrachaDAO.getTimeByCode;
import static sistemaescolar.CrachaDAO.getValidadeCode;
import static sistemaescolar.CrachaDAO.searchCrachaByCode;

/**
 *
 * @author luis
 */
public class CrachaDAONGTest {
    
    public CrachaDAONGTest() {
    }
    
    @Test(priority=-1)
    public void getValidadeCodeTest() throws SQLException {
        assertEquals(4,getValidadeCode());
    }
    
    @Test(priority=1)
    public void createNewCrachaTest() throws Exception {
        CrachaDAO.createNewCracha("333.333.333-33", 35, 21, 56);
        Connection con = ConexaoBD.getCon();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM VALIDADE where Validade_code = '35'");
        boolean control = (rs!=null);
        con = ConexaoBD.getCon();
        s = con.createStatement();
        s.executeUpdate("DELETE FROM Validade WHERE Validade_code = '35'");
        assertTrue(control);
    }
    
    @Test
    public void searchCrachaByCodeTest() {
        StringBuilder msg = new StringBuilder("");
        assertTrue(searchCrachaByCode(2,msg));
    }
    
    @Test
    public void searchCrachaByCodeTest2() {
        StringBuilder msg = new StringBuilder("");
        assertFalse(searchCrachaByCode(9848894,msg));
    }
    
    @Test
    public void getReByCrachaCodeTest() {
        assertEquals(38,getReByCrachaCode(2));
    }
    
    @Test
    public void getReByCrachaCodeTest2() {
        assertEquals(0,getReByCrachaCode(8885));
    }
    
        
    @Test
    public void getCpfByCrachaCodeTest() {
        assertEquals("333.333.333-33",getCpfByCrachaCode(2));
    }
    
    @Test
    public void getCpfByCrachaCodeTest2() {
        assertEquals("WTF",getCpfByCrachaCode(8797897));
    }
    
    @Test
    public void getDateByCodeTest() {
        assertEquals("2017-05-03",getDateByCode(2).toString());
    }
  
    @Test
    public void getDateByCodeTest2() {
        assertEquals(null,getDateByCode(1111));
    }
    
    @Test
    public void getTimeByCodeTest() {
        assertEquals("18:50:00",getTimeByCode(2).toString());
    }
    
    @Test
    public void getTimeByCodeTest2() {
        assertEquals(null,getTimeByCode(1111));
    }
    
    @Test
    public void renovCrachaTest() {
        CrachaDAO.renovCracha(35);
    }
    
}
