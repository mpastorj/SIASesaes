/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;
import java.sql.SQLException;
import java.util.logging.Level; /*(01)ESTA LINEA*/
import java.util.logging.Logger; /*(01)ESTA LINEA*/
//import modelo.error;
//import modelo.unicaconexion;
//import modelo.conexion;
import modelo.Persona;
import modelo.conexion;
import vista.VentanaPrincipal; /*(01)ESTA LINEA*/

/**
 *
 * @author Milii2
 */////
public class personaBD {
    
    private Persona p;


    String jtnombre;
    public personaBD(Persona p)
    {
        this.p=p;
    }

  
    public void grabar() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
    {
        //conexion cdb=unicaconexion.getInstancia().getConexionDb();
        String titulo=""; /*(01)ESTA LINEA*/
        conexion cdb=new conexion();
        cdb.setEsSelect(false);
        cdb.setComandoSQL("insert into alumno(nombre_a,cod_c) values('"+p.getNombre()+"','"+p.getRut()+"')"); /*(01)ESTA LINEA*/
        cdb.conectar();
        //try {
        //
         //   while(cdb.getRst().next()) {
         //       jtnombre=cdb.getRst().getString("nombre");
                //p.setNombre(jtnombre);
                //p.setFono("hola");
                
         //   }
            
         //   } catch (SQLException ex) {
         //   Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al asignar codigo de carrera", ex);
         //   }
            cdb.cerrarConexion();
            //p.setNombre(jtnombre);
       
        /*(01)AGREGAR ESTA NUEVA CONSULTA*/
            cdb.setEsSelect(true);
            cdb.setComandoSQL("select nombre_c  from carrera where cod_c ='"+p.getRut()+"'" );
            cdb.conectar();
           
            try {
            while(cdb.getRst().next()) {
                    titulo =cdb.getRst().getString("nombre_c");
                }
            } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al asignar codigo de carrera", ex);
            }
            cdb.cerrarConexion();
            p.setFono(titulo);
      /*(01)AGREGAR HASTA ACA*/
            
            
            //vista.VentanaPrincipal.jtfono.setText(p.getFono());
        
        /*cdb.setEsSelect(false);
        cdb.setComandoSQL("insert into carrera(cod_c,nombre_c) values('"+p.getRut()+"','Ingeniería en Informática')");
        cdb.conectar();
        cdb.cerrarConexion();*/
        //p.setNombre(jtnombre);

        
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
                        // error
    {
   //    conexion cdb=unicaconexion.getInstancia().getConexionDb();
     //  cdb.un_sql="SELECT * FROM persona WHERE rut='"+p.getRut()+"'";
     //  cdb.resultado=cdb.un_st.executeQuery(cdb.un_sql);
       
     //  if(cdb.resultado!=null){
       //    if(cdb.resultado.next()){
         //      p.setNombre(cdb.resultado.getString("nombre"));
           //    p.setFono(cdb.resultado.getString("fono"));
             //  p.setEdad(cdb.resultado.getInt("edad"));
          // }
          // else {
             //  throw new error(-1,"Registro "+p.getRut()+"no encontrado en tabla persona. Ubicacion="+this.getClass().getName());
         //  }
        return null;
       }
     //   return p;
    
    
    public void borrar() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
    {
       // conexion cdb=unicaconexion.getInstancia().getConexionDb();
        
      //  cdb.un_sql="DELETE FROM persona WHERE rut='"+p.getRut()+"'";
      //  cdb.un_st.executeUpdate(cdb.un_sql);
    }
        
}
