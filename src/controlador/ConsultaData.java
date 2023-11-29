package controlador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Consulta;
import modelo.Reclutador;

public class ConsultaData {
 private static Connection con = Conexion.conectarse();
 private static PreparedStatement ps;
 private static ResultSet rs;
 private static String sql;
 
 /* 	id	
 
 idReclutador	fecha	mensaje	
*/
 public static void subirConsulta(Consulta consulta){
     sql ="INSERT INTO consulta (idReclutador,fecha,mensaje) VALUES (?,?,?)";
     
     try {
         
         ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
         ps.setInt(1, consulta.getReclutador().getId());
         ps.setDate(2, (Date) consulta.getFecha());
         ps.setString(3, consulta.getMensaje());
         
         ps.executeUpdate();
         rs = ps.getGeneratedKeys();
         
         if(rs.next()){
         consulta.setId(rs.getInt(1));
         JOptionPane.showMessageDialog(null, "Consulta agregada con exito");
         }        
         
     } catch (SQLException ex) {
         System.out.println("Error en el metodo subirConsulta, Clase ConsultaData");
     }
 }
 
 
 /*Update --> Modificar Reclutador*/
 /* */
 public static void modificarConsulta(Consulta consulta){
      sql ="UPDATE consulta SET idReclutador = ?, fecha = ?, mensaje = ? WHERE id= ?";
      
     try {
         ps = con.prepareStatement(sql);
         ps.setInt(1, consulta.getReclutador().getId());
         ps.setDate(2, (Date) consulta.getFecha());
         ps.setString(3, consulta.getMensaje());
         
         ps.setInt(4, consulta.getId());
         
        int num =  ps.executeUpdate();
        if(num>0){
          JOptionPane.showMessageDialog(null, "Consulta modificada con exito.");
        }
        
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al modificar reclutador.");
         System.out.println("Error en el metodo modificarConsulta, Clase ConsultaData "+ex.getMessage());
     }
 }
 
 
 public static void eliminarConsulta( int id){
     sql="DELETE FROM consulta WHERE id=?";
     
     try {
         ps = con.prepareStatement(sql);
         ps.setInt(1, id);
         
        int num =  ps.executeUpdate();
        
        if(num>0){
          JOptionPane.showMessageDialog(null, "Consulta eliminada con exito.");
        }
         
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al eliminar consulta.");
         System.out.println("Error en el metodo eliminarConsulta, Clase ConsultaData "+ex.getMessage());
     }
 }
 
  /* 	
    private int id;
    private Reclutador reclutador;
    private Date fecha;
    private String mensaje;
*/
 
 public static ArrayList<Consulta> listaDeConsulta(){
     ArrayList<Consulta> lista = new ArrayList<Consulta>();
     sql="SELECT * FROM consulta";
     
     try {
         ps = con.prepareStatement(sql);
         rs= ps.executeQuery();
         
         while(rs.next()){
           Consulta consulta = new Consulta();
           consulta.setId(rs.getInt(1));
           consulta.setReclutador(ReclutadorData.reclutador(rs.getInt(2)));
           consulta.setFecha(rs.getDate(3));
           consulta.setMensaje(rs.getString(4));
           lista.add(consulta);
         }
         
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Error al devolver listaDeConsulta consulta.");
         System.out.println("Error en el metodo listaDeConsultas, Clase ConsultarData "+ex.getMessage());
     }
     return lista;
 }
 
 /*
Textos completos
id	
idReclutador	
fecha	
mensaje*/
 
 public static Consulta consulta(int id) {
    sql = "SELECT * FROM consulta WHERE id=?";
    Consulta consulta = null;  // Declarar fuera del try

    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        if (rs.next()) {  // Verificar si hay al menos un resultado
            consulta = new Consulta();
            consulta.setId(rs.getInt(1));
            consulta.setReclutador(ReclutadorData.reclutador(rs.getInt(2)));
            consulta.setFecha(rs.getDate(3));
            consulta.setMensaje(rs.getString(4));
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al devolver Consulta consulta.");
        System.out.println("Error en el metodo consulta, Clase ConsultaData " + ex.getMessage());
    }

    return consulta;
}
 
}
