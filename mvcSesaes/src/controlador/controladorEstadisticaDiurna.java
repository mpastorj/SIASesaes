/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.table.DefaultTableModel;
import modelo.conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.VentanaDiurna;
import vista.VentanaPrincipal;
import vista.VentanaTabla;

/**
 *
 * @author Milii2
 */
public class controladorEstadisticaDiurna implements ActionListener{

    private VentanaDiurna ventana;
    private AbstractButton opcionProfesional;

    public controladorEstadisticaDiurna(VentanaDiurna ventana) {
        this.ventana = ventana;
        this.ventana.botonmostrar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
     String profesional=(String)ventana.listaprofesional.getSelectedItem();  
     String especialidad = (String)ventana.listaespecialidad.getSelectedItem();
     String carrera      = (String)ventana.listacarrera.getSelectedItem();
     String facultad     = (String)ventana.listafacultad.getSelectedItem();
     String periodo      = (String)ventana.listaperiodo.getSelectedItem(); 
     int mes          = ventana.listames.getSelectedIndex() + 1;
     int semestre     = ventana.listasemestre.getSelectedIndex();
     String año       =(String)ventana.listaaño.getSelectedItem();
     
     if((ventana.jRadioProfesional.isSelected()==true || ventana.jRadioFacultad.isSelected()==true || ventana.jRadioCarrera.isSelected()==true || ventana.jradioprofesional.isSelected()==true) && ventana.listaperiodo.getSelectedIndex()!=0){
       VentanaTabla t = new VentanaTabla();
       DefaultTableModel modelo = new DefaultTableModel(); 
       t.tabla.setModel(modelo);
       
       
       if(ventana.jRadioProfesional.isSelected()==true){
           t.titulo.setText("Estadística especialidad: "+especialidad );
           switch(ventana.listaperiodo.getSelectedIndex())
           {
               case 1:
            t.titulo2.setText("Período: "+(String)ventana.listames.getSelectedItem()+" de "+año); 
            break;
               case 2:
               {       
            if(semestre == 0) {
                       t.titulo2.setText("Período: Primer semestre del año "+año);
                   } 
            else{
                       t.titulo2.setText("Período: Segundo semestre del año "+año);
                   }
            break;       
                 
           }
               case 3:
                  t.titulo2.setText("Período: Año "+año); 
          }
       conexion cn = new conexion();
       
       String consulta = "";      
          
      switch(ventana.listaperiodo.getSelectedIndex())
      {
          case 1:
          consulta = "AND MONTH(fecha_a) = "+mes+"";    
           break;
          case 2:
              if(semestre == 0)
              consulta = "AND MONTH(fecha_a) BETWEEN 1 AND 6  ";
              else if(semestre == 1)
                  consulta = "AND MONTH(fecha_a) BETWEEN 7 AND 12  ";
              break;
       }       
       cn.setComandoSQL("select CASE WHEN MONTH(fecha_a) = 1 THEN 'Enero'"
               + "  WHEN MONTH(fecha_a) = 2 THEN 'Febrero' "
               + " WHEN MONTH(fecha_a) = 3 THEN 'Marzo'"
               + " WHEN MONTH(fecha_a) = 4 THEN 'Abril'"
               + " WHEN MONTH(fecha_a) = 5 THEN 'Mayo'"
               + " WHEN MONTH(fecha_a) = 6 THEN 'Junio'"
               + " WHEN MONTH(fecha_a) = 7 THEN 'Julio'"
               + " WHEN MONTH(fecha_a) = 8 THEN 'Agosto'"
               + " WHEN MONTH(fecha_a) = 9 THEN 'Septiembre'"
               + " WHEN MONTH(fecha_a) = 10 THEN 'Octubre'"
               + " WHEN MONTH(fecha_a) = 11 THEN 'Noviembre'"
               + "  WHEN MONTH(fecha_a) = 12 THEN 'Diciembre'"
               + " ELSE 'esto no es un mes' END as Mes, SUM(cantidad) as 'N° de atenciones'"
               + " from atencion where cod_profesional \n" +
               "in (select cod_p from profeespe where cod_e = (select cod_e from especialidad where nombre_e = '"+especialidad+"'))"
               + "and cod_c in (select cod_c from carrera where tipo = '1') "+consulta+" and year(fecha_a) = '"+año+"' group by Mes order by month(fecha_a)");
       cn.setEsSelect(true);
       cn.conectar();
       
       
            
       
       ResultSet rs = cn.getRst();
            try {
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumnas = rsMd.getColumnCount();
                for (int i = 1; i <= cantidadColumnas; i++) {
  modelo.addColumn(rsMd.getColumnLabel(i));
 }
 //Creando las filas para el JTable
 while (rs.next()) {
  Object[] fila = new Object[cantidadColumnas];
  for (int i = 0; i < cantidadColumnas; i++) {
    fila[i]=rs.getObject(i+1);
  }
  modelo.addRow(fila);
  
  
 }
 rs.close();
 cn.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaTabla.class.getName()).log(Level.SEVERE, null, ex);
            }
  ArrayList <String> nombres_p = new ArrayList();
  cn.setEsSelect(true);
  cn.setComandoSQL("select nombre_p from profesional where cod_p in (select cod_p from profeespe where cod_e = (select cod_e from especialidad where nombre_e='"+especialidad+"'))");
  cn.conectar();
  try {  
            while(cn.getRst().next())
            {
               String nombre_p =cn.getRst().getString("nombre_p");
                
               nombres_p.add(nombre_p); 
               t.profesionales.append("\n");
               t.profesionales.append(" - ");
               t.profesionales.append(nombre_p);
               
            }
            } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al cargar nombre de profesionales", ex);
            } 
            cn.cerrarConexion();        
     
     }       
   
