/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import basededatos.especialidadBD;
import basededatos.facultadBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Atencion;
import modelo.Carrera;
import modelo.Especialidad;
import modelo.Facultad;
import modelo.Profesional;
import modelo.conexion;
import vista.VentanaIngreso;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */
public class controladorAtencion implements ActionListener{

    private VentanaIngreso vista;
    private Especialidad modelo_especialidad;
    private especialidadBD especialidadBD;
    private Facultad modelo_facultad;
    private facultadBD facultadBD;
    private Carrera modelo_carrera;
    private Profesional modelo_profesional;
    private Atencion modelo_atencion;

    public controladorAtencion(VentanaIngreso vista, Carrera modelo_carrera, Profesional modelo_profesional, Atencion modelo_atencion) {
        this.vista = vista;
        this.modelo_carrera = modelo_carrera;
        this.modelo_profesional = modelo_profesional;
        this.modelo_atencion = modelo_atencion;
        this.vista.botondeingreso.addActionListener(this);
    }


    public controladorAtencion(Carrera modelo_carrera) {
        this.modelo_carrera = modelo_carrera;
    }

  
    public controladorAtencion(){
   
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        int codigoalumno=0;
        String numero_atenciones=(String) vista.cantidadatenciones.getSelectedItem();
        int cantidad = Integer.parseInt(numero_atenciones);
        
        for(int i=0;i<cantidad;i++){
           
                
                //INSERTA CODIGO DE CARRERA
                conexion cnbd=new conexion();
                cnbd.setEsSelect(false);
                cnbd.setComandoSQL("insert into alumno(cod_a,cod_c) values(null,'"+modelo_carrera.getCod_c()+"')");
       
                cnbd.conectar();
                cnbd.cerrarConexion();
                
                //---------------------------------------------
                //BUSCA CODIGO (GENERADO POR AUTO-INCREMENTO) DEL ULTIMO ALUMNO INGRESADO
                cnbd.setEsSelect(true);

                cnbd.setComandoSQL("select cod_a from alumno order by cod_a desc limit 1");
                cnbd.conectar();
                try {  
                while(cnbd.getRst().next())
                {
                    codigoalumno=cnbd.getRst().getInt("cod_a");     
                }
                } catch (SQLException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al cargar lista de carreras segun facultad", ex);
                } 
                cnbd.cerrarConexion();
                
                //--------------------------------------------
                //INSERTA LA ATENCION CONSIDERANDO CODIGO DE ALUMNO Y CODIGO DE PROFESIONAL
                cnbd.setEsSelect(false);
                cnbd.setComandoSQL("insert into atencion(cod_p,cod_a) values('"+modelo_profesional.getCod_p()+"','"+codigoalumno+"')");
                
                cnbd.conectar();
                cnbd.cerrarConexion();
                
                //-------------------------------------------
                
      }
        javax.swing.JOptionPane.showMessageDialog (null, "La información ha sido ingresada con éxito", "Ficha de Ingreso", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    
}
