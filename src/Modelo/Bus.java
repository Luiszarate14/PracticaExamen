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
public class Bus implements  Vehiculo{
    private String placa;
    private int peso,cantLlantas,cantidadPasajero;

    public Bus(String placa, int peso, int cantLlantas, int cantidadPasajero) {
        this.placa = placa;
        this.peso = peso;
        this.cantLlantas = cantLlantas;
        this.cantidadPasajero = cantidadPasajero;
    }

    public Bus() {
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCantLlantas() {
        return cantLlantas;
    }

    public void setCantLlantas(int cantLlantas) {
        this.cantLlantas = cantLlantas;
    }

    public int getCantidadPasajero() {
        return cantidadPasajero;
    }

    public void setCantidadPasajero(int cantidadPasajero) {
        this.cantidadPasajero = cantidadPasajero;
    }
    
    @Override
    public int gastoGasolina() {
        return ((cantLlantas*(peso*5))-cantidadPasajero)/10;
    }
}
