package dao;



import dto.Curso;
import conexion.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public void insertarCurso(Curso c) {
        String sql = "INSERT INTO curso (titulo, descripcion, duracionSemanas, nivel, idProfesor) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getTitulo());
            stmt.setString(2, c.getDescripcion());
            stmt.setInt(3, c.getDuracionSemanas());
            stmt.setString(4, c.getNivel());
            stmt.setInt(5, c.getIdProfesor());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void actualizarCurso(Curso c) {
        String sql = "UPDATE curso SET duracionSemanas=?, nivel=? WHERE id=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, c.getDuracionSemanas());
            stmt.setString(2, c.getNivel());
            stmt.setInt(3, c.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
