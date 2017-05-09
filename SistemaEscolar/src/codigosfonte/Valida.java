/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import static codigosfonte.ValidaRegex.*;
import static codigosfonte.Constantes_Tipos.*;

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
        
        if(nome.isEmpty()){
            msg.append("Nome vazio. ");
            return(false);
        }else if(nome.length() > 100){
            msg.append("Nome muito grande. ");
            return(false);
        }
        else if(!validaLetras(nome, msg)){
            return(false);
        }
        else{
            return(true);
        }
    }
    
    public static Boolean validaPassword(String Login, String Password, StringBuilder msg){
       // msg.setLength(0);
        
        boolean control = true;
        
        if(Login.isEmpty()){
            msg.append("Campo de usuario vazio. ");
            control = false;
        }
        
        if(Password.isEmpty()){
            msg.append("Campo de senha vazio.");
            control = false;
        }
        if(Password.length() <= 5){
            msg.append("Senha muito curta. ");
            control = false;
        }
        if(Password.length() > 20){
            msg.append("Senha muito longa. ");
            control = false;
        }
        return(control);
    }
    
    public static Boolean validaCpf(String cpf, StringBuilder msg){
       // msg.setLength(0);
        
        if(cpf.isEmpty()){
            msg.append("Campo de CPF vazio. ");
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
            msg.append("Campo de RG vazio. ");
            return(false);
        }else{
            return(true);
        }
    }
    
    public static Boolean validaIdade(int idade, StringBuilder msg){
       // msg.setLength(0);
        
        if(idade > 0){
            if(idade < 200){
                return(true);
            }else{
                msg.append("Idade inválida(acima de 200 anos). ");
                return(false);
            }
        }else{
            msg.append("Idade inválida(negativa). ");
            return(false);
        }
    }
    
    private static boolean validaEmail(String email, StringBuilder msg) {
        if(email.isEmpty()){
            msg.append("Campo de e-mail vazio. ");
            return(false);
        }else if(validaEmailRegex(email, msg)){
            return(true);
        }else{
            return(false);
        }
    }
    
    private static boolean validaNick(String nick, StringBuilder msg) {
        if(nick.isEmpty()){
            msg.append("Campo de nick vazio. ");
            return(false);
        }else if(validaNickRegex(nick, msg)){
            return(true);
        }else{
            return(false);
        }
    }
    
    
    private static boolean validaPass(String passwd1, String passwd2, StringBuilder msg) {
        if(passwd1.isEmpty()){
            msg.append("Campo de senha vazio. ");
            return(false);
        }else if(passwd2.isEmpty()){
            msg.append("Campo de repetir senha vazio. ");
            return(false);
        }else if(!passwd1.equals(passwd2)){
            msg.append("Campos de senha não são iguais.");
            return(false);
        }else{
            return(true);
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
    
    public static Boolean validaCadastroA(String nome, String cpf, String rg, int idade, String email, String nick, String passwd1, String passwd2, int tipo, StringBuilder msg){
        boolean nomeA = validaNome(nome, msg);
        boolean cpfA = validaCpf(cpf, msg);
        boolean rgA = validaRg(rg, msg);
        boolean idadeA = validaIdade(idade, msg);
        boolean emailA = validaEmail(email, msg);
        boolean nickA = validaNick(nick, msg);
        boolean passwdA = validaPass(passwd1, passwd2, msg);
        boolean tipoA = (tipo == TIPO_ALUNO);
         
        return(nomeA && cpfA && rgA && idadeA && emailA && nickA && passwdA && tipoA);
    }
    
    public static Boolean validaCadastroP(String nome, String cpf, String rg, int idade, String nick, String passwd1, String passwd2, int tipo, StringBuilder msg){
        boolean nomeP = validaNome(nome, msg);
        boolean cpfP = validaCpf(cpf, msg);
        boolean rgP = validaRg(rg, msg);
        boolean idadeP = validaIdade(idade, msg);
        boolean nickP = validaNick(nick, msg);
        boolean passwdP = validaPass(passwd1, passwd2, msg);
        boolean tipoP = (tipo == TIPO_PROFESSOR);
         
        return(nomeP && cpfP && rgP && idadeP && nickP && passwdP && tipoP);
    }
    
    public static Boolean validaCadastroF(String nome, String cpf, String rg, int idade, String nick, String passwd1, String passwd2, int tipo, StringBuilder msg){
        boolean nomeF = validaNome(nome, msg);
        boolean cpfF = validaCpf(cpf, msg);
        boolean rgF = validaRg(rg, msg);
        boolean idadeF = validaIdade(idade, msg);
        boolean nickF = validaNick(nick, msg);
        boolean passwdF = validaPass(passwd1, passwd2, msg);
        boolean tipoF = (tipo == TIPO_FUNCIONARIO);
         
        return(nomeF && cpfF && rgF && idadeF && nickF && passwdF && tipoF);
    }
    
}
