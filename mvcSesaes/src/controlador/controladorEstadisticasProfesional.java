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
import vista.VentanaDiurna;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */
public class controladorEstadisticasProfesional implements ActionListener{
    private VentanaDiurna ventana;

    public controladorEstadisticasProfesional(VentanaDiurna ventana) {
        this.ventana = ventana;
        this.ventana.jRadioProfesional.addActionListener(this);
    }
  
            
    
    @Override
    public void actionPerformed(ActionEvent e) {
            ventana.listaespecialidad.removeAllItems();
            ArrayList <String> nombres_e = new ArrayList();
            conexion cdb=new conexion();
           
            cdb.setEsSelect(true);
            cdb.setComandoSQL("select nombre_e  from especialidad order by nombre_e" );
            cdb.conectar();
            
            try {  
            while(cdb.getRst().next())
            {
               String nombre_e =cdb.getRst().getString("nombre_e");
                
               nombres_e.add(nombre_e);       
            }
            } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al cargar lista de carreras segun facultad", ex);
            } 
            cdb.cerrarConexion();
            
            for(String arreglodeprofesionales:nombres_e)
            ventana.listaespecialidad.addItem(arreglodeprofesionales);
    }
    
}
