/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Atencion;
import modelo.Carrera;
import modelo.Especialidad;
import modelo.Facultad;
import modelo.Profesional;
import vista.VentanaConfiguracion;
import vista.VentanaIngreso;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */

//
public class controladorConfiguracion implements ActionListener{

    private VentanaPrincipal vista;

    

    public controladorConfiguracion(VentanaPrincipal vista) {
        this.vista = vista;
        vista.botonconfiguracion.addActionListener(this);
    }
    
    

        
    @Override
    public void actionPerformed(ActionEvent e) {
        
        VentanaConfiguracion ventana=new VentanaConfiguracion();

        ventana.setVisible(true);
        ventana.setTitle("> Configuración");
        
        
        controladorAjustesIngreso contajustes=new controladorAjustesIngreso(ventana);
        controladorAjustesEliminar conteliminar=new controladorAjustesEliminar(ventana);
    }
    
}
