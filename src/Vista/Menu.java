package Vista;

import java.util.*;
import java.sql.Date;
import java.time.LocalDate;

import dto.EstudianteDTO;
import dto.ProfesorDTO;
import dto.CursoDTO;
import dto.MatriculaDTO;
import dao.EstudianteDAO;
import dao.ProfesorDAO;
import dao.CursoDAO;
import dao.MatriculaDAO;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            // Mostrar menú principal
            System.out.println("BIENVENIDO A LA PLATAFORMA EDUCAONLINE ");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar nuevo estudiante");
            System.out.println("2. Crear un nuevo curso");
            System.out.println("3. Registrar profesor");
            System.out.println("4. Matricular estudiante en un curso");
            System.out.println("5. Consultar cursos de un estudiante");
            System.out.println("6. Actualizar información de un curso");
            System.out.println("7. Eliminar una matrícula");
            System.out.println("8. Listar estudiantes que completaron un curso");
            System.out.println("0. Salir del sistema");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir salto de línea pendiente

            // Ejecutar función según opción elegida
            switch (opcion) {
                case 1 -> registrarEstudiante();
                case 2 -> crearCurso();
                case 3 -> registrarProfesor();
                case 4 -> matricularEstudiante();
                case 5 -> consultarCursosEstudiante();
                case 6 -> actualizarCurso();
                case 7 -> eliminarMatricula();
                case 8 -> listarEstudiantesCompletaronCurso();
                case 0 -> System.out.println("Gracias por usar EducaOnline. ¡Hasta pronto!");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    // Método para registrar un nuevo estudiante pidiendo datos y guardando en BD
    private static void registrarEstudiante() {
        System.out.println(" Registro de Estudiante");
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.print("País de residencia: ");
        String pais = scanner.nextLine();
        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        // Convertir String a java.sql.Date para guardar en BD
        Date fechaNacimiento = Date.valueOf(scanner.nextLine());

        // Crear objeto EstudianteDTO con los datos ingresados
        EstudianteDTO estudiante = new EstudianteDTO();
        estudiante.setNombreCompleto(nombre);
        estudiante.setCorreoElectronico(correo);
        estudiante.setPaisResidencia(pais);
        estudiante.setFechaNacimiento(fechaNacimiento);

        // Insertar en BD usando DAO
        new EstudianteDAO().insertar(estudiante);

        System.out.println(" Estudiante registrado correctamente.");
    }

    // Método para crear un nuevo curso y guardarlo en BD
    private static void crearCurso() {
        System.out.println("Creación de Curso");
        System.out.print("Título del curso: ");
        String titulo = scanner.nextLine();
        System.out.print("Descripción breve: ");
        String descripcion = scanner.nextLine();
        System.out.print("Duración en semanas: ");
        int duracion = scanner.nextInt();
        scanner.nextLine();  // Consumir salto de línea
        System.out.print("Nivel (básico, intermedio, avanzado): ");
        String nivel = scanner.nextLine();
        System.out.print("ID del profesor asignado: ");
        int idProfesor = scanner.nextInt();
        scanner.nextLine();  // Consumir salto de línea

        // Crear objeto CursoDTO con los datos ingresados
        CursoDTO curso = new CursoDTO(titulo, descripcion, duracion, nivel, idProfesor);

        // Insertar en BD usando DAO
        new CursoDAO().insertar(curso);

        System.out.println("✅ Curso creado exitosamente.");
    }

    // Método para registrar un profesor en BD
    private static void registrarProfesor() {
        System.out.println("Registro de Profesor");
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.print("País de origen: ");
        String pais = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        // Crear objeto ProfesorDTO con los datos ingresados
        int idprofesor= scanner.nextInt();
        ProfesorDTO profesor = new ProfesorDTO(0, especialidad, especialidad, especialidad, especialidad,idprofesor );
        profesor.setNombre(nombre);
        profesor.setCorreoElectronico(correo);
        profesor.setPaisOrigen(pais);
        profesor.setEspecialidad(especialidad);

        // Insertar en BD usando DAO
        new ProfesorDAO().insertar(profesor);

        System.out.println("✅ Profesor registrado correctamente.");
    }

    // Método para matricular un estudiante en un curso
    private static void matricularEstudiante() {
        System.out.println("\n--- Matrícula de Estudiante ---");
        System.out.print("ID del estudiante: ");
        int idEstudiante = scanner.nextInt();
        System.out.print("ID del curso: ");
        int idCurso = scanner.nextInt();
        scanner.nextLine();  // Consumir salto línea
        System.out.print("Estado del curso (completado / en curso): ");
        String estado = scanner.nextLine();

        // Fecha actual para fecha de inscripción
        Date fechaInscripcion = Date.valueOf(LocalDate.now());

        // Crear objeto MatriculaDTO con los datos
        MatriculaDTO matricula = new MatriculaDTO(0, idEstudiante, idCurso, fechaInscripcion, estado);

        // Insertar matrícula en BD usando DAO
        new MatriculaDAO().insertar(matricula);

        System.out.println("✅ Matrícula realizada con éxito.");
    }

    // Método para consultar los cursos en los que está inscrito un estudiante
    private static void consultarCursosEstudiante() {
        System.out.println("\n--- Consulta de Cursos del Estudiante ---");
        System.out.print("Ingrese el ID del estudiante: ");
        int idEstudiante = scanner.nextInt();

        // Obtener lista de matrículas para ese estudiante
        List<MatriculaDTO> lista = new MatriculaDAO().obtenerCursosPorEstudiante(idEstudiante);

        if (lista.isEmpty()) {
            System.out.println("⚠️ El estudiante no está inscrito en ningún curso.");
        } else {
            // Mostrar ID del curso y estado para cada matrícula
            for (MatriculaDTO m : lista) {
                System.out.println("Curso ID: " + m.getIdCurso() + " | Estado: " + m.getEstadoFinalizacion());
            }
        }
    }

    // Método para actualizar duración y nivel de un curso
    private static void actualizarCurso() {
        System.out.println("\n--- Actualización de Curso ---");
        System.out.print("ID del curso a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir salto línea
        System.out.print("Nueva duración en semanas: ");
        int duracion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nivel (básico / intermedio / avanzado): ");
        String nivel = scanner.nextLine();

        // Llamar al DAO para actualizar curso
        new CursoDAO().actualizar(id, duracion, nivel);

        System.out.println("✅ Curso actualizado correctamente.");
    }

    // Método para eliminar una matrícula por su ID
    private static void eliminarMatricula() {
        System.out.println("\n--- Eliminación de Matrícula ---");
        System.out.print("ID de la matrícula a eliminar: ");
        int id = scanner.nextInt();

        // Llamar al DAO para eliminar matrícula
        new MatriculaDAO().eliminar(id);

        System.out.println("✅ Matrícula eliminada correctamente.");
    }

    // Método para listar estudiantes que completaron un curso
    private static void listarEstudiantesCompletaronCurso() {
        System.out.println(" Listado de Estudiantes que Completaron un Curso");
        System.out.print("Ingrese el ID del curso: ");
        int idCurso = scanner.nextInt();

        // Obtener lista de IDs de estudiantes que completaron ese curso
        List<Integer> lista = new MatriculaDAO().obtenerEstudiantesCompletaronCurso(idCurso);

        if (lista.isEmpty()) {
            System.out.println("Ningún estudiante ha completado este curso aún.");
        } else {
            // Mostrar IDs de estudiantes
            for (Integer id : lista) {
                System.out.println("Estudiante ID: " + id);
            }
        }
    }
}
