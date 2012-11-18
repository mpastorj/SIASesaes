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
import modelo.Especialidad;
import modelo.Profesional;
import modelo.conexion;
import vista.VentanaIngreso;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */
public class controladorEspecialidad implements ActionListener{

    private VentanaIngreso vista;
    private Especialidad modelo;
    private especialidadBD especialidadBD;
    private Profesional modeloprofesional;
    

 public controladorEspecialidad(){}   

    public controladorEspecialidad(VentanaIngreso vista, Especialidad modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.listaespecialidad.addActionListener(this);
    }
    
        public void iniciar_vista(){
        
        //vista.setTitle(" > Prueba ");
      
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
              
        int numeroentero_e=0;
        String nombreespecialidad=(String) vista.listaespecialidad.getSelectedItem();
        modelo.setNombre_e(nombreespecialidad);
        //MODELO.LEER(MODELO) CARGA CODIGO DE ESPECIALIDAD EN JTEXTBOX
        try { 
            modelo.leer(modelo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(controladorFacultad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        numeroentero_e= modelo.getCod_e();
        String numEspecialidad= Integer.toString(numeroentero_e);
        //vista.codigoespecialidad.setText(numEspecialidad);
        
        modeloprofesional=new Profesional();
        
        modeloprofesional.setCod_e(numeroentero_e);
        
        //LLENADO DE JCOMBOBOX SEGUN ESPECIALIDAD
            ArrayList <String> nombres_p = new ArrayList();
            conexion cdb=new conexion();
        
            cdb.setEsSelect(true);
            cdb.setComandoSQL("select nombre_p  from profesional where cod_p IN (select cod_p from profeespe where cod_e=(select cod_e from especialidad where nombre_e='"+modelo.getNombre_e()+"'))" );
            cdb.conectar();
            
            try {  
            while(cdb.getRst().next())
            {
               String nombre_p =cdb.getRst().getString("nombre_p");
                
               nombres_p.add(nombre_p);       
            }
            } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al cargar lista de carreras segun facultad", ex);
            } 
            cdb.cerrarConexion();
            
            vista.listaprofesional.removeAllItems();
      
            for(String arreglodeprofesionales:nombres_p)
            vista.listaprofesional.addItem(arreglodeprofesionales); 
            
        //------------------------------------------
            
            String nombreprofesional=(String) vista.listaprofesional.getSelectedItem();
            modeloprofesional.setNombre_p(nombreprofesional);
                
    }
   
}
