/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import basededatos.atencionBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Atencion;
import vista.VentanaDiurna;
import vista.VentanaIngreso;
import vista.VentanaPrincipal;
import vista.VentanaTabla;

/**
 *
 * @author Milii2
 */

public class controladorDiurna implements ActionListener{

    private VentanaPrincipal vista;
    private VentanaDiurna ventana;

    public controladorDiurna() {
    }

    public controladorDiurna(VentanaPrincipal vista) {
        this.vista = vista;
        this.vista.botondiurna.addActionListener(this);
    }
   
   
    @Override
    public void actionPerformed(ActionEvent e) {
        VentanaDiurna ventana=new VentanaDiurna();
        ventana.setVisible(true);   
        ventana.setTitle("> Estadísticas Diurna");
        controladorEstadisticasProfesional contesta=new controladorEstadisticasProfesional(ventana);
        controladorEstadisticasCarrera contcarrera=new controladorEstadisticasCarrera(ventana);
        controladorEstadisticasFacultad contfacultad=new controladorEstadisticasFacultad(ventana);
        controladorEstadisticaDiurna controladorprincipal=new controladorEstadisticaDiurna(ventana);    
        controladorEstadisticasEspecialidad contprofesional=new controladorEstadisticasEspecialidad(ventana);
    }
    
    
    
}
