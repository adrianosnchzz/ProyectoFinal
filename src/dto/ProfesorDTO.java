package dto;

public class ProfesorDTO {
    private String nombre;
    private String correoElectronico;
    private String paisOrigen;
    private String especialidad;
	private int Id_profesor;
    
    
    
    
    public ProfesorDTO(int i, String nombre2, String correo, String pais, String especialidad2,int Id_profesor) {
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getId_profesor() {
		return Id_profesor;
	}
	public void setId_profesor(int id_profesor) {
		Id_profesor = id_profesor;
	}

  
}