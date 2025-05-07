package com.escalones.control12.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.List;

// Clase que extiende AbstractTableModel para manejar una tabla de alumnos y sus pagos
/**
 * ModeloTablaAlumnosPagos es una clase que extiende AbstractTableModel y se utiliza para 
 * representar una tabla de alumnos con sus respectivos pagos.
 */
public class ModeloTablaAlumnosPagos extends AbstractTableModel {
    // Lista de alumnos
    private final List<Alumno> alumnos;
    // Nombres de las columnas de la tabla
    private final String[] columnNames = {"id","Nombre","Apellidos", "Teléfono 1",  "Email"};

    /**
     * Constructor que recibe una lista de alumnos.
     *
     * @param alumnos Lista de objetos Alumno que se mostrarán en la tabla.
     */
    public ModeloTablaAlumnosPagos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * Método que devuelve el número de filas de la tabla.
     *
     * @return El número de filas en la tabla, que corresponde al número de alumnos.
     */
    @Override
    public int getRowCount() {
        return alumnos.size();
    }

    /**
     * Método que devuelve el número de columnas de la tabla.
     *
     * @return El número de columnas en la tabla.
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Método que devuelve el nombre de una columna dado su índice.
     *
     * @param columnIndex El índice de la columna.
     * @return El nombre de la columna correspondiente al índice dado.
     */
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    /**
     * Método que devuelve el valor de una celda dada su fila y columna.
     *
     * @param rowIndex El índice de la fila.
     * @param columnIndex El índice de la columna.
     * @return El valor de la celda en la posición especificada.
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
                return alumno.getEmail(); // Devuelve el email del alumno
            default:
                return null; // Devuelve null si el índice de la columna no es válido
        }
    }
}
