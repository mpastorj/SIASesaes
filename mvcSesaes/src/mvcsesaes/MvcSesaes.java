/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *///
package mvcsesaes;

import controlador.controladorPersona;
import modelo.Facultad;
import modelo.Persona;
import vista.VentanaIngreso;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */
//
//
public class MvcSesaes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona modelo = new Persona();
        //Facultad modelofacultad=new Facultad();
        VentanaPrincipal vista = new VentanaPrincipal(); 
        //VentanaIngreso vista2=new VentanaIngreso();

        controladorPersona controlador = new controladorPersona( vista,modelo );
        //controladorPersona controlador = new controladorPersona( vista2,modelofacultad );
        //vista2.setVisible(true);
        vista.setVisible(true);
        //se inicia la vista
        controlador.iniciar_vista();
        // TODO code application logic here
    }
}