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
import modelo.Facultad;
import vista.VentanaIngreso;
import vista.VentanaPrincipal;
import modelo.Carrera;
import modelo.Especialidad;
import modelo.conexion;

/**
 *
 * @author Milii2
 */

public class controladorFacultad implements ActionListener{
    private VentanaIngreso vista;
    private Facultad modelo;
    private Carrera modelocarrera;
    

 public controladorFacultad(){}   
    
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
      
        //vista.listatipo.addActionListener(this);
        //vista.listaespecialidad.disable();
        vista.setTitle(" > Ingreso ");
      
    }
    
   
 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int numerotipo=0;
        String tipodeingreso=(String) vista.listatipo.getSelectedItem();
        if("Diurno".equals(tipodeingreso)){
            numerotipo=1;
        }
        else{
            numerotipo=2;
        }
        
       
        int numeroentero=0;
        String nombrefacultad=(String) vista.listafacultad.getSelectedItem();
        modelo.setNombre_f(nombrefacultad);
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
        
        numeroentero= modelo.getCod_f();
        String numFacultad= Integer.toString(numeroentero);
       // vista.codigofacultad.setText(numFacultad);

        //-- HASTA ACA OBTIENE CODIGO DE FACULTAD
        
        modelocarrera = new Carrera();
        
        modelocarrera.setCod_f(numeroentero);
  
        //ACA SE LLENA EL JCOMBOBOX DE CARRERAS SEGUN FACULTAD
            ArrayList <String> nombres_c = new ArrayList();
            ArrayList <String> codigos_c=new ArrayList();
            conexion cdb=new conexion();
        
            cdb.setEsSelect(true);
            cdb.setComandoSQL("select nombre_c,tipo,cod_c  from carrera where tipo='"+numerotipo+"' and cod_f='"+numFacultad+"' order by cod_c" );
            cdb.conectar();
            
            try {  
            while(cdb.getRst().next())
            {
               String nombre_c =cdb.getRst().getString("nombre_c");
               String codigo_c=cdb.getRst().getString("cod_c");
               nombres_c.add(nombre_c);    
               codigos_c.add(codigo_c);
            }
            } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al cargar lista de carreras segun facultad", ex);
            } 
            
            cdb.cerrarConexion();
            
            vista.listacarrera.removeAllItems();
           // String arreglodecodigos=codigos_c;
            int cantidad=codigos_c.size();
            int i=0;
            for(i=0;i<cantidad;i++){
           // for(String arreglodecarreras:nombres_c){
            vista.listacarrera.addItem(codigos_c.get(i)+" - "+nombres_c.get(i));
            //}
            }
            
        //-------------------------------------------
            
            String titulocarrera=(String) vista.listacarrera.getSelectedItem();
            modelocarrera.setNombre_c(titulocarrera);
            
            vista.listacarrera.enable();
            vista.cantidadatenciones.enable();
    }
    
    
}
