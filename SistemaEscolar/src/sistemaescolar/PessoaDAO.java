/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static sistemaescolar.Constantes_Tipos.*;

/**
 *
 * @author ecsan
 */
public class PessoaDAO {
    
    public static void insertPessoaV(String nome, String cpf, String rg, int idade) throws SQLException{
        Pessoa p = new Pessoa(nome, cpf, rg, idade);
        try{
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement();
         
            s.executeUpdate("INSERT INTO Pessoa (pessoa_tipo, pessoa_nome, pessoa_cpf, pessoa_rg, pessoa_idade) VALUES(' " +TIPO_VISITANTE+ " ',' " +p.getNome()+ " ',' " +p.getCpf()+ " ',' " +p.getRg()+ " ',' " +p.getIdade()+ " ')");
            con.close();
        }catch(SQLException e){
            System.out.println("Erro na conexão com o banco.");
        }
    }
}
