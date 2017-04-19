/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigosfonte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Classe com os métodos de conexão do Usuário ao Banco
*/
public class UserConexaoBD {
    private Connection conUser;
    private String usuario;
    private String senha;
    
    public String getUsuario(){
        return usuario;
    }
    
    public String getSenha(){
        return senha;
    }
    
     public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Connection getCon(){
        return this.conUser;
    }
    
    public void closeCon(){
        try{
            conUser.close();
        }catch(SQLException e){
            System.out.println("Erro ao fechar conexão de usuário.");
        }
    }
    
    public Connection startCon(){
        try{
            String url = "jdbc:postgresql://localhost:5432/Escola_BD";

            Class.forName("org.postgresql.Driver");
         
            conUser = DriverManager.getConnection(url,getUsuario(),getSenha());
        }catch(ClassNotFoundException | SQLException e){
        }
        return(conUser);
    }
}
