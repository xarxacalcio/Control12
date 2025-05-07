package com.escalones.control12.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.List;

// Clase que extiende AbstractTableModel para manejar una tabla de artículos
/**
 * ModeloTablaArticulos es una clase que extiende AbstractTableModel y se utiliza para 
 * representar una lista de artículos en una tabla.
 */
public class ModeloTablaArticulos extends AbstractTableModel {
    // Lista de artículos que se mostrarán en la tabla
    private final List<Articulo> articulos;
    // Nombres de las columnas de la tabla
    private final String[] columnNames = {"ID", "Nombre", "Tipo de Asistencia", "Número de Horas", "Precio", "IVA"};

    /**
     * Constructor que inicializa la lista de artículos.
     *
     * @param articulos Lista de artículos que se mostrarán en la tabla.
     */
    public ModeloTablaArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    /**
     * Método que devuelve el número de filas en la tabla.
     *
     * @return Número de filas en la tabla.
     */
    @Override
    public int getRowCount() {
        return articulos.size();
    }

    /**
     * Método que devuelve el número de columnas en la tabla.
     *
     * @return Número de columnas en la tabla.
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Método que devuelve el nombre de una columna específica.
     *
     * @param columnIndex Índice de la columna.
     * @return Nombre de la columna.
     */
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    /**
     * Método que devuelve el valor de una celda específica en la tabla.
     *
     * @param rowIndex Índice de la fila.
     * @param columnIndex Índice de la columna.
     * @return Valor de la celda en la posición especificada.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Obtiene el artículo en la fila especificada
        Articulo articulo = articulos.get(rowIndex);
        // Devuelve el valor correspondiente según la columna especificada
        switch (columnIndex) {
            case 0:
                return articulo.getId();
            case 1:
                return articulo.getNombre();
            case 2:
                return articulo.getTipoAsistencia();
            case 3:
                return articulo.getNumeroHoras();
            case 4:
                return articulo.getPrecio();
            case 5:
                return articulo.getIva();
            default:
                return null;
        }
    }
}
