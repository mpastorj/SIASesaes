/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import basededatos.carreraBD;
import basededatos.profesionalBD;
import java.util.ArrayList;

/**
 *
 * @author Milii2
 */
public class Profesional {
    
    public String nombre_p;
    public int cod_p;
    public int cod_e;

    public Profesional(String nombre_p, int cod_p, int cod_e, ArrayList<String> nombres_p) {
        this.nombre_p = nombre_p;
        this.cod_p = cod_p;
        this.cod_e = cod_e;
        this.nombres_p = nombres_p;
    }
    
    public ArrayList <String> nombres_p;

    public Profesional(String nombre_p, int cod_p) {
        this.nombre_p = nombre_p;
        this.cod_p = cod_p;
    }

    public String getNombre_p() {
        return nombre_p;
    }

    public void setNombre_p(String nombre_p) {
        this.nombre_p = nombre_p;
    }

    public int getCod_p() {
        return cod_p;
    }

    public void setCod_p(int cod_p) {
        this.cod_p = cod_p;
    }

    public int getCod_e() {
        return cod_e;
    }

    public void setCod_e(int cod_e) {
        this.cod_e = cod_e;
    }

    public ArrayList<String> getNombres_p() {
        return nombres_p;
    }

    public void setNombres_p(ArrayList<String> nombres_p) {
        this.nombres_p = nombres_p;
    }
    
    public Profesional(){}
    
           public void leer() throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException,
                                java.sql.SQLException
    {
        profesionalBD pdb=new profesionalBD(this);
        pdb.leer();
    }
           
    public void buscar() throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException,
                                java.sql.SQLException
    {
        profesionalBD pdb=new profesionalBD(this);
        pdb.buscar();
    }

    
    
    
}
