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
public class editar {
    
    public static void main(String[] args) {
        conexion con = new conexion();    
        Connection cn;
        Statement st;
        ResultSet rs;
    
        int id_editar = 3;
        String new_producto = "Examen Odontologico";
        String new_cantidad = "2";
        String new_direccion_entrega = "lerle@gmail.com";
        String sql = "UPDATE producto SET producto='" + new_producto + "', cantidad='" + new_cantidad + "', direccion_entrega='" + new_direccion_entrega + "' WHERE id=" + id_editar;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql);
            rs = st.executeQuery("SELECT * FROM producto");

            while (rs.next()) {
                System.out.println(rs.getString("producto") + ":" + rs.getString("cantidad") + "-" + rs.getString("direccion_entrega") + "-" + rs.getInt("id"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
