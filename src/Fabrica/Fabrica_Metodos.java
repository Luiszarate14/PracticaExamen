/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fabrica;

import Modelo.Automovil;
import Modelo.Bus;
import Modelo.Moto;
import Modelo.Vehiculo;

/**
 *
 * @author user
 */
public class Fabrica_Metodos {
    private Vehiculo instaciaVehiculo;
    public Vehiculo getVehiculo(String nombre,String placa,int cantLlantas,int cantPasaj,int peso){
        switch(nombre){
            case "Moto":
                instaciaVehiculo=new Moto(placa, peso, cantLlantas, cantPasaj);
             break;
            case "Bus":
                instaciaVehiculo= new Bus(placa, peso, cantLlantas, cantPasaj);
                break;
            case "Vehiculo":
                instaciaVehiculo= new Automovil(placa, peso, cantLlantas, cantPasaj);
                break;
        }
        return instaciaVehiculo;
    }
}
