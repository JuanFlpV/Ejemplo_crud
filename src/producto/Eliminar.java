/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producto;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Fernando
 */
public class Eliminar {
    
    public static void main(String[] args) {
        conexion con = new conexion();    
        Connection cn;
        Statement st;
        ResultSet rs;
    
        // dato eliminar
        int idEliminar = 3;
     
        // instrucción SQL
        String sql = "DELETE FROM registros_medicos WHERE id=" + idEliminar;
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql);
            rs = st.executeQuery("SELECT * FROM registros_medicos");
            rs.next();
    
            do {
                System.out.println(rs.getInt("numero_historia_clinica") + ":" + rs.getString("nombre_paciente") + "-" + rs.getString("direccion") + "-" + rs.getString("telefono"));
            } while (rs.next());
    
        } catch (SQLException ex) {
            Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
