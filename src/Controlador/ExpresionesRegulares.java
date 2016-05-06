/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Expression EXDER is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class ExpresionesRegulares {
    public static final String placapattern="[a-z]{2}\\d+{4}";
    
    public boolean validarPlaca(String placa){
        Pattern pattern= Pattern.compile(placapattern,Pattern.CASE_INSENSITIVE);
        Matcher match= pattern.matcher(placa);
        return match.find();
    }
}