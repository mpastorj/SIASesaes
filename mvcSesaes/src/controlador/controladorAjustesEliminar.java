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
import javax.swing.JOptionPane;
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
        this.vista.eliminar.addActionListener(this);
    }

    public controladorAjustesEliminar() {
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.jRadioEliminar){
            if(vista.jRadioEliminar.isSelected()==true){
        vista.eliminarregistro.enable();
        //vista.eliminar.enable();
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
        
        
        
        if(e.getSource()==vista.eliminar){
          conexion cn=new conexion();
        cn.setEsSelect(false);
        String medico=(String)vista.eliminarregistro.getSelectedItem();
        if(vista.jRadioEliminar.isSelected()==true && vista.eliminarregistro.isEnabled()){
        JOptionPane.showMessageDialog(null,"Se eliminaran TODOS los registros asociados al Profesional '"+medico+"'","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
        int confirmado = JOptionPane.showConfirmDialog(null,"¿Realmente Desea Continuar con la Operación?","Confirmación",JOptionPane.YES_NO_OPTION);
        if (JOptionPane.OK_OPTION==confirmado){
        cn.setComandoSQL("delete from profesional where nombre_p='"+medico+"'");
        cn.conectar();
        cn.cerrarConexion();
        javax.swing.JOptionPane.showMessageDialog (null, "<html>Profesional <b>"+medico+ "</b> eliminado con éxito", "Ficha de Configuración", JOptionPane.INFORMATION_MESSAGE);
        //System.runFinalization();
        vista.eliminarregistro.removeAllItems();
        vista.eliminarregistro.disable();
        
       
           
        }
        
        }
        else {
                javax.swing.JOptionPane.showMessageDialog (null, "Debe seleccionar un Profesional", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
           
        
    }
    }
    
}
