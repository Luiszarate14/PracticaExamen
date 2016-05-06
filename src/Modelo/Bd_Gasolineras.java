/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Bd_Gasolineras {
    ArrayList<Gasolinera> arregloGasolinera;
//    Recope recope;

    public Bd_Gasolineras() {
        arregloGasolinera= new ArrayList<Gasolinera>();
    }
    public void agregarGasolinera(int cantidadGasolineras,Gasolinera gas){
        for(int i=cantidadGasolineras;i>0;i--){
            arregloGasolinera.add(gas);
        }
    }
    public int tamanioGasol(){
        return arregloGasolinera.size();
    }
    public boolean recorrerGasolinera(Vehiculo vehiculo,int posicionGaso) throws Exception{
        //envia el gasto del vehiculo y a la vez lo resta si se puede o devuele false si no resto
        return arregloGasolinera.get(posicionGaso).darGasolinaVehiculo(vehiculo);//esto dice que si gasto 
    }
}
