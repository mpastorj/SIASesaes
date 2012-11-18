/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import basededatos.atencionBD;
import basededatos.carreraBD;

/**
 *
 * @author Milii2
 */
public class Atencion {
   
    public int codigo_c;

    public int getCodigo_c() {
        return codigo_c;
    }

    public void setCodigo_c(int codigo_c) {
        this.codigo_c = codigo_c;
    }

    public Atencion(int codigo_c, int codigo_a, int codigo_p) {
        this.codigo_c = codigo_c;
        this.codigo_a = codigo_a;
        this.codigo_p = codigo_p;
    }
    public int codigo_a;
    public int codigo_p;

    public Atencion(int codigo_a, int codigo_p) {
        this.codigo_a = codigo_a;
        this.codigo_p = codigo_p;
    }

    public Atencion(int codigo_p) {
        this.codigo_p = codigo_p;
    }

    public int getCodigo_a() {
        return codigo_a;
    }

    public void setCodigo_a(int codigo_a) {
        this.codigo_a = codigo_a;
    }

    public int getCodigo_p() {
        return codigo_p;
    }

    public void setCodigo_p(int codigo_p) {
        this.codigo_p = codigo_p;
    }
    
    public Atencion(){
    }
    
    public void insertaalumno() throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException,
                                java.sql.SQLException
    {
        atencionBD adb=new atencionBD();
        adb.insertaalumno();
        
        
    }
       
    public void buscacodigoalumno(Atencion modelo) throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException,
                                java.sql.SQLException
    {
        atencionBD adb=new atencionBD(modelo);
        adb.buscacodigoalumno();
    }





 

    
}
