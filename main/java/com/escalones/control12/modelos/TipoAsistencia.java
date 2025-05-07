package com.escalones.control12.modelos;

/**
 * Clase que representa el tipo de asistencia.
 * Contiene un identificador y un nombre.
 * 
 * @autor xarxa
 */
/**
 * Clase que representa un tipo de asistencia.
 * Contiene un identificador único y un nombre para el tipo de asistencia.
 */
public class TipoAsistencia {
    // Identificador único del tipo de asistencia
    private Integer id;
    
    // Nombre del tipo de asistencia
    private String nombre;

    // Constructor vacío
    public TipoAsistencia() {
    }

    // Obtiene el identificador del tipo de asistencia
    public Integer getId() {
        return id;
    }

    // Establece el identificador del tipo de asistencia
    public void setId(Integer id) {
        this.id = id;
    }

    // Obtiene el nombre del tipo de asistencia
    public String getNombre() {
        return nombre;
    }

    // Establece el nombre del tipo de asistencia
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve el nombre del tipo de asistencia como cadena de texto
    @Override
    public String toString() {
        return nombre;
    }
}
