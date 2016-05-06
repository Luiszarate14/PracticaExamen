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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.AyudanteOS;
import utilidades.Escritor;
import utilidades.Lector;

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
    private AyudanteOS ayudaos;
    private Escritor escritor;
    private Lector lector;
    int i=0;
    int y=0;
    private ExpresionesRegulares expresiones;
    public ControladorRecope(VistaRecope recope) {
        this.bd_Vehiculo= new Bd_Vehiculo();
        this.vistaRecope=recope;
        bdGasolinera= new Bd_Gasolineras();
        singleton= Recope.getInstace();
        ayudaos= new AyudanteOS();
        escritor=  new Escritor();
        lector= new Lector();
        expresiones= new ExpresionesRegulares();
        bd_Vehiculo.setVehiculos((ArrayList)lector.read_xml("vehiculos.xml"));
    }
    @Override
    public void actionPerformed(ActionEvent e) {//falta hacer metodo de comprobaciones
        
        if(e.getActionCommand().equals("Agregar")){
            System.out.println("expresiones: "+expresiones.validarPlaca(vistaRecope.getJtPlaca()));
            if(expresiones.validarPlaca(vistaRecope.getJtPlaca())){
                bd_Vehiculo.guardarvehiculo(vistaRecope.regresarNombre(),vistaRecope.getJtPlaca(),Integer.parseInt(vistaRecope.getJtCantLlantas()),
                        Integer.parseInt(vistaRecope.getJtPasajeros()),Integer.parseInt(vistaRecope.getJtPeso()));
                vistaRecope.setJlMensajes("Se agrego con exito");
                vistaRecope.limpiar();
                escritor.with_obj_in_file_xml("vehiculos.xml", bd_Vehiculo.arregloVehiculo());
                System.out.println("-.- :" + bd_Vehiculo.tamanioArreglo());
            }
            else
                vistaRecope.setJlMensajes("Esta placa es invalida");
        }
        else if(e.getActionCommand().equals("Simulacion")){
            
            if(bd_Vehiculo.tamanioArreglo()>0){// para que exista al menos un vehiculo
                try {
                    singleton.setLaCantidadGasolina(Integer.parseInt(vistaRecope.getJtCantGasolina()));//guardo la gasolina en RECOPE
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
                System.out.println("ANTES DEEE");
                System.out.println("tamanio arreglo vehiculo"+ bd_Vehiculo.tamanioArreglo());
//System.out.println("aqui: "+bdGasolinera.recorrerGasolinera(bd_Vehiculo.regresaVehiculo(i),y));///revisar error de entrada
                //error arriba revisar devuelve false- deberia devolver true;
                
               if(bdGasolinera.recorrerGasolinera(bd_Vehiculo.regresaVehiculo(i), y)){//vehiculo y posicion
                       //metodo anterior verifica q traiga el primer vehiculo y la gasolinera para q 
                       //se reste respectivamente
                       System.out.println("se ha dado la gasolina");
                       y=y%bdGasolinera.tamanioGasol();
                        System.out.println("tamanio gasolinera:"+y);
                   }
                   else{
                       System.out.println("La gasolina es insuficiente");
                       noGastoGaso=false;
                   }
               ciclos++;
            }//fin de ciclos vehiculos
            
            
        }//fin de while
         
         return ""+ciclos;
     }
    

}
