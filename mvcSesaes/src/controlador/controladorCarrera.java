/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import basededatos.facultadBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Carrera;
import vista.VentanaIngreso;



/**
 *
 * @author Milii2
 */
public class controladorCarrera implements ActionListener{
    
    private VentanaIngreso vista;
    private facultadBD facultadBD;
    private Carrera modelo;
 
    
    public controladorCarrera(Carrera modelo){
    this.modelo = modelo;
    }

    public controladorCarrera(VentanaIngreso vista, Carrera modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.listacarrera.addActionListener(this);
    }

    
     public void llenar(ArrayList <String> c){
         for(String arreglodecarreras:c)
         vista.listacarrera.addItem(arreglodecarreras);
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String titulocarrera=(String) vista.listacarrera.getSelectedItem();
        modelo.setNombre_c(titulocarrera);
        
        try {
            modelo.buscar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
      
}
