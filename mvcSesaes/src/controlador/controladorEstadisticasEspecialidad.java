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
public class controladorEstadisticasEspecialidad implements ActionListener{
    private VentanaDiurna ventana;

    public controladorEstadisticasEspecialidad(VentanaDiurna ventana) {
        this.ventana = ventana;
        this.ventana.jradioprofesional.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       ventana.listaprofesional.removeAllItems(); 
       ArrayList <String> nombres_p = new ArrayList();
            conexion cdb=new conexion();
           
            cdb.setEsSelect(true);
            cdb.setComandoSQL("select nombre_p from profesional order by nombre_p" );
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
                ventana.listaprofesional.addItem(arreglodeprofesionales);
    }
    
}
