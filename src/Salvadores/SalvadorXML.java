/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salvadores;


import Modelo.Bd_Gasolineras;
import Modelo.Bd_Vehiculo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.AyudanteOS;
import utilidades.Escritor;
import utilidades.Lector;

/**
 *
 * @author luisza
 */
public class SalvadorXML{

    private Escritor escritor;
    private AyudanteOS ayudaos;

    public SalvadorXML() {
        escritor = new Escritor();
        ayudaos = new AyudanteOS();
    }
    
   
    public void guardaGasolinera(ArrayList<Bd_Gasolineras> gasolinera) {
        try {
            escritor.with_obj_in_file_xml(
                    ayudaos.get_config_file("gasolineras.xml"),
                    gasolinera);
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   
    public ArrayList<Bd_Gasolineras> obteneerGasolineras() {
        Lector<ArrayList<Bd_Gasolineras>> lector = new Lector<>();
        String filepath=null;
        try {
            filepath = ayudaos.get_config_file("gasolineras.xml");
        } catch (IOException ex) {
            Logger.getLogger(SalvadorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lector.read_xml(filepath);       
    }
      public void guardaVehiculos(ArrayList<Bd_Vehiculo> vehiculo) {
        try {
            escritor.with_obj_in_file_xml(
                    ayudaos.get_config_file("vehiculos.xml"),
                    vehiculo);
        } catch (IOException ex) {
            System.out.println("Error en guardar");
        }
    }
      public ArrayList<Bd_Vehiculo> obtenerVehiculos() {
        Lector<ArrayList<Bd_Vehiculo>> lector = new Lector<>();
        String filepath=null;
        try {
            filepath = ayudaos.get_config_file("vehiculos.xml");
        } catch (IOException ex) {
            System.out.println("Error en obtener");
        }
        return lector.read_xml(filepath);       
    }
  }