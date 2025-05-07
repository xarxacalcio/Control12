package com.escalones.control12.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.List;

// Clase que extiende AbstractTableModel para manejar una tabla de alumnos
/**
 * ModeloTablaAlumnos es una clase que extiende AbstractTableModel y se utiliza para representar
 * una tabla de alumnos en una interfaz gráfica.
 * 
 * <p>Esta clase proporciona los métodos necesarios para obtener el número de filas y columnas,
 * los nombres de las columnas y los valores de las celdas de la tabla.</p>
 */
public class ModeloTablaAlumnos extends AbstractTableModel {

    /**
     * Lista de alumnos que se mostrarán en la tabla.
     */
    private final List<Alumno> alumnos;

    /**
     * Nombres de las columnas de la tabla.
     */
    private final String[] columnNames = {"id","Nombre","Apellidos", "Teléfono 1", "Teléfono 2", "Email", "Fecha Nacimiento", "Fecha Alta"};

    /**
     * Constructor que recibe una lista de alumnos.
     * 
     * @param alumnos la lista de alumnos que se mostrarán en la tabla
     */
    public ModeloTablaAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * Método que devuelve el número de filas de la tabla.
     * 
     * @return el número de filas de la tabla
     */
    @Override
    public int getRowCount() {
        return alumnos.size();
    }

    /**
     * Método que devuelve el número de columnas de la tabla.
     * 
     * @return el número de columnas de la tabla
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Método que devuelve el nombre de una columna dado su índice.
     * 
     * @param columnIndex el índice de la columna
     * @return el nombre de la columna
     */
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    /**
     * Método que devuelve el valor de una celda dada su fila y columna.
     * 
     * @param rowIndex el índice de la fila
     * @param columnIndex el índice de la columna
     * @return el valor de la celda
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno alumno = alumnos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return alumno.getId(); // Devuelve el ID del alumno
            case 1:
                return alumno.getNombre(); // Devuelve el nombre del alumno
            case 2:
                return alumno.getApellidos(); // Devuelve los apellidos del alumno
            case 3:
                return alumno.getTelefono1(); // Devuelve el primer teléfono del alumno
            case 4:
                return alumno.getTelefono2(); // Devuelve el segundo teléfono del alumno
            case 5:
                return alumno.getEmail(); // Devuelve el email del alumno
            case 6:
                return alumno.getFechaNacimiento(); // Devuelve la fecha de nacimiento del alumno
            case 7:
                return alumno.getFechaAlta(); // Devuelve la fecha de alta del alumno
            default:
                return null; // Devuelve null si el índice de columna no es válido
        }
    }
}
