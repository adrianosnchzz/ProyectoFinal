package dto;

import java.time.LocalDate;

public class EstudianteDTO {
	 private int id;
	    private String nombreCompleto;
	    private String correo;
	    private String pais;
	    private String fechaNacimiento;

	    public EstudianteDTO(int id, String nombreCompleto, String correo, String pais, String fechaNacimiento) {
	        this.id = id;
	        this.nombreCompleto = nombreCompleto;
	        this.correo = correo;
	        this.pais = pais;
	        this.fechaNacimiento = fechaNacimiento;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getNombreCompleto() {
	        return nombreCompleto;
	    }

	    public String getCorreo() {
	        return correo;
	    }

	    public String getPais() {
	        return pais;
	    }

	    public String getFechaNacimiento() {
	        return fechaNacimiento;
	    }

	    public void setNombreCompleto(String nombreCompleto) {
	        this.nombreCompleto = nombreCompleto;
	    }

	    public void setCorreo(String correo) {
	        this.correo = correo;
	    }

	    public void setPais(String pais) {
	        this.pais = pais;
	    }

	    public void setFechaNacimiento(String fechaNacimiento) {
	        this.fechaNacimiento = fechaNacimiento;
	    }
	}
