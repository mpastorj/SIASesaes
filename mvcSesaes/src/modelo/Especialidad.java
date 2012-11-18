/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import basededatos.especialidadBD;
import basededatos.facultadBD;

/**
 *
 * @author Milii2
 */
public class Especialidad {
    
    public String nombre_e;
    public int cod_e;

    public Especialidad(String nombre_e, int cod_e) {
        this.nombre_e = nombre_e;
        this.cod_e = cod_e;
    }
    
    public Especialidad(){}

    public String getNombre_e() {
        return nombre_e;
    }

    public void setNombre_e(String nombre_e) {
        this.nombre_e = nombre_e;
    }

    public int getCod_e() {
        return cod_e;
    }

    public void setCod_e(int cod_e) {
        this.cod_e = cod_e;
    }
    
        public void leer(Especialidad modelo) throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException,
                                java.sql.SQLException
    {
        especialidadBD edb=new especialidadBD(modelo);
        edb.leer();
    }
    
    
}
