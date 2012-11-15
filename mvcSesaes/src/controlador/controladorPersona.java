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
import vista.VentanaPrincipal;
//import modelo.error;
import modelo.Persona;
import modelo.Facultad;
//import modelo.error;
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
    
    /*CONSTRUCTOR PARA FACULTAD public controladorPersona(VentanaIngreso vista2,Facultad modelofacultad){
       this.vista2=vista2;
       this.modelofacultad=modelofacultad;
       this.vista2.botonfacultad.addActionListener(this);
    }
    */
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
        //vista.botoningresar.action(new VentanaIngreso().setVisible(true));
      
    }
    
    //@Override
    @Override
    public void actionPerformed(ActionEvent e) {

       modelo.setNombre(vista.jtnombre.getText());
       modelo.setRut(vista.jtrut.getText());
       //modelo.setFono(vista.jtfono.getText()); /*(01)PONER COMO COMENTARIO*/
       //vista.jtnombre.setText(modelo.getFono());
       
       // vista.jtnombre.setText(modelo.getNombre());
    //  modelo.setEdad(Integer.valueOf(vista.jtedad.getText()));
        try {
            modelo.grabar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(controladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(controladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(controladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        } 
        vista.jtfono.setText(modelo.getFono()); /*(01)AGREGAR ESTA LINEA*/

        
        //DESDE AQUI VENTANA INGRESO
        Facultad modelofacultad=new Facultad();
        VentanaIngreso ventana = new VentanaIngreso();
        ventana.setVisible(true);
        
        controladorFacultad contfacultad=new controladorFacultad(ventana,modelofacultad);

        //se inicia la vista
        contfacultad.iniciar_vista();
        
    }
       
}
