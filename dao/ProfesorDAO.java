package dao;

import dto.ProfesorDTO;
import conexion.ConexionBD;

import java.sql.*;

public class ProfesorDAO {

    public void insertarProfesor(Profesor p) {
        String sql = "INSERT INTO profesor (nombre, correo, pais, especialidad) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getCorreo());
            stmt.setString(3, p.getPais());
            stmt.setString(4, p.getEspecialidad());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

