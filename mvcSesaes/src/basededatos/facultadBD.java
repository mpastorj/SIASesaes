/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;
import java.sql.SQLException;
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
public class facultadBD {
    
    private Facultad f;
    private Carrera c;

    public facultadBD(Facultad f) {
        this.f = f;
    }
    
    public facultadBD(Carrera c){
        this.c=c;
    }
    
    //METODO PARA INSERTAR FACULTADES **NO USADO**
    public void grabar() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
    {
        conexion cdb=new conexion();
        cdb.setEsSelect(false);
        cdb.setComandoSQL("insert into facultad(nombre_f,cod_f) values('"+f.getNombre_f()+"','"+f.getCod_f()+"')"); 
        cdb.conectar();
        cdb.cerrarConexion();
    }
    
        
       // METODO PARA OBTENER CODIGO DE FACULTAD DESDE JCOMBOBOX **USADO EN VENTANAINGRESO**
        public void leer() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
        {
            int codigo_f = 0;
            conexion cdb=new conexion();
        
            cdb.setEsSelect(true);
            cdb.setComandoSQL("select cod_f  from facultad where nombre_f ='"+f.getNombre_f()+"'" );
            cdb.conectar();
            
            try {
            while(cdb.getRst().next()) {
                    codigo_f =cdb.getRst().getInt("cod_f");
                }
            } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al asignar codigo de facultad", ex);
            }
            cdb.cerrarConexion();
            f.setCod_f(codigo_f);
        }
    
    
}
