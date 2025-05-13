package dto;

public class CursoDTO {
	private int id;
    private String titulo;
    private String descripcion;
    private int duracionSemanas;
    private String nivel;
    private int idProfesor; // Un curso tiene un único profesor

    public CursoDTO(int id, String titulo, String descripcion, int duracionSemanas, String nivel, int idProfesor) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracionSemanas = duracionSemanas;
        this.nivel = nivel;
        this.idProfesor = idProfesor;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracionSemanas() {
        return duracionSemanas;
    }

    public String getNivel() {
        return nivel;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracionSemanas(int duracionSemanas) {
        this.duracionSemanas = duracionSemanas;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }
}