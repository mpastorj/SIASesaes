/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Especialidad;
import modelo.conexion;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */
public class especialidadBD {
    
    private Especialidad e;

    public especialidadBD(Especialidad e) {
        this.e = e;
    }
            //METODO QUE OBTIENE CODIGO DE ESPECIALIDAD DESDE JCOMBOBOX **NO USADO**
            public void leer() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
        {
            int codigo_e = 0;
            conexion cdb=new conexion();
        
            cdb.setEsSelect(true);
            cdb.setComandoSQL("select cod_e  from especialidad where nombre_e ='"+e.getNombre_e()+"'" );
            cdb.conectar();
            
            try {
            while(cdb.getRst().next()) {
                    codigo_e =cdb.getRst().getInt("cod_e");
                }
            } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al asignar codigo de facultad", ex);
            }
            cdb.cerrarConexion();
            e.setCod_e(codigo_e);
        }
}
