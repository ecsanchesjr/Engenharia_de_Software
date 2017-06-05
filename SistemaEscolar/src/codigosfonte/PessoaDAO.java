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
import sistemaescolar.ConexaoBD;
import sistemaescolar.Pessoa;
import static sistemaescolar.Constantes_Tipos.*;
import static sistemaescolar.Valida.validaCpf;

public class PessoaDAO {
    
    public static void togglePermissionState(int re){
        try{
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement();
            s.executeUpdate("UPDATE Pessoa SET pessoa_permissao = '2' WHERE pessoa_regescola = '"+re+"'");
            con.close();
        }catch(SQLException e){
            System.out.println("Erro UpdatePermission: " +e.toString());
        }
    }
    
    /*
        Retorna se o aluno tem, ou não, permissão de usar a cantina
    */
    public static Boolean getPermissionState(int re){
        try{
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet busca = s.executeQuery("SELECT pessoa_permissao FROM Pessoa WHERE pessoa_regescola='" +re+ "'");
            busca.first();
            if(Integer.parseInt(busca.getString("pessoa_permissao")) == 1){
                return(true);
            }
        }catch(SQLException e){
            System.out.println("Erro getPermissao: " +e.toString());
        }
        return(false);
    }
    
    /*
        Aumenta a quantidade de creditos que a pessoa tem a partir de seu RE
    */
    public static void insertPessoaCreditsByRe(int re, float valorN, float valorP){
        try{
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement();
            float newValor = valorN + valorP;
            s.executeUpdate("UPDATE Pessoa SET pessoa_credito = '"+newValor+"' WHERE pessoa_regescola = '"+re+"'");
            con.close();
        }catch(SQLException e){
            System.out.println("Erro UpdateCredits: " +e.toString());
        }
    }
    
    /*
        Retira dos créditos da pessoa, pelo Re da mesma, o total utilizado na cantina.
    */
    public static void reducePessoaCreditsByRe(int re, float valorP, float valorC){
        try{
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement();
            float newValor = valorP - valorC;
            s.executeUpdate("UPDATE Pessoa SET pessoa_credito = '"+newValor+"' WHERE pessoa_regescola = '"+re+"'");
            con.close();
        }catch(SQLException e){
            System.out.println("Erro UpdateCredits: " +e.toString());
        }
    }
    
    /*
        Retorna a quantidade de créditos que a pessoa tem para utilizar na cantina.
    */
    public static float getPessoaCreditsByRe(int re){
        try{
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet busca = s.executeQuery("SELECT pessoa_credito FROM Pessoa WHERE pessoa_regescola='" +re+ "'");
            busca.first();
         
            return(Float.parseFloat(busca.getString("pessoa_credito")));
        }catch(SQLException e){
            System.out.println("Erro getCredits: " +e.toString());
        }
        catch(NumberFormatException ex){
            System.out.println("EErro de Crédito");
        }
        return 0;
    }
    
    /*
        Retorna o Registro Escolar de uma pessoa a partir de um CPF passado. 
    */
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
    
    /*
        Insere uma pessoa de tipo visitante no banco.
    */
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
    
    /*
        Insere uma pessoa de tipo Aluno no banco.
    */
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
    
    /*
        Insere uma pessoa do tipo Professor no banco.
    */
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
    
    /*
        Insere uma pessoa do tipo Funcionário no Banco.
    */
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
    
    /*
        Cria um usuário para a pessoa.
    */
    public static void createPessoaUser(int re, String user, String pass) throws SQLException{
        try{
            Connection con = ConexaoBD.getCon();
            Statement s = con.createStatement();
            
            s.executeUpdate("INSERT INTO Usuario (usuario_regescola, usuario_user, usuario_passwd) VALUES ('" +re+ "','" +user+ "','" +pass+ "')");
        }catch(SQLException e){
            System.out.println("Erro na criação de usuário" +e.toString());
        }
    }

    /*
        Verifica se existe a pessoa a partir de seu CPF, no caso, verifica se a pessoa existe no Banco.
    */
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
    
    public static void deletePessoaTest() throws SQLException{
        Connection con = ConexaoBD.getCon();
        Statement s = con.createStatement();
        
        s.executeUpdate("DELETE FROM pessoa WHERE pessoa_cpf != '333.333.333-33' AND pessoa_cpf != '111.111.111-11'");
    }

 }
