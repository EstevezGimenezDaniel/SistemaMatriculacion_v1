package org.iesalandalus.programacion.matriculacion.vista;
import org.iesalandalus.programacion.matriculacion.dominio.*;
import org.iesalandalus.programacion.utilidades.Entrada;
import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Consola {
    private Consola() {}

    public static void mostrarMenu() {
        System.out.println("\nMen? de opciones:");
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }
    public static Opcion elegirOpcion() {
        int opcion;
        do {
            System.out.print("Elige una opci?n del men?: ");
            opcion = Entrada.entero();
        } while (opcion < 0 || opcion >= Opcion.values().length);
        return Opcion.values()[opcion];
    }
    public static Alumno leerAlumno() {
        String nombre = leerCadena("Introduce el nombre del alumno:");
        String telefono = leerCadena("Introduce el tel?fono del alumno:");
        String correo = leerCadena("Introduce el correo del alumno:");
        String dni = leerCadena("Introduce el DNI del alumno:");
        LocalDate fechaNacimiento = leerFecha("Introduce la fecha de nacimiento del alumno:");
        return new Alumno(nombre, dni, correo, telefono, fechaNacimiento);
    }

    public static Alumno leerAlumnoPorDni() {
        String dni = leerCadena("Introduce el DNI del alumno:");
        return new Alumno("Ficticio", dni, "ficticio@inventado.es", "000000000", LocalDate.of(2000, 1, 1));
    }

    public static LocalDate leerFecha(String mensaje) {
        do {
            try {
                System.out.print(mensaje + " (" + Alumno.FORMATO_FECHA + "): ");
                return LocalDate.parse(Entrada.cadena(), DateTimeFormatter.ofPattern(Alumno.FORMATO_FECHA));
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: Formato de fecha incorrecto.");
            }
        } while (true);
    }

    public static Grado leerGrado() {
        System.out.println("\nLista de grados disponibles:");
        for (Grado grado : Grado.values()) {
            System.out.println(grado.imprimir());
        }
        int seleccion;
        do {
            System.out.print("Introduce el c?digo del grado: ");
            seleccion = Entrada.entero();
        } while (seleccion < 0 || seleccion >= Grado.values().length);
        return Grado.values()[seleccion];
    }

    public static CicloFormativo leerCicloFormativo() {
        int codigo = leerEnteroPositivo("Introduce el c?digo del ciclo formativo:");
        String familiaProfesional = leerCadena("Introduce la familia profesional del ciclo formativo:");
        Grado grado = leerGrado();
        String nombre = leerCadena("Introduce el nombre del ciclo formativo:");
        int horas = leerEnteroPositivo("Introduce las horas del ciclo formativo (M?ximo: " + CicloFormativo.MAXIMO_NUMERO_HORAS + "):");
        if (horas > CicloFormativo.MAXIMO_NUMERO_HORAS) {
            throw new IllegalArgumentException("ERROR: El n?mero de horas no puede ser mayor que " + CicloFormativo.MAXIMO_NUMERO_HORAS);
        }
        return new CicloFormativo(codigo, familiaProfesional, grado, nombre, horas);
    }

    public static void mostrarCiclosFormativos(CicloFormativo[] ciclosFormativos) {
        System.out.println("\nLista de ciclos formativos disponibles:");
        if (ciclosFormativos.length == 0) {
            System.out.println("No hay ciclos formativos registrados.");
        } else {
            for (CicloFormativo ciclo : ciclosFormativos) {
                System.out.println(ciclo);
            }
        }
    }

    public static Asignatura leerAsignatura(CicloFormativo cicloFormativo) {
        String codigo = leerCadena("Introduce el c?digo de la asignatura (4 d?gitos):");
        String nombre = leerCadena("Introduce el nombre de la asignatura:");
        int horasAnuales = leerEnteroPositivo("Introduce las horas anuales de la asignatura:");
        Curso curso = leerCurso();
        int horasDesdoble = leerEnteroPositivo("Introduce las horas desdoble de la asignatura:");
        EspecialidadProfesorado especialidad = leerEspecialidadProfesorado();
        return new Asignatura(codigo, nombre, horasAnuales, curso, horasDesdoble, especialidad, cicloFormativo);
    }

    private static EspecialidadProfesorado leerEspecialidadProfesorado() {
        return leerEspecialidadProfesorado();
    }

    private static Curso leerCurso() {
        return leerCurso();
    }

    public static Matricula leerMatricula(Alumno alumno, Asignatura[] asignaturas) throws OperationNotSupportedException {
        if (alumno == null) {
            throw new NullPointerException("ERROR: El alumno no puede ser nulo.");
        }
        if (asignaturas == null || asignaturas.length == 0) {
            throw new NullPointerException("ERROR: La matr?cula debe contener asignaturas.");
        }
        int id = leerEnteroPositivo("Introduce el ID de la matr?cula:");
        String cursoAcademico = leerCadena("Introduce el curso acad?mico (Formato 24-25):");
        LocalDate fechaMatriculacion = leerFecha("Introduce la fecha de matriculaci?n:");
        return new Matricula(id, cursoAcademico, fechaMatriculacion, alumno, asignaturas);
    }

    private static String leerCadena(String mensaje) {
        String cadena;
        do {
            System.out.print(mensaje + " ");
            cadena = Entrada.cadena().trim();
        } while (cadena.isEmpty());
        return cadena;
    }

    private static int leerEnteroPositivo(String mensaje) {
        int numero;
        do {
            System.out.print(mensaje + " ");
            numero = Entrada.entero();
        } while (numero <= 0);
        return numero;
    }
}
