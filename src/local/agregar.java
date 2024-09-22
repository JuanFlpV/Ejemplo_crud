/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local;

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
public class agregar {
    public static void main(String[] args) {
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        int id = 4;
        String nombrePaciente = "Carla";
        String numeroHistoriaClinica = "3440147";
        String direccion = "Medellin";
        String telefono = "3117683580";
        String sql = "INSERT INTO registros_medicos (nombre_paciente, numero_historia_clinica, direccion, telefono, id) values ('" + nombrePaciente + "','" + numeroHistoriaClinica + "','" + direccion + "','" + telefono + "','" + id + "')";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql);
            rs = st.executeQuery("SELECT * FROM registros_medicos");
            rs.next();

            do {
                System.out.println(rs.getInt("numero_historia_clinica") + ":" + rs.getString("nombre_paciente") + "-" + rs.getString("direccion") + "-" + rs.getString("telefono") + "-" + rs.getString("id"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
