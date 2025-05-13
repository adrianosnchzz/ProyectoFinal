package dto;

public class ProfesorDTO {
	 private int id;
	    private String nombre;
	    private String correo;
	    private String pais;
	    private String especialidad;

	    public ProfesorDTO(int id, String nombre, String correo, String pais, String especialidad) {
	        this.id = id;
	        this.nombre = nombre;
	        this.correo = correo;
	        this.pais = pais;
	        this.especialidad = especialidad;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String getCorreo() {
	        return correo;
	    }

	    public String getPais() {
	        return pais;
	    }

	    public String getEspecialidad() {
	        return especialidad;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public void setCorreo(String correo) {
	        this.correo = correo;
	    }

	    public void setPais(String pais) {
	        this.pais = pais;
	    }

	    public void setEspecialidad(String especialidad) {
	        this.especialidad = especialidad;
	    }
	}