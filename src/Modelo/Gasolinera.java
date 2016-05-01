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
    int cantidadGas=0;
    int cantidadGasolina=0;
    private Recope recope;
    public Gasolinera() {
       recope= Recope.getInstace();
    }
    public int darGasolinaVehiculo(Vehiculo vehiculo) throws Exception{//regres a recope la cantidad de gasolina
        
       return recope.getCantidadGasolina(vehiculo.gastoGasolina());///y se comprueba si se vendio
    }
    //si es mayor que 0 significa que se puede vender a ese vehiculo
}
