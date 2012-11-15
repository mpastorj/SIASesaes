/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import basededatos.facultadBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Carrera;
import modelo.Facultad;
import vista.VentanaIngreso;

/**
 *
 * @author Milii2
 */
public class controladorCarrera implements ActionListener{
    
    private VentanaIngreso vista;
    private facultadBD facultadBD;
    private Carrera modelo;
    
    public controladorCarrera(VentanaIngreso vista,Carrera modelo){
       this.vista=vista;
       this.modelo=modelo;
       this.vista.botonfacultad.addActionListener(this);

    }
    
        public void iniciar_vista(){
        vista.botonfacultad.setText("NADA QUE VER");
      
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            modelo.leer();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorCarrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(controladorCarrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(controladorCarrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(controladorCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(String arreglodecarreras:modelo.nombres_c)
            vista.listacarrera.addItem(arreglodecarreras);
        
        vista.botonfacultad.setText("NADA QUE VER");
   
    }
      
}
