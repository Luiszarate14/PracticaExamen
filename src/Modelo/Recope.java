/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author user
 */
public class Recope {
    private int CANTIDAD_GASO=0;
    private static Recope recope= new Recope();
    private Recope() { 
        
    }
    
    public int getCantidadGasolina(int cantidad)throws Exception{
        System.out.println("recope cantidad: "+ CANTIDAD_GASO);
        if(CANTIDAD_GASO>0&&cantidad<CANTIDAD_GASO){
            CANTIDAD_GASO=CANTIDAD_GASO-cantidad;
        }
        else if(CANTIDAD_GASO==0){
            CANTIDAD_GASO=CANTIDAD_GASO-cantidad;
        }
        return CANTIDAD_GASO=CANTIDAD_GASO-cantidad;
    }
    
    public static Recope getInstace(){
        return recope;
    }
    public void setGasolina(int cant){
        CANTIDAD_GASO=cant;
    }
}
