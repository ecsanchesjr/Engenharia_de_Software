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
import static sistemaescolar.Constantes_Tipos.*;
import static sistemaescolar.Valida.validaCpf;

public class PessoaDAO {
    
    public static int getPessoaRe(String cpf) throws SQLException{
        try{
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet busca = s.executeQuery("SELECT pessoa_regescola FROM Pessoa WHERE pessoa_cpf='" +cpf+ "'");
            busca.first();
            int re = Integer.parseInt(busca.getString("pessoa_regescola"));
            return(re);
        }catch(SQLException e){
            System.out.println("Erro getRe: " +e.toString());
        }
        catch(NumberFormatException ex){
            System.out.println("Erro de RE.");
        }
        return 0;
    }
    
    public static void insertPessoaV(String nome, String cpf, String rg, int idade) throws SQLException{
        Pessoa p = new Pessoa();
        p.setP(nome, cpf, rg, idade);
        try{
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement();
         
            s.executeUpdate("INSERT INTO Pessoa (pessoa_tipo, pessoa_nome, pessoa_cpf, pessoa_rg, pessoa_idade) VALUES('" +TIPO_VISITANTE+ "','" +p.getNome()+ "','" +p.getCpf()+ "','" +p.getRg()+ "','" +p.getIdade()+ "')");
            con.close();
        }catch(SQLException e){
            System.out.println("Erro InsertVisitante: " +e.toString());
        }
    }
    
    public static void insertPessoaA(String nome, String cpf, String rg, int idade, String email, String user, String pass) throws SQLException{
        Pessoa p = new Pessoa();
        p.setP(nome, cpf, rg, idade, user, email);
        try{
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement();
            
            s.executeUpdate("INSERT INTO Pessoa (pessoa_tipo, pessoa_nome, pessoa_cpf, pessoa_rg, pessoa_idade, pessoa_emailresponsavel, pessoa_permissao) VALUES ('" +TIPO_ALUNO+ "','" +p.getNome()+ "','" +p.getCpf()+ "','" +p.getRg()+ "','" +p.getIdade()+ "','" +p.getEmail()+ "','0')");
            int re = getPessoaRe(cpf);
            createPessoaUser(re, p.getUser(), pass);
        }catch(SQLException e){
            System.out.println("Erro InsertAluno: " +e.toString());
        }
    }
    
    public static void insertPessoaP(String nome, String cpf, String rg, int idade, String user, String pass){
        Pessoa p = new Pessoa();
        p.setP(nome, cpf, rg, idade, user);
        try{
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement();
            
            s.executeUpdate("INSERT INTO Pessoa (pessoa_tipo, pessoa_nome, pessoa_cpf, pessoa_rg, pessoa_idade) VALUES ('" +TIPO_PROFESSOR+ "','" +p.getNome()+ "','" +p.getCpf()+ "','" +p.getRg()+ "','" +p.getIdade()+ "')");
            int re = getPessoaRe(cpf);
            createPessoaUser(re, p.getUser(), pass);
        }catch(SQLException e){
            System.out.println("Erro InsertProfessor: " +e.toString());
        }
    }
    
    public static void insertPessoaF(String nome, String cpf, String rg, int idade, String user, String pass){
        Pessoa p = new Pessoa();
        p.setP(nome, cpf, rg, idade, user);
        try{
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement();
            
            s.executeUpdate("INSERT INTO Pessoa (pessoa_tipo, pessoa_nome, pessoa_cpf, pessoa_rg, pessoa_idade) VALUES ('" +TIPO_FUNCIONARIO+ "','" +p.getNome()+ "','" +p.getCpf()+ "','" +p.getRg()+ "','" +p.getIdade()+ "')");
            int re = getPessoaRe(cpf);
            createPessoaUser(re, p.getUser(), pass);
        }catch(SQLException e){
            System.out.println("Erro InsertFuncionario: " +e.toString());
        }
    }
    
    public static void createPessoaUser(int re, String user, String pass) throws SQLException{
        try{
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement();
            
            s.executeUpdate("INSERT INTO Usuario (usuario_regescola, usuario_user, usuario_passwd) VALUES ('" +re+ "','" +user+ "','" +pass+ "')");
        }catch(SQLException e){
            System.out.println("Erro na criação de usuário" +e.toString());
        }
    }

        public static Boolean existsPessoaByCpf(String cpf, StringBuilder msg) throws SQLException{
        if(validaCpf(cpf, msg)){
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

            ResultSet busca = s.executeQuery("SELECT pessoa_tipo FROM Pessoa WHERE pessoa_cpf='" +cpf+ "'");
            if(busca.next()){
                int t = Integer.parseInt(busca.getString("pessoa_tipo"));
                if(t != TIPO_VISITANTE){
                    msg.append("CPF encontrado não corresponde à um visitante. ");
                    return(false);
                }else{
                    return(true);
                    }
            }else{
                msg.append("CPF não encontrado na base de dados."); 
                return(false);
            }
        }else{
            return(false);
        }
    }
    
}
