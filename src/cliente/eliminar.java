/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package softwareMedico;

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
public class eliminar {
    
    public static void main(String[] args) {
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;
    
        // Dato a eliminar
        int id_eliminar = 4;
     
        // Instrucción SQL
        String sql = "DELETE FROM pacientes WHERE id=" + id_eliminar;
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql);
            rs = st.executeQuery("SELECT * FROM pacientes");
            rs.next();
    
            do {
                System.out.println(rs.getInt("cedula") + ":" + rs.getString("nombre") + "-" + rs.getString("direccion") + "-" + rs.getString("telefono"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
