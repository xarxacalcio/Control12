package com.escalones.control12.modelos;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * ModeloTablaPagos es una clase que extiende AbstractTableModel y se utiliza para 
 * representar una tabla de pagos con información de facturas, alumnos y ventas.
 */
public class ModeloTablaPagos extends AbstractTableModel {
    // Lista de pagos
    private final List<PagoSimple> pagosSimples;
    // Nombres de las columnas de la tabla
    private final String[] columnNames = {"Nº Factura", "Alumno", "Venta", "Importe", "Fecha"};

    /**
     * Constructor que recibe una lista de pagos.
     *
     * @param pagos Lista de objetos Pago que se mostrarán en la tabla.
     */
    public ModeloTablaPagos(List<PagoSimple> pagos) {
        this.pagosSimples = pagos;
    }

    @Override
    public int getRowCount() {
        return pagosSimples.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PagoSimple pagoSimple = pagosSimples.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pagoSimple.getId();
            case 1:
                return pagoSimple.getNombre();
            case 2:
                return pagoSimple.getFecha();
            case 3:
                return pagoSimple.getImporte();
            case 4:
                return "";
            default:
                return null;
        }
    }
}
