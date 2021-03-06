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
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author ecsan
 */
public class CrachaDAO {
        
    /*
        Retorna a quantidade de crachás existentes no banco, assim podendo criar um novo.
    */
    public static int getValidadeCode() throws SQLException{
        Connection con = sistemaescolar.ConexaoBD.getCon();
        Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        int nRows = 0;
        ResultSet busca = s.executeQuery("select * from validade");
        
        if(busca.last()){
            nRows = busca.getRow();
        }
        return(nRows+1);
    }
    
    /*
        Cria um novo crachá com os dados de cpf, código(gerado a partir do método acima) e tempo no dia
        O tempo é obtido do próprio relógio do computador executando o programa.
    */
    public static void createNewCracha(String cpf, int code, int hr, int min) throws SQLException{
        GregorianCalendar gc = new GregorianCalendar();
        int dia = gc.get(GregorianCalendar.DAY_OF_MONTH);
        int mes = gc.get(GregorianCalendar.MONTH) + 1;
        int ano = gc.get(GregorianCalendar.YEAR);
        int re = sistemaescolar.PessoaDAO.getPessoaRe(cpf);
        
        try{
            Connection con = sistemaescolar.ConexaoBD.getCon();
            Statement s = con.createStatement();
            
            s.executeUpdate("INSERT INTO Validade(validade_regescola, validade_code, validade_inicio, validade_dia) VALUES('"+re+"', '"+code+"', '"+hr+":"+min+"', '"+dia+"/"+mes+"/"+ano+"')");
            con.close();
        }catch(SQLException e){
            System.out.println("Erro ao gerar crachá: "+e.toString());
        }
    }
    
    /*
        Procura se existe um crachá com o código passado.
    */
    public static Boolean searchCrachaByCode(int code, StringBuilder msg){
        try{
            Connection con = sistemaescolar.ConexaoBD.getCon();
            Statement s = con.createStatement();
            
            ResultSet busca = s.executeQuery("SELECT p.pessoa_cpf, v.validade_regescola FROM Pessoa p, validade v WHERE v.validade_code ='"+code+"' AND v.validade_regescola = p.pessoa_regescola");
            con.close();
            if(busca.next()){
                msg.append("Crachá encontrado na Base de Dados.");
                return(true);
            }else{
                msg.append("Crachá não encontrado na Base de Dados.");
                return(false);
            }
        }catch(SQLException e){
            //System.out.println("Erro ao procurar crachá: "+e.toString());
            return(false);
        }
    }
    
    /*
        Procura o Registro Escolar do visitante a partir do código do crachá passado.
    */
    public static int getReByCrachaCode(int code){
        try{
            Connection con = sistemaescolar.ConexaoBD.getCon();
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet busca = s.executeQuery("SELECT validade_regescola FROM Validade WHERE validade_code ='"+code+"';");
            con.close();
            busca.first();
            return(busca.getInt("validade_regescola"));
        }catch(SQLException e){
            //System.out.println("Erro ao buscar Re pelo code: "+e.toString());
        }
        return 0;
    }
    
    /*
        Procura o CPF do Visitante a partir do código de crachá passado.
    */
    public static String getCpfByCrachaCode(int code){
        try{
            Connection con = sistemaescolar.ConexaoBD.getCon();
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet busca = s.executeQuery("SELECT pessoa_cpf FROM Validade, Pessoa WHERE validade_code ='"+code+"' AND validade_regescola = pessoa_regescola;");
            con.close();
            busca.first();
            return(busca.getString("pessoa_cpf"));
        }catch(SQLException e){
            //System.out.println("Erro ao buscar Re pelo code: "+e.toString());
        }
        return("WTF");
    }
    
    /*
        Procura o dia que foi gerado o crachá no banco de dados.
    */
    public static Date getDateByCode(int code){
        try{
            Connection con = sistemaescolar.ConexaoBD.getCon();
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            ResultSet busca = s.executeQuery("SELECT validade_dia FROM Validade WHERE validade_code = '"+code+"';");
            con.close();
            busca.first();
            return(busca.getDate("validade_dia"));
        }catch(SQLException e){
            //System.out.println("Erro para pegar data: "+e.toString());
        }
        return null;
    }
    
    /*
        Procura a hora que foi gerado a crachá no banco.
    */
    public static Date getTimeByCode(int code){
        try{
            Connection con = sistemaescolar.ConexaoBD.getCon();
            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            ResultSet busca = s.executeQuery("SELECT validade_inicio FROM Validade WHERE validade_code = '"+code+"';");
            con.close();
            busca.first();
            return(busca.getTime("validade_inicio"));
        }catch(SQLException e){
            //System.out.println("Erro para pegar a hora: "+e.toString());
        }
        return null;
    }
    
    /*
        Função que faz um Update na célula do crachá verificado, alterando o tempo de validade dele.
        Adiciona +6 horas de duração para o crachá.
    */
    public static void renovCracha(int code){
        try{
            Connection con = sistemaescolar.ConexaoBD.getCon();
            Statement s = con.createStatement();
            
            GregorianCalendar gc = new GregorianCalendar();
            int dia = gc.get(GregorianCalendar.DAY_OF_MONTH);
            int mes = gc.get(GregorianCalendar.MONTH) + 1;
            int ano = gc.get(GregorianCalendar.YEAR);
            
            int hora = gc.get(GregorianCalendar.HOUR_OF_DAY)+6;
            int min = gc.get(GregorianCalendar.MINUTE);
            
            s.executeUpdate("UPDATE Validade SET validade_dia = '"+dia+"/"+mes+"/"+ano+"', validade_inicio = '"+hora+":"+min+"' WHERE validade_code ='"+code+"';");
            con.close();
        }catch(SQLException e){
            System.out.println("Erro ao renovar cracha: "+e.toString());
        }
    }
}
