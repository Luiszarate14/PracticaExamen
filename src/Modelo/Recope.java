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
    private int CANTIDAD_GASO=0;//la gasolina
    private static Recope recope= new Recope();//  singleton  //
    private Recope() { 
        /**
        *
        *
        **/
    }   
    public int getCantidadGasolina()throws Exception{ ///el error radica en el hecho de que hay dos restas
        return CANTIDAD_GASO;//true hay gasolinaif()
    }
    public void setLaCantidadGasolina(int gasto){
        CANTIDAD_GASO=gasto;
    }
    public void setGasolinaGasto(int gasto){
        CANTIDAD_GASO=CANTIDAD_GASO-gasto;
    }
    public static Recope getInstace(){//recope.setGasolina
        return recope;
    }
}