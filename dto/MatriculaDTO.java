package dto;

import java.time.LocalDate;

public class MatriculaDTO {
	 private int id;
	    private int idEstudiante;
	    private int idCurso;
	    private String fechaInscripcion;
	    private String estado; // "completado" o "en curso"

	    public MatriculaDTO(int id, int idEstudiante, int idCurso, String fechaInscripcion, String estado) {
	        this.id = id;
	        this.idEstudiante = idEstudiante;
	        this.idCurso = idCurso;
	        this.fechaInscripcion = fechaInscripcion;
	        this.estado = estado;
	    }

	    public int getId() {
	        return id;
	    }

	    public int getIdEstudiante() {
	        return idEstudiante;
	    }

	    public int getIdCurso() {
	        return idCurso;
	    }

	    public String getFechaInscripcion() {
	        return fechaInscripcion;
	    }

	    public String getEstado() {
	        return estado;
	    }

	    public void setFechaInscripcion(String fechaInscripcion) {
	        this.fechaInscripcion = fechaInscripcion;
	    }

	    public void setEstado(String estado) {
	        this.estado = estado;
	    }
	}