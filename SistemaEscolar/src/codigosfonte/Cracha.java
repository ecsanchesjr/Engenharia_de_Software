/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaescolar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import static sistemaescolar.CrachaDAO.getDateByCode;
import static sistemaescolar.CrachaDAO.getTimeByCode;

/**
 *
 * @author ecsan
 */
public class Cracha {
        
    /*
        Este método retorna, a partir do código do crachá, o estado do mesmo
        Possíveis retornos:
            "VÁLIDO" e "INVÁLIDO"
    */
    public static String getStateCrachaByCode(int code) throws ParseException{
        Date inicio = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        GregorianCalendar gc = new GregorianCalendar();
        
        int dia = gc.get(GregorianCalendar.DAY_OF_MONTH);
        int mes = gc.get(GregorianCalendar.MONTH)+1;
        int ano = gc.get(GregorianCalendar.YEAR);
        
        Date hoje = sdf.parse(""+dia+"-"+mes+"-"+ano);
        
        inicio = getDateByCode(code);
        
        String ini = sdf.format(inicio);
        String hj = sdf.format(hoje);

        if(ini.equals(hj)){
            Date inicioHr = new Date();
            
            SimpleDateFormat sdfHr = new SimpleDateFormat("HH:mm");
            int hora = gc.get(GregorianCalendar.HOUR_OF_DAY);
            int min = gc.get(GregorianCalendar.MINUTE);
            
            Date nowHr = sdfHr.parse(""+hora+":"+min);
            inicioHr = getTimeByCode(code);
            
            long interval = nowHr.getTime() - inicioHr.getTime();
            
            if(interval <= 21600000){
                return("VÁLIDO");
            }else{
                return("INVÁLIDO");
            }
        }else{
            return("INVÁLIDO");
        }      
    }
}
