/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import vista.VentanaDiurna;

/**
 *
 * @author Milii2
 */
public class controladorEstadisticaDiurna implements ActionListener{

    private VentanaDiurna ventana;
    private AbstractButton opcionProfesional;

    public controladorEstadisticaDiurna(VentanaDiurna ventana) {
        this.ventana = ventana;
        this.ventana.botonmostrar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
             
      
    }
           
    
}
