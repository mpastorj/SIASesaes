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
public class controladorEstadisticasCarreraVespertina implements ActionListener{
    private VentanaDiurna ventana;

    public controladorEstadisticasCarreraVespertina(VentanaDiurna ventana) {
        this.ventana = ventana;
        this.ventana.jRadioCarrera.addActionListener(this);
    }

    public controladorEstadisticasCarreraVespertina() {
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
           ventana.listacarrera.removeAllItems();
           ArrayList <String> nombres_c = new ArrayList();
            conexion cdb=new conexion();
           
            cdb.setEsSelect(true);
            cdb.setComandoSQL("select nombre_c from carrera where tipo='2' order by nombre_c" );
            cdb.conectar();
            
            try {  
            while(cdb.getRst().next())
            {
               String nombre_c =cdb.getRst().getString("nombre_c");
                
               nombres_c.add(nombre_c);       
            }
            } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al cargar lista de carreras segun facultad", ex);
            } 
            cdb.cerrarConexion();
            
            for(String arreglodecarreras:nombres_c)
                ventana.listacarrera.addItem(arreglodecarreras);
    }
    
    
    
}
