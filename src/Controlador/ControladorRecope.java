/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Bd_Gasolineras;
import Modelo.Bd_Vehiculo;
import Modelo.Gasolinera;
import Modelo.Recope;
import Vista.VistaRecope;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ControladorRecope implements ActionListener{
    private Bd_Vehiculo bd_Vehiculo;
    private VistaRecope vistaRecope;
    private Gasolinera gasolinera;
    private Bd_Gasolineras bdGasolinera;
    private Recope singleton;
    int i=0;
    int y=0;
    public ControladorRecope(VistaRecope recope) {
        this.bd_Vehiculo= new Bd_Vehiculo();
        this.vistaRecope=recope;
        bdGasolinera= new Bd_Gasolineras();
        singleton= Recope.getInstace();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {//falta hacer metodo de comprobaciones
        if(e.getActionCommand().equals("Agregar")){
            bd_Vehiculo.guardarvehiculo(vistaRecope.regresarNombre(),vistaRecope.getJtPlaca(),Integer.parseInt(vistaRecope.getJtCantLlantas()),
                    Integer.parseInt(vistaRecope.getJtPasajeros()),Integer.parseInt(vistaRecope.getJtPeso()));
            vistaRecope.setJlMensajes("Se agrego con exito");
            vistaRecope.limpiar();
            
        }
        else if(e.getActionCommand().equals("Simulacion")){
            
            if(bd_Vehiculo.tamanioArreglo()>0){// para que exista al menos un vehiculo
                try {
                    singleton.setGasolina(Integer.parseInt(vistaRecope.getJtCantGasolina()));//guardo la gasolina en RECOPE
                } catch (Exception ex) {
                    System.out.println("no guardo la gasolina");//esta guaradando un vector vacio sin referencia
                }
                
            gasolinera= new Gasolinera();
            bdGasolinera.agregarGasolinera(Integer.parseInt(vistaRecope.getJtCantGasolinera()), gasolinera);
            ///AQUI COMIENZA LA COMPROBOBACION DE LOS CICLO SE LLAMA AL METODO STRING DE ABAJO
                
             vistaRecope.setJlCiclos("ENTRO A SIMULACION");
                try {
                vistaRecope.setJlCiclos(""+cantidadDeCiclos());//ocurre un error
                } catch (Exception ex) {
                    System.out.println("ERROR DE CICLOS");
                }
                
            }
            else{
                vistaRecope.setJlCiclos("Ingrese al menos un vehiculo");
            }
            
            
        }
    }
    
     public String cantidadDeCiclos() throws Exception{
         
         int ciclos =0;
         boolean noGastoGaso=true;
         while(noGastoGaso){
            for(i=0;i<bd_Vehiculo.tamanioArreglo()&& noGastoGaso;i++){//primer for de los vehiculos
               for(;y<bdGasolinera.tamanioGasol();y++) { //esto es un array circular de gasolineras
                   System.out.println(" el velor de i es :"+i);
                   System.out.println("este es y "+ y);
                   System.out.println("boolean"+bdGasolinera.recorrerGasolinera(bd_Vehiculo.regresaVehiculo(i),y));
                   if(bdGasolinera.recorrerGasolinera(bd_Vehiculo.regresaVehiculo(i),y)){//posicion de donde gasolinera
                                                                                        //devuelve si dio o no gasolina 
                      y=bdGasolinera.tamanioGasol()+1;
                                             
                   }
                   else{
                       System.out.println("debe de salir");
                      y=bdGasolinera.tamanioGasol()+1;
                   }
                  
               }
               //noGastoGaso=true;
               y=y%bdGasolinera.tamanioGasol();
               System.out.println("tamanio gasolinera"+y);
               ciclos++;
                //System.out.println("cantidad de recope: "+singleton.getCantidadGasolina(0));
            }
            
            
        }//fin de while
         
         return ""+ciclos;
     }
    

}
