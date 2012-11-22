/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import basededatos.especialidadBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Profesional;
import vista.VentanaIngreso;

/**
 *
 * @author Milii2
 */
public class controladorProfesional implements ActionListener{

    private VentanaIngreso vista;
    private especialidadBD especialidadBD;
    private Profesional modelo;
 
 
    public controladorProfesional(Profesional modelo){
    this.modelo = modelo;
    }

    public controladorProfesional(VentanaIngreso vista, Profesional modelo) {
        this.vista = vista;
        this.modelo = modelo;
       this.vista.listaprofesional.addActionListener(this);
    }
    
    public void llenar(ArrayList <String> p){
         for(String arreglodeprofesionales:p)
         vista.listaprofesional.addItem(arreglodeprofesionales);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String nombreprofesional=(String) vista.listaprofesional.getSelectedItem();
        modelo.setNombre_p(nombreprofesional);
        try {
            modelo.buscar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorProfesional.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(controladorProfesional.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(controladorProfesional.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(controladorProfesional.class.getName()).log(Level.SEVERE, null, ex);
        }

  
    }
    
     
}
