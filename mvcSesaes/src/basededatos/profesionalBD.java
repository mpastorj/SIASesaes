/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Especialidad;
import modelo.Profesional;
import modelo.conexion;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */
public class profesionalBD {
    
    private Profesional p;
    private Especialidad e;
    ArrayList <String> nombres_p=new ArrayList<String>();
    int i=0;
    int contador=0;
    String nombre_p;
    
    public profesionalBD(Profesional p) {
        this.p = p;
    }
    
    public void leer() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
        {
  
            conexion cdb=new conexion();
        
            cdb.setEsSelect(true);
            cdb.setComandoSQL("select nombre_p  from profesional where cod_e='"+e.getCod_e()+"'" );
            cdb.conectar();
            
            try {  
            while(cdb.getRst().next())
            {
               nombre_p = cdb.getRst().getString("nombre_p");
                
                   nombres_p.add(nombre_p);       
           }
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al cargar lista de carreras segun facultad", ex);
        } 
         cdb.cerrarConexion();
         p.setNombres_p(nombres_p);    
       
        }
    
    public void buscar() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
           {
            int codigoprofesional=0;
            conexion cdb=new conexion();
        
            cdb.setEsSelect(true);
            cdb.setComandoSQL("select cod_p  from profesional where nombre_p='"+p.getNombre_p()+"'" );
            cdb.conectar();
            
            try {  
            while(cdb.getRst().next())
            {
               //nombre_c = cdb.getRst().getString("nombre_c");
                codigoprofesional=cdb.getRst().getInt("cod_p");
               //nombres_c.add(nombre_c);       
            }
            } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al cargar lista de carreras segun facultad", ex);
            } 
         cdb.cerrarConexion();
         p.setCod_p(codigoprofesional);
         //javax.swing.JOptionPane.showMessageDialog(null, "LALA", c.getNombre_c(), JOptionPane.INFORMATION_MESSAGE);
         //javax.swing.JOptionPane.showMessageDialog (null, "La información ha sido ingresada con éxito", "Ficha de Ingreso", JOptionPane.INFORMATION_MESSAGE); 
               
           }
    
}
