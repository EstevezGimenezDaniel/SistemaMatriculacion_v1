package org.iesalandalus.programacion.matriculacion.vista;

public enum Opcion {
    SALIR("Salir"),
    INSERTAR_ALUMNO("Insertar Alumno"),
    BUSCAR_ALUMNO("Buscar Alumno"),
    BORRAR_ALUMNO("Borrar Alumno"),
    MOSTRAR_ALUMNOS("Mostrar Alumnos"),
    INSERTAR_CICLO_FORMATIVO("Insertar Ciclo Formativo"),
    BUSCAR_CICLO_FORMATIVO("Buscar Ciclo Formativo"),
    BORRAR_CICLO_FORMATIVO("Borrar Ciclo Formativo"),
    MOSTRAR_CICLOS_FORMATIVOS("Mostrar Ciclos Formativos"),
    INSERTAR_ASIGNATURA("Insertar Asignatura"),
    BUSCAR_ASIGNATURA("Buscar Asignatura"),
    BORRAR_ASIGNATURA("Borrar Asignatura"),
    MOSTRAR_ASIGNATURAS("Mostrar Asignaturas"),
    INSERTAR_MATRICULA("Insertar Matr?cula"),
    BUSCAR_MATRICULA("Buscar Matr?cula"),
    ANULAR_MATRICULA("Anular Matr?cula"),
    MOSTRAR_MATRICULAS("Mostrar Matr?culas"),
    MOSTRAR_MATRICULAS_ALUMNO("Mostrar Matr?culas Alumno"),
    MOSTRAR_MATRICULAS_CICLO_FORMATIVO("Mostrar Matr?culas Ciclo Formativo"),
    MOSTRAR_MATRICULAS_CURSO_ACADEMICO("Mostrar Matr?culas Curso Acad?mico");

    private final String cadenaAMostrar;

    private Opcion(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
