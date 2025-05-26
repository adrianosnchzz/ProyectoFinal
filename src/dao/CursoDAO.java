package dao;

import dto.CursoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CursoDAO {
    // Aquí guardamos la conexión a la base de datos
    private Connection conexion;

    // Constructor: cuando se crea un CursoDAO, se conecta automáticamente a la BD
    public CursoDAO() {
        this.conexion = Conexion.ConexionBD.getConexion();

        // Verificamos si se logró la conexión. Si no, mostramos un mensaje.
        if (this.conexion == null) {
            System.out.println("⚠️ No se pudo establecer conexión con la base de datos desde CursoDAO.");
        }
    }

    /**
     * Inserta un nuevo curso en la base de datos usando los datos del objeto CursoDTO
     * @param curso Objeto que contiene los datos del curso a insertar
     * @return true si se insertó correctamente, false si hubo error
     */
    public boolean insertar(CursoDTO curso) {
        // Esta es la consulta SQL con ? como comodines que luego llenamos con los datos del curso
        String sql = "INSERT INTO cursos (titulo, descripcion, duracion_semanas, nivel, id_profesor) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            // Llenamos los ? con los datos del curso
            ps.setString(1, curso.getTitulo());
            ps.setString(2, curso.getDescripcion());
            ps.setInt(3, curso.getDuracionSemanas());
            ps.setString(4, curso.getNivel());
            ps.setInt(5, curso.getId_profesor());

            // Ejecutamos la consulta y vemos cuántas filas se afectaron (debería ser 1)
            int filasInsertadas = ps.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar curso:");
            e.printStackTrace(); // Muestra detalles técnicos del error
            return false;
        }
    }

    /**
     * Actualiza algunos datos (duración y nivel) de un curso ya existente, usando su ID
     * @param idCurso ID del curso que queremos actualizar
     * @param nuevaDuracion Nueva duración del curso (en semanas)
     * @param nuevoNivel Nuevo nivel del curso (por ejemplo, 'básico', 'intermedio', etc.)
     * @return true si se actualizó al menos una fila, false si no se encontró o falló
     */
    public boolean actualizar(int idCurso, int nuevaDuracion, String nuevoNivel) {
        String sql = "UPDATE cursos SET duracion_semanas = ?, nivel = ? WHERE id_curso = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, nuevaDuracion);
            ps.setString(2, nuevoNivel);
            ps.setInt(3, idCurso);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar curso:");
            e.printStackTrace();
            return false;
        }
    }

    // Estos métodos están como plantillas por si luego necesitas hacer más cosas

    /**
     * Método alternativo para crear un curso. Por ahora no se usa.
     */
    public void crearCurso(CursoDTO curso) {
        // Aquí podrías hacer algo diferente al insertar si lo necesitas en el futuro
    }

    /**
     * Método alternativo para actualizar usando un objeto completo en lugar de solo 2 campos
     */
    public void actualizarCurso(CursoDTO curso) {
        // Similar al método actualizar, pero usando todos los datos del curso
    }
}