/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidaRegex {
    
    public static Boolean validaLetras(String letras, StringBuilder msg){
        msg.setLength(0);
        
        String pattern = "[a-zA-Z][a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü ']*$";
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(letras);
        
        if(!matcher.matches()){
            msg.append("Caracteres especiais inválidos.");
            return(false);
        }else{
            return(true);
        }
    }
    
    public static Boolean validaCpfNum(String numeros, StringBuilder msg){
        msg.setLength(0);
        
        String pattern = "[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$";
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(numeros);
        
        if(!matcher.matches()){
            msg.append("Digite apenas os números, pontos e traços do cpf.");
            return(false);
        }else{
            return(true);
        }
    }
    
    public static Boolean validaNumeros(String n, StringBuilder msg){
        msg.setLength(0);
        
        String pattern = "[0-9][0-9]";
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(n);
        
        if(!matcher.matches()){
            msg.append("Digite apenas números.");
            return(false);
        }else{
            return(true);
        } 
    }
}
