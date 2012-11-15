/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import basededatos.facultadBD;
import vista.VentanaIngreso;

/**
 *
 * @author Milii2
 */


public class Facultad {
    public VentanaIngreso vista;
    public String Nombre_f;
    public int cod_f;

    public Facultad(String Nombre_f, int cod_f) {
        this.Nombre_f = Nombre_f;
        this.cod_f = cod_f;
    }
    
    public Facultad(){
        
    }

    public String getNombre_f() {
        return Nombre_f;
    }

    public void setNombre_f(String Nombre_f) {
        this.Nombre_f = Nombre_f;
    }

    public int getCod_f() {
        return cod_f;
    }

    public void setCod_f(int cod_f) {
        this.cod_f = cod_f;
    }
    
    public void grabar() throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException,
                                java.sql.SQLException
                                
    {
        facultadBD fdb=new facultadBD(this);
        fdb.grabar();
    }

    public void leer(Facultad modelo) throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException,
                                java.sql.SQLException
    {
        facultadBD fdb=new facultadBD(modelo);
        fdb.leer();
    }
    /*public void setNombre_f(Object selectedItem) {
        this.Nombre_f=(String) vista.listafacultad.getSelectedItem();
        throw new UnsupportedOperationException("Not yet implemented");
    }*/


    
    
}
