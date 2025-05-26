package dao;

import dto.MatriculaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {
    private Connection conexion;

    public MatriculaDAO() {
        // Aquí usamos la conexión a la BD que ya tienes configurada
        this.conexion = Conexion.ConexionBD.getConexion();
    }

    // Guardamos una matrícula nueva en la tabla Matricula
    public boolean insertar(MatriculaDTO matricula) {
        // Ojo con los nombres, que coincidan con la BD
        String sql = "INSERT INTO Matricula (Id_Estudiante, Id_Curso, Fecha, Estado) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, matricula.getId_estudiante());
            ps.setInt(2, matricula.getIdCurso());
            ps.setDate(3, matricula.getFechaInscripcion());
            ps.setString(4, matricula.getEstadoFinalizacion());

            int filasInsertadas = ps.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println(" Matrícula insertada correctamente.");
                return true;
            } else {
                System.out.println(" No se pudo insertar la matrícula.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println(" Error al insertar matrícula:");
            e.printStackTrace();
            return false;
        }
    }

    // Traemos todas las matrículas de un estudiante
    public List<MatriculaDTO> obtenerCursosPorEstudiante(int idEstudiante) {
        List<MatriculaDTO> lista = new ArrayList<>();
        String sql = "SELECT Id_Matricula, Id_Estudiante, Id_Curso, Fecha, Estado FROM Matricula WHERE Id_Estudiante = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idEstudiante);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int idMatricula = rs.getInt("Id_Matricula");
                    int idCurso = rs.getInt("Id_Curso");
                    java.sql.Date fecha = rs.getDate("Fecha");
                    String estado = rs.getString("Estado");

                    MatriculaDTO matricula = new MatriculaDTO(idMatricula, idEstudiante, idCurso, fecha, estado);
                    lista.add(matricula);
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al obtener cursos por estudiante:");
            e.printStackTrace();
        }

        return lista;
    }

    // Borra matrícula con el id que le pases
    public boolean eliminar(int idMatricula) {
        String sql = "DELETE FROM Matricula WHERE Id_Matricula = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idMatricula);

            int filasEliminadas = ps.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("✅ Matrícula eliminada correctamente.");
                return true;
            } else {
                System.out.println("⚠️ No se encontró matrícula con ese ID.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar la matrícula:");
            e.printStackTrace();
            return false;
        }
    }

    // Trae lista de IDs de estudiantes que completaron un curso
    public List<Integer> obtenerEstudiantesCompletaronCurso(int idCurso) {
        List<Integer> listaEstudiantes = new ArrayList<>();
        String sql = "SELECT Id_Estudiante FROM Matricula WHERE Id_Curso = ? AND Estado = 'Completado'";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idCurso);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    listaEstudiantes.add(rs.getInt("Id_Estudiante"));
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener estudiantes que completaron el curso:");
            e.printStackTrace();
        }

        return listaEstudiantes;
    }
}