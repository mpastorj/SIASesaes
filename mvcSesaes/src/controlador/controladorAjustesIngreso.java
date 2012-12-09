/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import basededatos.especialidadBD;
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
import modelo.Especialidad;
import modelo.conexion;
import vista.VentanaConfiguracion;

/**
 *
 * @author Milii2
 */
public class controladorAjustesIngreso implements ActionListener{
    
    private VentanaConfiguracion vista;
    private Especialidad modelo_especialidad;
    private especialidadBD especialidadbd;

    public controladorAjustesIngreso(VentanaConfiguracion vista) {
        this.vista = vista;
        this.vista.guardar.addActionListener(this);
        this.vista.añonacimiento.addActionListener(this);
        this.vista.mesnacimiento.addActionListener(this);
    }

    

   // public controladorAjustesIngreso() {
  //      this.vista.guardar.addActionListener(this);
  //  }
   
    
    public int asignames(){
        String mes_nac=(String)vista.mesnacimiento.getSelectedItem();
        int numero=0;
        if("Enero".equals(mes_nac))
        numero=01;
        if("Febrero".equals(mes_nac))
        numero=02;
        if("Marzo".equals(mes_nac))
        numero=03;
        if("Abril".equals(mes_nac))
        numero=04;
        if("Mayo".equals(mes_nac))
        numero=05;
        if("Junio".equals(mes_nac))
        numero=06;
        if("Julio".equals(mes_nac))
        numero=07;
        if("Agosto".equals(mes_nac))
        numero=8;
        if("Septiembre".equals(mes_nac))
        numero=9;
        if("Octubre".equals(mes_nac))
        numero=10;
        if("Noviembre".equals(mes_nac))
        numero=11;
        if("Diciembre".equals(mes_nac))
        numero=12;   
        
        return numero;     
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
    
        
    DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    String nombre=(String)vista.nombreprofesional.getText();
    String especialidad=(String)vista.especialidadprofesional.getSelectedItem();
    String dia=(String)vista.dianacimiento.getSelectedItem();
    String año=(String)vista.añonacimiento.getSelectedItem();
    int añodenacimiento=Integer.parseInt(año);
    int mes_nacimiento=asignames();
    String mesnuevo=String.valueOf(mes_nacimiento);
    String fecha_nacimiento=año+"-"+mesnuevo+"-"+dia;   
    int codigoespecialidad=0;
    int codigoprofesional=0;
    
    
    if(e.getSource()==vista.añonacimiento){
        vista.mesnacimiento.enable();
        //vista.dianacimiento.enable();
    }
        if(e.getSource()==vista.mesnacimiento){
        vista.dianacimiento.enable();
          // vista.dianacimiento.removeAllItems();
           
            //vista.dianacimiento.enable();
            if(mes_nacimiento==2){
            //vista.dianacimiento.enable();
    //if((añodenacimiento % 4!=0) && ((añodenacimiento % 100==0) || (añodenacimiento % 400!=0))){
      
    //}
     // else
      if((añodenacimiento % 4==0) && ((añodenacimiento % 100!=0) || (añodenacimiento % 400==0))){

          vista.dianacimiento.addItem(29);

      }
            }
            else
                if(mes_nacimiento==1 || mes_nacimiento==3 || mes_nacimiento==5 || mes_nacimiento==7 || mes_nacimiento==8 || mes_nacimiento==10 || mes_nacimiento==12){
                    vista.dianacimiento.addItem(29);
                    vista.dianacimiento.addItem(30);
                    vista.dianacimiento.addItem(31);
                }
                if(mes_nacimiento==4 || mes_nacimiento==6 || mes_nacimiento==9 || mes_nacimiento==11){
                    vista.dianacimiento.addItem(29);
                    vista.dianacimiento.addItem(30);
                }
                    
        }
        
    if(e.getSource()==vista.guardar){
        
        if(nombre.length()>2 && !"<Seleccione>".equals(especialidad) && !"-".equals(dia)){
            int confirmado = JOptionPane.showConfirmDialog(null,"<html>Se ingresará el profesional: <b>"+nombre+"</b>, fecha de nacimiento <b>"+fecha_nacimiento+"</b> con especialidad <b>"+especialidad); 
      if (JOptionPane.OK_OPTION==confirmado){
    
                 Date fecha=null;
    formatoDelTexto.setLenient(false);
        try {
            fecha = formatoDelTexto.parse(fecha_nacimiento);
        } catch (ParseException ex) {
            Logger.getLogger(controladorAjustesIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    conexion cnbd=new conexion();
    cnbd.setEsSelect(false);
    
    cnbd.setComandoSQL("insert into profesional(nombre_p,fecha_nac) values('"+nombre+"','"+df.format(fecha).toString() +"')");            
    cnbd.conectar();
    cnbd.cerrarConexion();
    
    //------------------------------------------------------------
    
        cnbd.setEsSelect(true);
        cnbd.setComandoSQL("select cod_e from especialidad where nombre_e='"+especialidad+"'");
        cnbd.conectar();
        
        try {
            while(cnbd.getRst().next()) {
                codigoespecialidad=cnbd.getRst().getInt("cod_e");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentanaConfiguracion.class.getName()).log(Level.SEVERE, "Error en la asignación de codigo de especialidad", ex);
        }
        cnbd.cerrarConexion();
    
        
        cnbd.setEsSelect(true);
        cnbd.setComandoSQL("select cod_p from profesional where nombre_p='"+nombre+"'");
        cnbd.conectar();
        //cnbd.setComandoSQL("SELECT cod_p FROM profesional DESC LIMIT 1 ");
         
        try {
            while(cnbd.getRst().next()) {
                codigoprofesional=cnbd.getRst().getInt("cod_p");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentanaConfiguracion.class.getName()).log(Level.SEVERE, "Error en la asignación de codigo de especialidad", ex);
        }
        cnbd.cerrarConexion();
        
  
        cnbd.setEsSelect(false);
    
        cnbd.setComandoSQL("insert into profeespe(cod_p,cod_e) values('"+codigoprofesional+"','"+codigoespecialidad+"')");            
        cnbd.conectar();
        cnbd.cerrarConexion();
        
        javax.swing.JOptionPane.showMessageDialog (null, "La información ha sido ingresada con éxito", "Ficha de Configuración", JOptionPane.INFORMATION_MESSAGE);
        }
      else 
          javax.swing.JOptionPane.showMessageDialog (null, "Ingreso Cancelado..", "Ficha de Configuración", JOptionPane.INFORMATION_MESSAGE);
        }
        else 
          
            javax.swing.JOptionPane.showMessageDialog (null, "Debe ingresar información válida", "Ficha de Configuración", JOptionPane.INFORMATION_MESSAGE);
        }
        
          
    
   // }
    
 
    }
    
}
