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
public class Gasolinera {
    private Recope recope;
    public Gasolinera() {
       recope= Recope.getInstace();
    }
    public boolean darGasolinaVehiculo(Vehiculo vehiculo) throws Exception{//regres a recope la cantidad de gasolina  
        boolean dioGas=false;
        if(recope.getCantidadGasolina()-vehiculo.gastoGasolina()>=0){
            recope.setGasolinaGasto(vehiculo.gastoGasolina());//hace la comprobacion si devuelve un numero q sepueda restar
            dioGas=true;
        }
        return dioGas;
    }
}