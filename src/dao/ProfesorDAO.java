package dao;

import dto.ProfesorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfesorDAO {
    private Connection conexion;

    // Constructor: obtiene la conexión a la base de datos
    public ProfesorDAO() {
        this.conexion = Conexion.ConexionBD.getConexion();
    }

    // Método para insertar un profesor en la base de datos
    public boolean insertar(ProfesorDTO profesor) {
        // Sentencia SQL para insertar datos en la tabla 'profesores'
        String sql = "INSERT INTO profesores (nombre, correo_electronico, pais_origen, especialidad) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            // Asigna los valores al SQL en orden
            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getCorreoElectronico());
            ps.setString(3, profesor.getPaisOrigen());
            ps.setString(4, profesor.getEspecialidad());

            // Ejecuta la inserción y obtiene el número de filas afectadas
            int filasInsertadas = ps.executeUpdate();

            // Si se insertó al menos una fila, imprime mensaje y devuelve true
            if (filasInsertadas > 0) {
                System.out.println("Profesor insertado correctamente.");
                return true;
            } else {
                // Si no se insertó nada, imprime mensaje y devuelve false
                System.out.println("No se pudo insertar el profesor.");
                return false;
            }
        } catch (SQLException e) {
            // Si hay un error en la base de datos, imprime el error y devuelve false
            System.out.println("Error al insertar profesor:");
            e.printStackTrace();
            return false;
        }
    }
}

