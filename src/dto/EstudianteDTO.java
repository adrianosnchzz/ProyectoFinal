package dto;

import java.sql.Date;
import java.time.LocalDate;

public class EstudianteDTO {
    private String nombreCompleto;
    private String correoElectronico;
    private String paisResidencia;
    private Date fechaNacimiento;
    private int Id_estudiante;
	
    
    
    
    
    
    
    
    public EstudianteDTO() {
	
	}
	public String getNombreCompleto() {
	
		
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getPaisResidencia() {
		return paisResidencia;
	}
	public void setPaisResidencia(String paisResidencia) {
		this.paisResidencia = paisResidencia;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getId_estudiante() {
		return Id_estudiante;
	}
	public void setId_estudiante(int id_estudiante) {
		Id_estudiante = id_estudiante;
	}

 
}

