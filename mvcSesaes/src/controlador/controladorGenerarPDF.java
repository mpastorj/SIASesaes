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
    private int jornada;

    public controladorGenerarPDF(VentanaTabla vista, VentanaDiurna ventana, int jornada) {
       this.vista = vista;
       this.ventana = ventana;
       this.jornada = jornada;
       this.vista.botonreporte.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    String especialidad = (String)ventana.listaespecialidad.getSelectedItem(); 
    String año = (String)ventana.listaaño.getSelectedItem();
    int mes = ventana.listames.getSelectedIndex();
    String carrera = (String)ventana.listacarrera.getSelectedItem();
    String facultad = (String)ventana.listafacultad.getSelectedItem();
        
      
    if(ventana.jRadioProfesional.isSelected())
    {
        switch(ventana.listaperiodo.getSelectedIndex())
        {
            case 1:
            {           
     String reporte = "reporte1.jasper";           
    controladorReportes r = new controladorReportes(especialidad,año,mes,reporte,jornada);
    break;
            }
            case 2:
            {
            if(ventana.listasemestre.getSelectedIndex()==0)
            {
             String reporte = "reporte2.jasper";           
              controladorReportes r = new controladorReportes(especialidad,año,mes,reporte,jornada);
                
            }
            else
            {
            String reporte = "reporte3.jasper";           
            controladorReportes r = new controladorReportes(especialidad,año,mes,reporte,jornada);
                
            }
            break;
            
            }  
            case 3:
            {
            String reporte = "reporte4.jasper";           
            controladorReportes r = new controladorReportes(especialidad,año,mes,reporte,jornada);
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
    controladorReportes r = new controladorReportes(carrera,año,mes,reporte,jornada);
    break;
            }
            case 2:
            {
            if(ventana.listasemestre.getSelectedIndex()==0)
            {
             String reporte = "reporte6.jasper";           
              controladorReportes r = new controladorReportes(carrera,año,mes,reporte,jornada);
                
            }
            else
            {
            String reporte = "reporte7.jasper";           
            controladorReportes r = new controladorReportes(carrera,año,mes,reporte,jornada);
                
            }
            break;
            
            }  
            case 3:
            {
            String reporte = "reporte8.jasper";           
            controladorReportes r = new controladorReportes(carrera,año,mes,reporte,jornada);
            break;
            
            }
        }        
    
    
    
    }
    
    else if(ventana.jRadioFacultad.isSelected())
    {
    switch(ventana.listaperiodo.getSelectedIndex())
        {
            case 1:
            {           
     String reporte = "reporte9.jasper";           
    controladorReportes r = new controladorReportes(facultad,año,mes,reporte,jornada);
    break;
            }
            case 2:
            {
            if(ventana.listasemestre.getSelectedIndex()==0)
            {
             String reporte = "reporte10.jasper";           
              controladorReportes r = new controladorReportes(facultad,año,mes,reporte,jornada);
                
            }
            else
            {
            String reporte = "reporte11.jasper";           
            controladorReportes r = new controladorReportes(facultad,año,mes,reporte,jornada);
                
            }
            break;
            
            }  
            case 3:
            {
            String reporte = "reporte12.jasper";           
            controladorReportes r = new controladorReportes(facultad,año,mes,reporte,jornada);
            break;
            
            }
        }        
    
    
    
    }
       
        
    }
    
}
