package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Reclutador;
/**
public class Consulta {
    private int id;
    private Reclutador reclutador;
    private Date fecha;
    private String mensaje;
 */
public class ReclutadorData {
 private static Connection con = Conexion.conectarse();
 private static PreparedStatement ps;
 private static ResultSet rs;
 private static String sql;
 
 /**
  CRUD
  * Create
  * Read
  * Update
  * Delete
  **/
 
 /*Create
    id	nombre	correo	 
 */
 
 public static void subirReclutador(Reclutador reclutador){
     sql ="INSERT INTO reclutador (nombre, correo) VALUES (?,?)";
     
     try {
         
         ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
         ps.setString(1, reclutador.getNombre());
         ps.setString(2, reclutador.getCorreo());
         
         ps.executeUpdate();
         rs = ps.getGeneratedKeys();
         
         if(rs.next()){
         reclutador.setId(rs.getInt(1));
         JOptionPane.showMessageDialog(null, "Reclutador agregado con exito");
         }        
         
     } catch (SQLException ex) {
         System.out.println("Error en el metodo subirReclutador, Clase ReclutadorData");
     }
 }
 
 
 /*Update --> Modificar Reclutador*/
 /* UPDATE `reclutador` SET `id`='[value-1]',`nombre`='[value-2]',`correo`='[value-3]' WHERE 1*/
 public static void modificarReclutador(Reclutador reclutador){
      sql ="UPDATE reclutador SET nombre = ?, correo = ? WHERE id= ?";
      
     try {
         ps = con.prepareStatement(sql);
         ps.setString(1,reclutador.getNombre());
         ps.setString(2, reclutador.getCorreo());
         
         ps.setInt(3, reclutador.getId());
         
        int num =  ps.executeUpdate();
        if(num>0){
          JOptionPane.showMessageDialog(null, "Reclutador modificado con exito.");
        }
        
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al modificar reclutador.");
         System.out.println("Error en el metodo modificarReclutador, Clase ReclutadorData "+ex.getMessage());
     }
 }
 
 
 public static void eliminarReclutador( int id){
     sql="DELETE FROM reclutador WHERE id=?";
     
     try {
         ps = con.prepareStatement(sql);
         ps.setInt(1, id);
         
        int num =  ps.executeUpdate();
        
        if(num>0){
          JOptionPane.showMessageDialog(null, "Reclutador eliminado con exito.");
        }
         
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al eliminar reclutador.");
         System.out.println("Error en el metodo eliminarReclutador, Clase ReclutadorData "+ex.getMessage());
     }
 }
 
 public static ArrayList<Reclutador> listaDeReclutadores(){
     ArrayList<Reclutador> lista = new ArrayList<Reclutador>();
     sql="SELECT * FROM reclutador";
     
     try {
         ps = con.prepareStatement(sql);
         rs= ps.executeQuery();
         
         while(rs.next()){
           Reclutador reclutador = new Reclutador();
           reclutador.setId(rs.getInt(1));
           reclutador.setNombre(rs.getString(2));
           reclutador.setCorreo(rs.getString(3));
           
           lista.add(reclutador);
         }
         
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al devolver listaDeReclutadores reclutador.");
         System.out.println("Error en el metodo listaDeReclutadores, Clase ReclutadorData "+ex.getMessage());
     }
     return lista;
 }
 
 /* id	nombre	correo	
*/
public static Reclutador reclutador(int id) {
    sql = "SELECT * FROM reclutador WHERE id=?";
    Reclutador reclutador = null;  // Declarar fuera del try

    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        if (rs.next()) {  // Verificar si hay al menos un resultado
            reclutador = new Reclutador();
            reclutador.setId(rs.getInt(1));
            reclutador.setNombre(rs.getString(2));
            reclutador.setCorreo(rs.getString(3));
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al devolver Reclutador reclutador.");
        System.out.println("Error en el metodo reclutadores, Clase ReclutadorData " + ex.getMessage());
    }

    return reclutador;
}

 
 
 
 
}
