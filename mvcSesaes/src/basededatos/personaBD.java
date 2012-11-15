/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger; 
import modelo.Persona;
import modelo.conexion;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */////
public class personaBD {
    
    private Persona p;

    public personaBD(Persona p)
    {
        this.p=p;
    }

  
    public void grabar() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
    {
           
}
    
    /**
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException
     */
    public Persona leer() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
                       
    {
        return null;
       }
    
    
    public void borrar() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
    {
    }
        
}
