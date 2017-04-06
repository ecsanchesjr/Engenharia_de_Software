/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import static sistemaescolar.Constantes_Tipos.*;
import static sistemaescolar.ValidaRegex.validaCpfNum;
import static sistemaescolar.ValidaRegex.validaLetras;

public final class Valida {
       
    public static Boolean validaLogin(String Login, String Password, StringBuilder msg){ //MÉTODO DE VALIDAÇÃO DE PREENCHIMENTO DE CAMPOS
       // msg.setLength(0);
        
        boolean control = true;
        
        if(Login.isEmpty()){
            msg.append("Campo de usuário vazio. ");
            control = false;
        }
        if(Password.isEmpty()){
            msg.append("Campo de senha vazio. ");
            control = false;
        }
        
        return(control);     
    }
    
    public static Boolean validaNome(String nome, StringBuilder msg){
       // msg.setLength(0);
        
        if(!validaLetras(nome, msg)){
            return(false);
        }else if(nome.isEmpty()){
            msg.append("Nome vazio. ");
            return(false);
        }else if(nome.length() > 100){
            msg.append("Nome muito grande. ");
            return(false);
        }else{
            return(true);
        }
    }
    
    public static Boolean validaPassword(String Login, String Password, StringBuilder msg){
       // msg.setLength(0);
        
        boolean control = true;
        
        if(Login.isEmpty()){
            msg.append("Campo de usuario vazio.");
            control = false;
        }
        
        if(Password.isEmpty()){
            msg.append("Campo de senha vazio.");
            control = false;
        }
        if(Password.length() <= 5){
            msg.append("Senha muito curta.");
            control = false;
        }
        if(Password.length() > 20){
            msg.append("Senha muito longa.");
            control = false;
        }
        return(control);
    }
    
    public static Boolean validaCpf(String cpf, StringBuilder msg){
       // msg.setLength(0);
        
        if(cpf.isEmpty()){
            msg.append("Campo de CPF vazio.");
            return(false);
        }else if(!validaCpfNum(cpf, msg)){
            return(false);
        }else{
            return(true);
        }
    }
    
    public static Boolean validaRg(String rg, StringBuilder msg){
        //msg.setLength(0);
        if(rg.isEmpty()){
            msg.append("Campo de RG vazio.");
            return(false);
        }else{
            return(true);
        }
    }
    
    public static Boolean validaIdade(int idade, StringBuilder msg){
       // msg.setLength(0);
        
        if(idade > 0){
            if(idade < 100){
                return(true);
            }else{
                msg.append("Idade inválida(acima de 100 anos).");
                return(false);
            }
        }else{
            msg.append("Idade inválida(negativa).");
            return(false);
        }
    }
    
    public static Boolean validaCadastroV(String nome, String cpf, String rg, int idade, int tipo, StringBuilder msg){       
        boolean nomeV = validaNome(nome, msg);
        boolean cpfV = validaCpf(cpf, msg);
        boolean rgV = validaRg(rg, msg);
        boolean idadeV = validaIdade(idade, msg);
        boolean tipoV = (tipo == TIPO_VISITANTE);
        
        return(nomeV && cpfV && rgV && idadeV && tipoV);  
    } 
}
