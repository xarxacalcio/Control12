package com.escalones.control12.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.List;

// Clase que extiende AbstractTableModel para manejar una tabla de profesores
/**
 * ModeloTablaProfesores is a custom table model for displaying a list of Profesor objects in a JTable.
 * It extends AbstractTableModel and provides the necessary methods to define the structure and content of the table.
 */
public class ModeloTablaProfesores extends AbstractTableModel {

    /**
     * List of Profesor objects to be displayed in the table.
     */
    private final List<Profesor> profesores;

    /**
     * Names of the columns in the table.
     */
    private final String[] columnNames = {"id","Nombre", "Apellidos", "Telefono" , "Telefono 2", "e-mail", "Usuario","Contraseña"};

    /**
     * Constructor that initializes the list of Profesor objects.
     *
     * @param profesores List of Profesor objects to be displayed in the table.
     */
    public ModeloTablaProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    /**
     * Returns the number of rows in the table.
     *
     * @return the number of rows in the table.
     */
    @Override
    public int getRowCount() {
        return profesores.size();
    }

    /**
     * Returns the number of columns in the table.
     *
     * @return the number of columns in the table.
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Returns the name of a specific column.
     *
     * @param columnIndex the index of the column.
     * @return the name of the column at the specified index.
     */
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    /**
     * Returns the value of a specific cell in the table.
     *
     * @param rowIndex the index of the row.
     * @param columnIndex the index of the column.
     * @return the value of the cell at the specified row and column.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Profesor profesor = profesores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return profesor.getId();
            case 1:
                return profesor.getNombre();
            case 2:
                return profesor.getApellidos();
            case 3:
                return profesor.getTelefono1();
            case 4:
                return profesor.getTelefono2();
            case 5:
                return profesor.getEmail();
            case 6:
                return profesor.getNombreUsuario();
            case 7:
                return profesor.getContrasena();
            default:
                return null;
        }
    }
}
