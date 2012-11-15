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
        //vista.botoningresar.action(new VentanaIngreso().setVisible(true));
      
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
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
        //modelocarrera.setCod_f(modelo.getCod_f());
        int numeroentero= modelo.getCod_f();
        String numFacultad= Integer.toString(numeroentero);
        vista.codigofacultad.setText(numFacultad);
        //SETEAR CODIGO F
        //modelocarrera.setCod_f(modelo.getCod_f());
        /*try {
            modelocarrera.leer();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       // vista.listacarrera.addItem(modelocarrera.getNombres_c());
        //throw new UnsupportedOperationException("Not supported yet.");
        //Facultad modelofacultad=new Facultad();
        Carrera modelocarrera=new Carrera();
        VentanaIngreso ventana = new VentanaIngreso();
        ventana.setVisible(true);
        
        //controladorFacultad contfacultad=new controladorFacultad(ventana,modelofacultad);
        controladorCarrera contcarrera=new controladorCarrera(ventana,modelocarrera);
        modelocarrera.setCod_f(modelo.getCod_f());
        //se inicia la vista
        contcarrera.iniciar_vista();
    }
    
}
