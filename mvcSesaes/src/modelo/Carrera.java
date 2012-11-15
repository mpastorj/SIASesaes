/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import basededatos.carreraBD;
import basededatos.facultadBD;
import java.util.ArrayList;

/**
 *
 * @author Milii2
 */
public class Carrera {
    
    public String nombre_c;
    public int cod_c;
    public int cod_f;

    public ArrayList <String> nombres_c;

    public Carrera(){
    
    }
    
    
    public Carrera(String nombre_c, int cod_c, int cod_f, ArrayList<String> nombres_c) {
        this.nombre_c = nombre_c;
        this.cod_c = cod_c;
        this.cod_f = cod_f;
        this.nombres_c = nombres_c;
    }


    public Carrera(String nombre_c, int cod_c, int cod_f) {
        this.nombre_c = nombre_c;
        this.cod_c = cod_c;
        this.cod_f = cod_f;
        //this.nombres_c = nombres_c;
    }
    



    public Carrera(String nombre_c, int cod_c) {
        this.nombre_c = nombre_c;
        this.cod_c = cod_c;
    }
    
    
    public ArrayList<String> getNombres_c() {
        return nombres_c;
    }

    public void setNombres_c(ArrayList<String> nombres_c) {
        this.nombres_c = nombres_c;
    }


        public int getCod_f() {
        return cod_f;
    }

    public void setCod_f(int cod_f) {
        this.cod_f = cod_f;
    }
    
    

    public String getNombre_c() {
        return nombre_c;
    }

    public void setNombre_c(String nombre_c) {
        this.nombre_c = nombre_c;
    }

    public int getCod_c() {
        return cod_c;
    }

    public void setCod_c(int cod_c) {
        this.cod_c = cod_c;
    }
    
    
       public void leer() throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException,
                                java.sql.SQLException
    {
        carreraBD cdb=new carreraBD(this);
        cdb.leer();
    }


    
    
}
