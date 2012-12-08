/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.conexion;
import vista.VentanaConfiguracion;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */
public class controladorAjustesEliminar implements ActionListener{

    private VentanaConfiguracion vista;

    public controladorAjustesEliminar(VentanaConfiguracion vista) {
        this.vista = vista;
        this.vista.jRadioEliminar.addActionListener(this);
    }

    public controladorAjustesEliminar() {
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        ArrayList <String> nombres_p = new ArrayList();
            conexion cdb=new conexion();
        
            cdb.setEsSelect(true);
            cdb.setComandoSQL("select nombre_p  from profesional order by nombre_p" );
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
            
            for(String arreglodeprofesionales:nombres_p)
                vista.eliminarregistro.addItem(arreglodeprofesionales);
           
    }
    
}
