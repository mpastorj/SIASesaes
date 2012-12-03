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

/**
 *
 * @author Milii2
 */

public class controladorDiurna implements ActionListener{

    private VentanaPrincipal vista;

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
    }
    
    
    
}
