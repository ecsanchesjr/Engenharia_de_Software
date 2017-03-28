/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import java.sql.*;

public class ConexaoBD {
    private static Connection conexao=null;

    public ConexaoBD() {}
    
    public static Connection getCon() throws SQLException{
        if(conexao != null){
            try{
                conexao.close();
            }catch(SQLException e){
                //NOTHING TO DO HERE
            }
        }
        startCon();
        return(conexao);
    }
    
    public static Connection startCon(){
        try{
            String url = "jdbc:postgresql://localhost:5432/Escola_BD";
            String user = "postgres";
            String password = "132333";
            
            Class.forName("org.postgresql.Driver"); //Driver de conexão com o Banco.
            
            conexao = DriverManager.getConnection(url, user, password);
        }catch(ClassNotFoundException | SQLException e){
            // NOTHING TO DO HERE
        }
        
        return(conexao);
    }
    
    private static void rollBackBD(String Login)throws SQLException{
        Statement s = conexao.createStatement();
        
        s.executeUpdate("DELETE FROM Pessoa WHERE pessoa_usuario='"+Login+"'");
        s.executeUpdate("REVOKE ALL PRIVILEGES ON DATABASE FROM "+Login);
        
        s.close();
    }

    private static void createUser(String Login, String Password) throws SQLException{
        Statement s = conexao.createStatement();
        
        s.executeUpdate("CREATE USER "+Login+"WITH PASSWORD '"+Password+"'");
        s.executeUpdate("CREATE VIEW "+Login+"verDados AS SELECT * FROM PESSOA WHERE pessoa_usuario='"+Login+"'");
        s.close();
    }
    
    
    
}
