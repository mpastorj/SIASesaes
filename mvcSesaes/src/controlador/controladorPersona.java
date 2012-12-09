/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Atencion;
import modelo.Carrera;
import modelo.Especialidad;
import vista.VentanaPrincipal;
import modelo.Persona;
import modelo.Facultad;
import modelo.Profesional;
import vista.VentanaConfiguracion;
import vista.VentanaIngreso;
import vista.VentanaTabla;

/**
 *
 * @author Milii2
 */
public class controladorPersona implements ActionListener{
    private VentanaPrincipal vista;
    private Persona modelo;
    private VentanaIngreso vista2;
    
    
    public controladorPersona(VentanaPrincipal vista,Persona modelo){
       this.vista=vista;
       this.vista.setVisible(true);
       this.modelo=modelo;
       this.vista.botoningresar.addActionListener(this);
    }

    public controladorPersona(VentanaPrincipal vista) {
        this.vista = vista;
        this.vista.botoningresar.addActionListener(this);
    }
    
   

    public void iniciar_vista(){
        
        vista.setTitle(" SESAES");
      
    }
    
    //@Override
    @Override
    public void actionPerformed(ActionEvent e) {


        
        //DESDE AQUI VENTANA INGRESO
        Facultad modelofacultad=new Facultad();
        Especialidad modeloespecialidad=new Especialidad();
        Carrera modelocarrera=new Carrera();
        Profesional modeloprofesional=new Profesional();
        Atencion modeloatencion=new Atencion();
  
        VentanaIngreso ventana = new VentanaIngreso();
       
        ventana.setVisible(true);
        controladorFacultad contfacultad=new controladorFacultad(ventana,modelofacultad);
        controladorEspecialidad contespecialidad=new controladorEspecialidad(ventana,modeloespecialidad);
        
        controladorCarrera contcarrera=new controladorCarrera(ventana,modelocarrera);
        controladorProfesional contprofesional=new controladorProfesional(ventana,modeloprofesional);
        controladorAtencion contatencion=new controladorAtencion(ventana, modelocarrera, modeloprofesional, modeloatencion);
        
        contfacultad.iniciar_vista();
        
        
    }
       
}
