package dao;

import java.util.List;

import dto.MatriculaDTO;

public class MatriculaDAO {
	package dao;

	import dto.Matricula;
	import conexion.ConexionBD;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;


	    public void insertarMatricula(Matricula m) {
	        String sql = "INSERT INTO matricula (idEstudiante, idCurso, fechaInscripcion, estado) VALUES (?, ?, ?, ?)";
	        try (Connection conn = ConexionBD.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, m.getIdEstudiante());
	            stmt.setInt(2, m.getIdCurso());
	            stmt.setString(3, m.getFechaInscripcion());
	            stmt.setString(4, m.getEstado());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	    public void eliminarMatricula(int idMatricula) {
	        String sql = "DELETE FROM matricula WHERE id=?";
	        try (Connection conn = ConexionBD.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, idMatricula);
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	    public List<Matricula> obtenerCursosPorEstudiante(int idEstudiante) {
	        List<Matricula> lista = new ArrayList<>();
	        String sql = "SELECT * FROM matricula WHERE idEstudiante=?";
	        try (Connection conn = ConexionBD.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, idEstudiante);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                Matricula m = new Matricula(
	                    rs.getInt("id"),
	                    rs.getInt("idEstudiante"),
	                    rs.getInt("idCurso"),
	                    rs.getString("fechaInscripcion"),
	                    rs.getString("estado")
	                );
	                lista.add(m);
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return lista;
	    }

	    public List<Integer> estudiantesCompletaronCurso(int idCurso) {
	        List<Integer> estudiantes = new ArrayList<>();
	        String sql = "SELECT idEstudiante FROM matricula WHERE idCurso=? AND estado='completado'";
	        try (Connection conn = ConexionBD.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, idCurso);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                estudiantes.add(rs.getInt("idEstudiante"));
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return estudiantes;
	    }
	}
