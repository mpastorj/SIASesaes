/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Atencion;
import modelo.Carrera;
import modelo.Especialidad;
import modelo.Facultad;
import modelo.Profesional;
import modelo.conexion;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */
public class atencionBD {
    private Carrera c;
    private Profesional p;
    private Especialidad e;
    private Facultad f;
    private Atencion a;
    private int cod_c;

    public atencionBD(Atencion a) {
        this.a = a;
    }
   

    public atencionBD(Carrera c, Profesional p) {
        this.c = c;
        this.p = p;
    }

    public atencionBD(Profesional p) {
        this.p = p;
    }
    public atencionBD(){}

    public atencionBD(Carrera c) {
        this.c = c;
    }
    
    //CONSULTA ANTIGUA *** SE DEBE MODIFICAR ***
    public void insertaalumno() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
    {
        
            conexion cnbd=new conexion();
            cnbd.setEsSelect(false);
            cnbd.setComandoSQL("insert into alumno(cod_a,cod_c) values(null,'"+c.getCod_c()+"')");
            cnbd.conectar();
            cnbd.cerrarConexion();
          
    }
    

    
}
