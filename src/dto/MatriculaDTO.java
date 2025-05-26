package dto;


import java.sql.Date;

public class MatriculaDTO {
 
    private int Id_estudiante;
    private int idCurso;
    private Date fechaInscripcion;
    private String estadoFinalizacion;
    private int Id_Matricula;

    public MatriculaDTO(int Id_matricula, int Id_estudiante, int idCurso, Date fechaInscripcion, String estadoFinalizacion) {
        this.Id_Matricula = Id_matricula;
        this.Id_estudiante =Id_estudiante;
        this.idCurso = idCurso;
        this.fechaInscripcion = fechaInscripcion;
        this.estadoFinalizacion = estadoFinalizacion;
    }

    public int getIdMatricula() {
        return Id_Matricula;
    }


    public int getIdCurso() {
        return idCurso;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public String getEstadoFinalizacion() {
        return estadoFinalizacion;
    }

	public int getId_estudiante() {
		return Id_estudiante;
	}

	public void setId_estudiante(int id_estudiante) {
		Id_estudiante = id_estudiante;
	}
}
