/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import controlador.controladorCarrera;
import controlador.controladorFacultad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Carrera;
import modelo.Facultad;
import modelo.conexion;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */
public class carreraBD {
    
    private Carrera c;
    private Facultad f;
    ArrayList <String> nombres_c=new ArrayList<String>();
    String nombre_c;

    public carreraBD(Carrera c) {
        this.c = c;
    }
    
           public void leer() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
        {
  
            conexion cdb=new conexion();
        
            cdb.setEsSelect(true);
            cdb.setComandoSQL("select nombre_c  from carrera where cod_f='"+c.getCod_f()+"'" );
            cdb.conectar();
            
            try {  
            while(cdb.getRst().next())
            {
               nombre_c = cdb.getRst().getString("nombre_c");
                
               nombres_c.add(nombre_c);       
            }
            } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al cargar lista de carreras segun facultad", ex);
            } 
         cdb.cerrarConexion();
         c.setNombres_c(nombres_c);    
         
         
       
       
        }
           
           public void buscar() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
           {
            int codigocarrera=0;
            conexion cdb=new conexion();
        
            cdb.setEsSelect(true);
            cdb.setComandoSQL("select cod_c  from carrera where nombre_c='"+c.getNombre_c()+"'" );
            cdb.conectar();
            
            try {  
            while(cdb.getRst().next())
            {
                codigocarrera=cdb.getRst().getInt("cod_c");       
            }
            } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al cargar lista de carreras segun facultad", ex);
            } 
            
         cdb.cerrarConexion();
         c.setCod_c(codigocarrera);
         
         //javax.swing.JOptionPane.showMessageDialog(null, "Carrera Reconocida", c.getNombre_c(), JOptionPane.INFORMATION_MESSAGE); 
               
           }
}
