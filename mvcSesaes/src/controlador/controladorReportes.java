/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Pedro
 */
public class controladorReportes {
    private File ruta_destino=null;
public controladorReportes(String parametro, String año,int mes, String report,int jornada, String profesional){

    int mes2 = mes +1;
    
try {
                 Class.forName("com.mysql.jdbc.Driver");
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(controladorEstadisticaDiurna.class.getName()).log(Level.SEVERE, null, ex);
             }
        Connection conexion = null;
             try {
                 conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvcsesaes", "root", "");
             } catch (SQLException ex) {
                 Logger.getLogger(controladorEstadisticaDiurna.class.getName()).log(Level.SEVERE, null, ex);
             }

        JasperReport reporte = null;
             try {
                 reporte = (JasperReport) JRLoader.loadObject(report);
             } catch (JRException ex) {
                 Logger.getLogger(controladorEstadisticaDiurna.class.getName()).log(Level.SEVERE, null, ex);
             }
        JasperPrint jasperPrint = null;
             try {
                 Map parametros = new HashMap();
                 parametros.put("especialidad",parametro);
                 parametros.put("año",año);
                 parametros.put("mes", mes2);
                 parametros.put("jornada",jornada);
                 parametros.put("profesional",profesional);
                 jasperPrint = JasperFillManager.fillReport(reporte, parametros , conexion);
             } catch (JRException ex) {
                 Logger.getLogger(controladorEstadisticaDiurna.class.getName()).log(Level.SEVERE, null, ex);
             }

       
        
       JRExporter exporter = new JRPdfExporter();
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PDF","pdf","PDF");
       JFileChooser fileChooser = new JFileChooser();       
       fileChooser.setFileFilter(filter);
       int result = fileChooser.showSaveDialog(null);
       if ( result == JFileChooser.APPROVE_OPTION ){   
           this.ruta_destino = fileChooser.getSelectedFile().getAbsoluteFile();
           javax.swing.JOptionPane.showMessageDialog (null, "PDF generado con éxito", "Ficha de Estadísticas", JOptionPane.INFORMATION_MESSAGE);
       }
       else
           if(result==JFileChooser.CANCEL_OPTION){
               javax.swing.JOptionPane.showMessageDialog (null, "PDF cancelado..", "Ficha de Estadísticas", JOptionPane.INFORMATION_MESSAGE);
           }
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(this.ruta_destino+"reportePDF.pdf"));
             try {
                 exporter.exportReport();
             } catch (JRException ex) {
                 Logger.getLogger(controladorEstadisticaDiurna.class.getName()).log(Level.SEVERE, null, ex);
             }


                     
}    
    
}
