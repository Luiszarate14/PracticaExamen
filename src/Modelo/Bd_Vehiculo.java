/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Fabrica.Fabrica_Metodos;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author user
 */
public class Bd_Vehiculo {
    ArrayList<Vehiculo> arregloVehiculo;
    private Fabrica_Metodos fabrica;
   // Vehiculo elVehiculo;
    
    public Bd_Vehiculo() {
        arregloVehiculo= new ArrayList<Vehiculo>();
        fabrica= new Fabrica_Metodos();
    }
    public void guardarvehiculo(String nombre,String placa,int cantLlantas,int cantPasaj,int peso) {
        arregloVehiculo.add(fabrica.getVehiculo(nombre, placa, cantLlantas, cantPasaj, peso));
        System.out.println("No hay error");
    }
    public int tamanioArreglo(){
        return arregloVehiculo.size();
    }
    public Vehiculo regresaVehiculo(int posicion){
       
        return arregloVehiculo.get(posicion);
    }
    public ArrayList arregloVehiculo(){
        return arregloVehiculo;
    }
    public void setVehiculos(ArrayList object){
        if(object!=null)
        arregloVehiculo=object;
    }
    
}
