package dao;

import dto.EstudianteDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    /**
     * Inserta un nuevo estudiante en la base de datos.
     * @param estudiante Objeto con los datos del estudiante a guardar.
     */
    public void insertar(EstudianteDTO estudiante) {
        String sql = "INSERT INTO estudiante (nombre, correo, pais, fecha_nacimiento) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, estudiante.getNombreCompleto());
            stmt.setString(2, estudiante.getCorreoElectronico());
            stmt.setString(3, estudiante.getPaisResidencia());
            stmt.setDate(4, estudiante.getFechaNacimiento());

            stmt.executeUpdate();
            System.out.println("✅ Estudiante insertado correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar estudiante: " + e.getMessage());
        }
    }

    /**
     * Busca un estudiante en la base de datos por su ID.
     * @param id_Estudiante El ID del estudiante que quieres buscar.
     * @return Un objeto EstudianteDTO con los datos, o null si no se encuentra.
     */
    public EstudianteDTO obtenerPorId(int id_Estudiante) {
        String sql = "SELECT * FROM estudiante WHERE id_Estudiante = ?";

        try (Connection conn = Conexion.ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_Estudiante);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Creamos y llenamos el DTO con los datos encontrados
                EstudianteDTO estudiante = new EstudianteDTO();
                estudiante.setId_estudiante(rs.getInt("id_Estudiante"));
                estudiante.setNombreCompleto(rs.getString("nombre"));
                estudiante.setCorreoElectronico(rs.getString("correo"));
                estudiante.setPaisResidencia(rs.getString("pais"));
                estudiante.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                return estudiante;
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al obtener estudiante por ID: " + e.getMessage());
        }

        return null; // Si no lo encuentra o hay error
    }

    /**
     * Devuelve una lista con todos los estudiantes de la base de datos.
     * @return Lista de EstudianteDTO, puede estar vacía si no hay registros.
     */
    public List<EstudianteDTO> listarTodos() {
        List<EstudianteDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudiante";

        try (Connection conn = Conexion.ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EstudianteDTO estudiante = new EstudianteDTO();
                estudiante.setId_estudiante(rs.getInt("id_Estudiante"));
                estudiante.setNombreCompleto(rs.getString("nombre"));
                estudiante.setCorreoElectronico(rs.getString("correo"));
                estudiante.setPaisResidencia(rs.getString("pais"));
                estudiante.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                lista.add(estudiante);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al listar estudiantes: " + e.getMessage());
        }

        return lista;
    }
}