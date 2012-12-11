/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaDiurna;
import vista.VentanaTabla;

/**
 *
 * @author Pedro
 */
public class controladorGenerarPDF implements ActionListener{
    
    
    private VentanaTabla vista;
    private VentanaDiurna ventana;

    public controladorGenerarPDF(VentanaTabla vista, VentanaDiurna ventana) {
       this.vista = vista;
       this.ventana = ventana;
       this.vista.botonreporte.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    String especialidad = (String)ventana.listaespecialidad.getSelectedItem(); 
    String año = (String)ventana.listaaño.getSelectedItem();
    int mes = ventana.listames.getSelectedIndex();
    String carrera = (String)ventana.listacarrera.getSelectedItem();
        
      
    if(ventana.jRadioProfesional.isSelected())
    {
        switch(ventana.listaperiodo.getSelectedIndex())
        {
            case 1:
            {           
     String reporte = "reporte1.jasper";           
    controladorReportes r = new controladorReportes(especialidad,año,mes,reporte);
    break;
            }
            case 2:
            {
            if(ventana.listasemestre.getSelectedIndex()==0)
            {
             String reporte = "reporte2.jasper";           
              controladorReportes r = new controladorReportes(especialidad,año,mes,reporte);
                
            }
            else
            {
            String reporte = "reporte3.jasper";           
            controladorReportes r = new controladorReportes(especialidad,año,mes,reporte);
                
            }
            break;
            
            }  
            case 3:
            {
            String reporte = "reporte4.jasper";           
            controladorReportes r = new controladorReportes(especialidad,año,mes,reporte);
            break;
            
            }
        }        
    }  
    
    else if(ventana.jRadioCarrera.isSelected())
    {
    switch(ventana.listaperiodo.getSelectedIndex())
        {
            case 1:
            {           
     String reporte = "reporte5.jasper";           
    controladorReportes r = new controladorReportes(carrera,año,mes,reporte);
    break;
            }
            case 2:
            {
            if(ventana.listasemestre.getSelectedIndex()==0)
            {
             String reporte = "reporte2.jasper";           
              controladorReportes r = new controladorReportes(especialidad,año,mes,reporte);
                
            }
            else
            {
            String reporte = "reporte3.jasper";           
            controladorReportes r = new controladorReportes(especialidad,año,mes,reporte);
                
            }
            break;
            
            }  
            case 3:
            {
            String reporte = "reporte4.jasper";           
            controladorReportes r = new controladorReportes(especialidad,año,mes,reporte);
            break;
            
            }
        }        
    
    
    
    }
        
        
    }
    
}
