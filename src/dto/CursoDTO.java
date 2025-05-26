package dto;

public class CursoDTO {
    private String titulo;
    private String descripcion;
    private int duracionSemanas;
    private String nivel;
    private int Id_curso;
    private int Id_profesor;

    // Constructor vacío (por si quieres crear el objeto y luego usar setters)
    public CursoDTO() {
    }

    // Constructor con todos los campos excepto Id_curso (ya que suele ser autogenerado)
    public CursoDTO(String titulo, String descripcion, int duracionSemanas, String nivel, int Id_profesor) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracionSemanas = duracionSemanas;
        this.nivel = nivel;
        this.Id_profesor = Id_profesor;
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getDuracionSemanas() {
        return duracionSemanas;
    }
    public void setDuracionSemanas(int duracionSemanas) {
        this.duracionSemanas = duracionSemanas;
    }
    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public int getId_curso() {
        return Id_curso;
    }
    public void setId_curso(int id_curso) {
        Id_curso = id_curso;
    }
    public int getId_profesor() {
        return Id_profesor;
    }
    public void setId_profesor(int id_profesor) {
        Id_profesor = id_profesor;
    }
}