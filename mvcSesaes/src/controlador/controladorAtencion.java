/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import basededatos.especialidadBD;
import basededatos.facultadBD;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.Atencion;
import modelo.Carrera;
import modelo.Especialidad;
import modelo.Facultad;
import modelo.Profesional;
import modelo.conexion;
import vista.VentanaIngreso;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */
public class controladorAtencion implements ActionListener{

    private VentanaIngreso vista;
    private Especialidad modelo_especialidad;
    private especialidadBD especialidadBD;
    private Facultad modelo_facultad;
    private facultadBD facultadBD;
    private Carrera modelo_carrera;
    private Profesional modelo_profesional;
    private Atencion modelo_atencion;

    public controladorAtencion(VentanaIngreso vista, Carrera modelo_carrera, Profesional modelo_profesional, Atencion modelo_atencion) {
        this.vista = vista;
        this.modelo_carrera = modelo_carrera;
        this.modelo_profesional = modelo_profesional;
        this.modelo_atencion = modelo_atencion;
        this.vista.botondeingreso.addActionListener(this);
    }


    public controladorAtencion(Carrera modelo_carrera) {
        this.modelo_carrera = modelo_carrera;
    }
    
    
    public controladorAtencion(){
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        
        
        //Cantidad de atenciones que se desee ingresar
        int codigoalumno=0;
        String numero_atenciones=(String) vista.cantidadatenciones.getSelectedItem();
        int cantidad = Integer.parseInt(numero_atenciones);
        
        //FORMATO DE LA FECHA A INGRESAR
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatodefecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha=null;
        //SE OBTIENE FECHA SELECCIONADA EN JCALENDAR
        String año=Integer.toString(vista.calendario.getCalendar().get(java.util.Calendar.YEAR));
        String mes=Integer.toString(vista.calendario.getCalendar().get(java.util.Calendar.MONTH)+1);
        String dia=Integer.toString(vista.calendario.getCalendar().get(java.util.Calendar.DAY_OF_MONTH));
       
        String fecha_atencion=año+"-"+mes+"-"+dia;
        try {
            fecha = formatodefecha.parse(fecha_atencion);
        } catch (ParseException ex) {
            Logger.getLogger(controladorAtencion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //---------------------------------------------
        
        //Inserta en la tabla ATENCIÓN considerando codigo de profesional, codigo de carrera, fecha y número de atenciones
                
                conexion cnbd=new conexion();
                cnbd.setEsSelect(false);
                      
                cnbd.setComandoSQL("insert into atencion(cod_profesional,cod_c,fecha_a,cantidad) values('"+modelo_profesional.getCod_p()+"','"+modelo_carrera.getCod_c()+"','"+df.format(fecha).toString() +"','"+cantidad+"')");
                
                cnbd.conectar();
                cnbd.cerrarConexion();
        //---------------------------------------------
                
        vista.barraprogreso.setValue(100);
        javax.swing.JOptionPane.showMessageDialog (null, "La información ha sido ingresada con éxito", "Ficha de Ingreso", JOptionPane.INFORMATION_MESSAGE);
        vista.barraprogreso.setValue(0);
     
    
    }
    
    
}
