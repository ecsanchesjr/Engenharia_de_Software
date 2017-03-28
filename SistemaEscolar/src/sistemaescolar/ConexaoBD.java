/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import java.sql.*;

public class ConexaoBD {
    private Connection conexao;

    public ConexaoBD() {
        this.conexao = null;
    }
    
    public Connection startCon(){
        try{
            String url = "jdbc:postgresql://localhost:5432/Escola_BD";
            String user = "postgres";
            String password = "132333";
            
            Class.forName("org.postgresql.Driver"); //Driver de conexão com o Banco.
            
            conexao = DriverManager.getConnection(url, user, password);
        }catch(ClassNotFoundException | SQLException e){
            // NOTHING TO DO HERE
            System.out.println("EOQ");
        }
        
        return(conexao);
    }
    
    
}
