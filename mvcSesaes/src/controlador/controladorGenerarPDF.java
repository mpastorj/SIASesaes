/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaDiurna;
import vista.VentanaTabla;

/**
 *
 * @author Pedro
 */
public class controladorGenerarPDF implements ActionListener{
    
    
    private VentanaTabla vista;
    

    public controladorGenerarPDF(VentanaTabla vista) {
       this.vista = vista;
       this.vista.botonreporte.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
      
    controladorReportes r = new controladorReportes("Psiquiatría","2012",12);
        
        
        
    }
    
}
