/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *///
package mvcsesaes;

import controlador.controladorPersona;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
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
//
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        
      
/*LookAndFeelInfo[] lista = UIManager.getInstalledLookAndFeels();
for (int i = 0; i < lista.length; i++) {
	System.out.println(lista[i].getClassName());
}*/

        //UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        //UIManager.setLookAndFeel("UIManager.setLookAndFeel(\"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel\");");
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        
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