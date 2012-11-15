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
import modelo.Carrera;
import vista.VentanaPrincipal;
import modelo.Persona;
import modelo.Facultad;
import vista.VentanaIngreso;

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
       this.modelo=modelo;
       this.vista.botoningresar.addActionListener(this);
    }
    
    public void agregarpersona(String prut, String pnombre, String pfono, int pedad) throws java.lang.ClassNotFoundException,
                                                                                                java.lang.InstantiationException,
                                                                                                java.lang.IllegalAccessException,
                                                                                                java.sql.SQLException
                                                                                               
    {
        Persona p=new Persona(prut,pnombre,pfono,pedad);
        
        p.grabar();
        
    }
    
    public void modificarpersona(String prut, String pnombre, String pfono, String pedad) throws java.lang.ClassNotFoundException,
                                                                                                java.lang.InstantiationException,
                                                                                                java.lang.IllegalAccessException,
                                                                                                java.sql.SQLException
                                                                                                
    {
        Persona p=new Persona(prut);
        p.actualizar(pnombre,pfono,pedad);
        p.grabar();
    }
    
    public void eliminarpersona(String prut, String pnombre, String pfono, String pedad) throws java.lang.ClassNotFoundException,
                                                                                                java.lang.InstantiationException,
                                                                                                java.lang.IllegalAccessException,
                                                                                                java.sql.SQLException
                                                                                               
    {
        Persona p;
        p=new Persona(prut);
            p.borrar();
        
    }

    public void iniciar_vista(){
        
        vista.botoningresar.setText("Ingresar");
        vista.setTitle(" SESAES");
      
    }
    
    //@Override
    @Override
    public void actionPerformed(ActionEvent e) {


        
        //DESDE AQUI VENTANA INGRESO
        Facultad modelofacultad=new Facultad();
        Carrera modelocarrera=new Carrera();
        VentanaIngreso ventana = new VentanaIngreso();
        ventana.setVisible(true);
        
        controladorFacultad contfacultad=new controladorFacultad(ventana,modelofacultad);


        contfacultad.iniciar_vista();
        
    }
       
}
