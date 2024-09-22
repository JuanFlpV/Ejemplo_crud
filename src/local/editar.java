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
public class editar {
    
    public static void main(String[] args) {
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;
    
        int idEditar = 2;
        String nuevoNombrePaciente = "TodoMil";
        String nuevoNumeroHistoriaClinica = "777555";
        String nuevaDireccion = "Milanta";
        String nuevoTelefono = "3135269";
        String sql = "UPDATE registros_medicos SET nombre_paciente='" + nuevoNombrePaciente + "', numero_historia_clinica='" + nuevoNumeroHistoriaClinica + "', direccion='" + nuevaDireccion + "', telefono='" + nuevoTelefono + "' WHERE id=" + idEditar;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
