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
import static codigosfonte.ConexaoBD.startConection;

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
    
    public boolean startCon() throws SQLException{
        conUser = startConection();
        
        Statement s = conUser.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
        ResultSet query;
        query = s.executeQuery("SELECT usuario_passwd FROM Usuario WHERE usuario_user='"+this.getUsuario()+"';");
 
        if(query.next()){
            String senhaBD = query.getString("usuario_passwd");
            if(senhaBD.equals(this.senha)){
                return(true);
            }else{
                return(false);
            }
        }else{
            return(false);
        }
    }
    
        
    public static int getPessoaType(String usuario) throws SQLException{
            Connection con = ConexaoBD.getCon();
            Statement s;
            s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet busca = s.executeQuery("SELECT p.pessoa_tipo FROM Pessoa p,Usuario u WHERE u.usuario_user='"+usuario+"' and u.usuario_regescola=p.pessoa_regescola");
            busca.first();
            int temp = Integer.parseInt(busca.getString("pessoa_tipo"));
            return(temp);
    }
    
    public static String getPessoaName(String usuario) throws SQLException{
        Connection con = ConexaoBD.getCon();
        Statement s;
        s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet busca = s.executeQuery("SELECT p.pessoa_nome FROM Pessoa p,Usuario u WHERE u.usuario_user='"+usuario+"' and u.usuario_regescola=p.pessoa_regescola");
        busca.first();
        return(busca.getString("pessoa_nome"));
    }
    
    public static int getPessoaRe(String usuario) throws SQLException{
        Connection con = ConexaoBD.getCon();
        Statement s;
        s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet busca = s.executeQuery("SELECT usuario_regescola FROM Usuario WHERE usuario_user='"+usuario+"'");
        busca.first();
        int temp = Integer.parseInt(busca.getString("usuario_regescola"));
        return(temp);
    }
}
