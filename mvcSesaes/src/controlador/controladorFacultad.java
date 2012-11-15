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
import modelo.Facultad;
import modelo.Persona;
import vista.VentanaIngreso;
import vista.VentanaPrincipal;
import modelo.Carrera;

/**
 *
 * @author Milii2
 */

public class controladorFacultad implements ActionListener{
    private VentanaIngreso vista;
    private Facultad modelo;
    private facultadBD facultadBD;
    private Carrera modelocarrera;
    
    
    public controladorFacultad(VentanaIngreso vista,Facultad modelo){
       this.vista=vista;
       this.modelo=modelo;
       this.vista.listafacultad.addActionListener(this);

    }
    public controladorFacultad(VentanaIngreso vista, Facultad modelo, Carrera modelocarrera){
        this.vista=vista;
        this.modelo=modelo;
        this.modelocarrera=modelocarrera;
        this.vista.listafacultad.addActionListener(this);
    }
    
    public void iniciar_vista(){
        
        vista.botonfacultad.setText("Ingresar");
        vista.setTitle(" > Ingreso ");
      
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int numeroentero=0;
        String nombrefacultad=(String) vista.listafacultad.getSelectedItem();
        modelo.setNombre_f(nombrefacultad);
        try {
            modelo.leer();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        numeroentero= modelo.getCod_f();
        String numFacultad= Integer.toString(numeroentero);
        vista.codigofacultad.setText(numFacultad);

        Carrera modelocarrera=new Carrera();
        VentanaIngreso ventana = new VentanaIngreso();
        ventana.setVisible(true);
        
        controladorCarrera contcarrera=new controladorCarrera(ventana,modelocarrera);
        modelocarrera.setCod_f(modelo.getCod_f());
        numeroentero=0;
        
        contcarrera.iniciar_vista();
    }
    
    
}