   if(ventana.jRadioCarrera.isSelected()==true){
       t.profesionales.setVisible(false);
       t.jScrollPane2.setVisible(false);
       t.titulo.setText("Estadística Carrera: "+carrera );
           switch(ventana.listaperiodo.getSelectedIndex())
           {
               case 1:
            t.titulo2.setText("Período: "+(String)ventana.listames.getSelectedItem()+" de "+año); 
            break;
               case 2:
               {       
            if(semestre == 0) {
                       t.titulo2.setText("Período: Primer semestre del año "+año);
                   } 
            else {
                       t.titulo2.setText("Período: Segundo semestre del año "+año);
                   }
            break;       
                 
           }
               case 3:
                  t.titulo2.setText("Período: Año "+año); 
          }
           
       conexion cn = new conexion();
       
       String consulta = "";      
          
      switch(ventana.listaperiodo.getSelectedIndex())
      {
          case 1:
          consulta = "AND MONTH(fecha_a) = "+mes+"";    
           break;
          case 2:
              if(semestre == 0)
              consulta = "AND MONTH(fecha_a) BETWEEN 1 AND 6  ";
              else if(semestre == 1)
                  consulta = "AND MONTH(fecha_a) BETWEEN 7 AND 12  ";
              break;
       }  
        
       cn.setComandoSQL("select  CASE WHEN MONTH(fecha_a) = 1 THEN 'Enero'"
              + " WHEN MONTH(fecha_a) = 2 THEN 'Febrero' "
              + "WHEN MONTH(fecha_a) = 3 THEN 'Marzo' "
              + "WHEN MONTH(fecha_a) = 4 THEN 'Abril' "
              + "WHEN MONTH(fecha_a) = 5 THEN 'Mayo' "
              + "WHEN MONTH(fecha_a) = 6 THEN 'Junio' "
              + "WHEN MONTH(fecha_a) = 7 THEN 'Julio' "
              + "WHEN MONTH(fecha_a) = 8 THEN 'Agosto' "
              + "WHEN MONTH(fecha_a) = 9 THEN 'Septiembre' "
              + "WHEN MONTH(fecha_a) = 10 THEN 'Octubre' "
              + "WHEN MONTH(fecha_a) = 11 THEN 'Noviembre'"
              + " WHEN MONTH(fecha_a) = 12 THEN 'Diciembre' "
              + "ELSE 'esto no es un mes' END as Mes, SUM(cantidad) as 'Num de Atenciones' "
              + "from atencion "
              + "where cod_c in (select cod_c from carrera where nombre_c='"+carrera+"' and tipo='1') " +consulta+ " and year(fecha_a) = '"+año+"' group by Mes order by month(fecha_a)" );
    
              cn.setEsSelect(true);
       cn.conectar();
       
       ResultSet rs = cn.getRst();
            try {
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumnas = rsMd.getColumnCount();
                for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
                }

                while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                fila[i]=rs.getObject(i+1);
                }
                modelo.addRow(fila);
                }
                rs.close();
        cn.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaTabla.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
                
              
   t.setVisible(true);                 
            
          
     if(ventana.jRadioFacultad.isSelected()==true){
         t.profesionales.setVisible(false);
         t.jScrollPane2.setVisible(false);
         t.titulo.setText("Estadística Facultad: "+facultad );
           switch(ventana.listaperiodo.getSelectedIndex())
           {
               case 1:
            t.titulo2.setText("Período: "+(String)ventana.listames.getSelectedItem()+" de "+año); 
            break;
               case 2:
               {       
            if(semestre == 0) {
                       t.titulo2.setText("Período: Primer semestre del año "+año);
                   } 
            else {
                       t.titulo2.setText("Período: Segundo semestre del año "+año);
                   }
            break;       
                 
           }
               case 3:
                  t.titulo2.setText("Período: Año "+año); 
          }
          conexion cn=new conexion();
          String consulta = "";      
          
      switch(ventana.listaperiodo.getSelectedIndex())
      {
          case 1:
          consulta = "AND MONTH(fecha_a) = "+mes+"";    
           break;
          case 2:
              if(semestre == 0)
              consulta = "AND MONTH(fecha_a) BETWEEN 1 AND 6  ";
              else if(semestre == 1)
                  consulta = "AND MONTH(fecha_a) BETWEEN 7 AND 12  ";
              break;
       }
            cn.setEsSelect(true);              
            cn.setComandoSQL("select  CASE WHEN MONTH(fecha_a) = 1 THEN 'Enero'"
              + " WHEN MONTH(fecha_a) = 2 THEN 'Febrero' "
              + "WHEN MONTH(fecha_a) = 3 THEN 'Marzo' "
              + "WHEN MONTH(fecha_a) = 4 THEN 'Abril' "
              + "WHEN MONTH(fecha_a) = 5 THEN 'Mayo' "
              + "WHEN MONTH(fecha_a) = 6 THEN 'Junio' "
              + "WHEN MONTH(fecha_a) = 7 THEN 'Julio' "
              + "WHEN MONTH(fecha_a) = 8 THEN 'Agosto' "
              + "WHEN MONTH(fecha_a) = 9 THEN 'Septiembre' "
              + "WHEN MONTH(fecha_a) = 10 THEN 'Octubre' "
              + "WHEN MONTH(fecha_a) = 11 THEN 'Noviembre'"
              + " WHEN MONTH(fecha_a) = 12 THEN 'Diciembre' "
              + "ELSE 'esto no es un mes' END as Mes, SUM(cantidad) as 'Num de Atenciones' "
              + "from atencion "
              + "where cod_c in (select cod_c from carrera where tipo='1' and cod_f in(select cod_f from facultad where nombre_f='"+facultad+"')) " +consulta+ " and year(fecha_a) = '"+año+"' group by Mes order by month(fecha_a)" );
            
            
       cn.setEsSelect(true);
       cn.conectar();
       
       ResultSet rs = cn.getRst();
            try {
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumnas = rsMd.getColumnCount();
                for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
                }

                while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                fila[i]=rs.getObject(i+1);
                }
                modelo.addRow(fila);
                }
                rs.close();
        cn.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaTabla.class.getName()).log(Level.SEVERE, null, ex);
            }
         
     }
     
     if(ventana.jradioprofesional.isSelected()==true){
        t.profesionales.setVisible(false);
        t.jScrollPane2.setVisible(false);
        t.titulo.setText("Estadística Carrera: "+profesional );
           switch(ventana.listaperiodo.getSelectedIndex())
           {
               case 1:
            t.titulo2.setText("Período: "+(String)ventana.listames.getSelectedItem()+" de "+año); 
            break;
               case 2:
               {       
            if(semestre == 0) {
                       t.titulo2.setText("Período: Primer semestre del año "+año);
                   } 
            else {
                       t.titulo2.setText("Período: Segundo semestre del año "+año);
                   }
            break;       
                 
           }
               case 3:
                  t.titulo2.setText("Período: Año "+año); 
          }
           
       conexion cn = new conexion();
       
       String consulta = "";      
          
      switch(ventana.listaperiodo.getSelectedIndex())
      {
          case 1:
          consulta = "AND MONTH(fecha_a) = "+mes+"";    
           break;
          case 2:
              if(semestre == 0)
              consulta = "AND MONTH(fecha_a) BETWEEN 1 AND 6  ";
              else if(semestre == 1)
                  consulta = "AND MONTH(fecha_a) BETWEEN 7 AND 12  ";
              break;
      }  
        
       cn.setComandoSQL("select  CASE WHEN MONTH(fecha_a) = 1 THEN 'Enero'"
              + "WHEN MONTH(fecha_a) = 2 THEN 'Febrero' "
              + "WHEN MONTH(fecha_a) = 3 THEN 'Marzo' "
              + "WHEN MONTH(fecha_a) = 4 THEN 'Abril' "
              + "WHEN MONTH(fecha_a) = 5 THEN 'Mayo' "
              + "WHEN MONTH(fecha_a) = 6 THEN 'Junio' "
              + "WHEN MONTH(fecha_a) = 7 THEN 'Julio' "
              + "WHEN MONTH(fecha_a) = 8 THEN 'Agosto' "
              + "WHEN MONTH(fecha_a) = 9 THEN 'Septiembre' "
              + "WHEN MONTH(fecha_a) = 10 THEN 'Octubre' "
              + "WHEN MONTH(fecha_a) = 11 THEN 'Noviembre'"
              + "WHEN MONTH(fecha_a) = 12 THEN 'Diciembre' "
              + "ELSE 'esto no es un mes' END as Mes, SUM(cantidad) as 'Num de Atenciones' "
              + "from atencion "
              + "where cod_c in (select cod_c from carrera where tipo='1' and cod_profesional in (select cod_p from profesional where nombre_p='"+profesional+"')) " +consulta+ " and year(fecha_a) = '"+año+"' group by Mes order by month(fecha_a)" );
    
       cn.setEsSelect(true);
       cn.conectar();
       
       ResultSet rs = cn.getRst();
            try {
                ResultSetMetaData rsMd = rs.getMetaData();
                int cantidadColumnas = rsMd.getColumnCount();
                for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
                }

                while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                fila[i]=rs.getObject(i+1);
                }
                modelo.addRow(fila);
                }
                rs.close();
        cn.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(VentanaTabla.class.getName()).log(Level.SEVERE, null, ex);
            } 
     }
     
     controladorCopiar contcopiar=new controladorCopiar(t);
     controladorGenerarPDF pdf = new controladorGenerarPDF(t,ventana,1);
     
     
     }
    }
           
    
}
