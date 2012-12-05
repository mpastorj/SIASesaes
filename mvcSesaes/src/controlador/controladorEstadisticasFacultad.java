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
public class controladorEstadisticasFacultad implements ActionListener{
    private VentanaDiurna ventana;

    public controladorEstadisticasFacultad(VentanaDiurna ventana) {
        this.ventana = ventana;
        this.ventana.jRadioFacultad.addActionListener(this);
    }

    public controladorEstadisticasFacultad() {
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ventana.listafacultad.removeAllItems();
            ArrayList <String> nombres_f = new ArrayList();
            conexion cdb=new conexion();
           
            cdb.setEsSelect(true);
            cdb.setComandoSQL("select nombre_f  from facultad" );
            cdb.conectar();
            
            try {  
            while(cdb.getRst().next())
            {
               String nombre_f =cdb.getRst().getString("nombre_f");
                
               nombres_f.add(nombre_f);       
            }
            } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al cargar lista de carreras segun facultad", ex);
            } 
            cdb.cerrarConexion();
            
            for(String arreglodefacultades:nombres_f)
                ventana.listafacultad.addItem(arreglodefacultades);
    }
    
}
