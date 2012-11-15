/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    //ArrayList <String> nombres_c;
    
    //String nombres_c[] = new String[15];
    ArrayList <String> nombres_c=new ArrayList<String>();
    int i=0;
    int contador=0;
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
            //cdb.setComandoSQL("select nombre_c  from carrera where cod_f='"+f.getCod_f()+"'" );
            //cdb.setComandoSQL("select nombre_c  from carrera where cod_f=(select cod_f from facultad where nombre_f='Ingeniería') ");
            cdb.setComandoSQL("select nombre_c  from carrera where cod_f='"+c.getCod_f()+"'" );
            cdb.conectar();
            
            try {  
            while(cdb.getRst().next())
            {
               nombre_c =cdb.getRst().getString("nombre_c");
                
                   nombres_c.add(nombre_c);
                   //nombres_c[i]=nombre_c;          
               
           //carrera.addItem(cdb.getRst().getObject("nombre"));       
           }
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al cargar lista de carreras segun facultad", ex);
        } 
         cdb.cerrarConexion();
         //c.setNombres_c(nombres_c);
         c.setNombres_c(nombres_c);
          //  f.setCod_f(codigo_f);
        }
}
