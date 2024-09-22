/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

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
public class editar {

    public static void main(String[] args) {
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        int id_editar = 1;
        String new_nombre = "Tate";
        String new_cedula = "1088305305";
        String new_direccion = "Providencia";
        String new_telefono = "3138996523";
        String sql = "UPDATE pacientes SET nombre='" + new_nombre + "', cedula='" + new_cedula + "', direccion='" + new_direccion + "', telefono='" + new_telefono + "' WHERE id=" + id_editar;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
