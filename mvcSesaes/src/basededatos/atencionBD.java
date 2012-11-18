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
    
    public void buscacodigoalumno() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
    {
        int codigoalumno=0;
        conexion cnbd=new conexion();
        cnbd.setEsSelect(true);

            cnbd.setComandoSQL("select cod_a from alumno order by cod_a desc limit 1");
            cnbd.conectar();
            try {  
            while(cnbd.getRst().next())
            {
                codigoalumno=cnbd.getRst().getInt("cod_a");     
            }
            } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al cargar lista de carreras segun facultad", ex);
            } 
            cnbd.cerrarConexion();
            
            cnbd.setEsSelect(false);
            cnbd.setComandoSQL("insert into atencion(cod_p,cod_a) values('"+p.getCod_p()+"','"+codigoalumno+"')");
            cnbd.conectar();
            cnbd.cerrarConexion();
    }

    
}
