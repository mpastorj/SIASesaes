/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *///
package mvcsesaes;

import controlador.controladorConfiguracion;
import controlador.controladorDiurna;
import controlador.controladorPersona;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Persona;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */

public class MvcSesaes {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        
        Persona modelo = new Persona();
        VentanaPrincipal vista = new VentanaPrincipal(); 

        controladorPersona controlador = new controladorPersona( vista,modelo );
        controladorConfiguracion contconfig=new controladorConfiguracion(vista);
        controladorDiurna contdiurna=new controladorDiurna(vista);
        vista.setVisible(true);
        
        controlador.iniciar_vista();
    }
}