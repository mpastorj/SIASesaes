/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaDiurna;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */
public class controladorVespertina implements ActionListener{

    private VentanaPrincipal vista;

    public controladorVespertina(VentanaPrincipal vista) {
        this.vista = vista;
        this.vista.botonvespertina.addActionListener(this);
    }

    public controladorVespertina() {
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        VentanaDiurna ventana=new VentanaDiurna();
        ventana.setVisible(true);
        ventana.setTitle("> Estadísticas Vespertina");
        controladorEstadisticasProfesional contesta=new controladorEstadisticasProfesional(ventana);
        controladorEstadisticasFacultad contfacultad=new controladorEstadisticasFacultad(ventana);
        controladorEstadisticasCarreraVespertina contcarrera=new controladorEstadisticasCarreraVespertina(ventana);
        controladorEstadisticaVespertina controladorprincipal=new controladorEstadisticaVespertina(ventana);
    }
    
}
