/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

/*
    Classe para validação das informações.
*/
public final class Valida {
    
    public static Boolean validaLogin(String Login, String Password, StringBuilder msg){ //MÉTODO DE VALIDAÇÃO DE PREENCHIMENTO DE CAMPOS
        msg.setLength(0);
        
        boolean control = true;
        
        if(Login.isEmpty()){
            msg.append("Campo de usuário vazio.");
            control = false;
        }
        if(Password.isEmpty()){
            msg.append("Campo de senha vazio.");
            control = false;
        }
        
        return(control);     
    }
    
    public static Boolean ValidaPassword(String Login, String Password, StringBuilder msg){
        msg.setLength(0);
        
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
    
    
 
}
