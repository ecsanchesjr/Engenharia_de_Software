/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ecsan
 */
public class PessoaDAO {
    private Connection con;
    
    public PessoaDAO() throws SQLException{
        con = ConexaoBD.getCon();
    }
    
    public static void insertPessoaV() throws SQLException{
        Connection con = ConexaoBD.getCon();
        
        Statement p = con.createStatement();
        
       // p.executeUpdate("INSERT INTO Pessoa VALUES('"+tipo+"','"+nome+"','"+cpf+"','"+rg+"','"+regescola+);
    }
}
