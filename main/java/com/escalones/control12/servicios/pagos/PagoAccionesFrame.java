package com.escalones.control12.servicios.pagos;

import com.escalones.control12.modelos.Alumno;
import com.escalones.control12.modelos.Articulo;
import com.escalones.control12.modelos.ConexionApi;
import com.escalones.control12.modelos.ModeloTablaAlumnos;
import com.escalones.control12.modelos.ModeloTablaAlumnosPagos;
import com.escalones.control12.modelos.ModeloTablaArticulos;
import com.escalones.control12.modelos.ModeloTablaPagos;
import com.escalones.control12.modelos.Pago;
import com.escalones.control12.modelos.PagoSimple;
import com.escalones.control12.vistas.PagosFrame;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xarxa
 */
public class PagoAccionesFrame {
    
    // Método para actualizar la tabla de alumnos en la interfaz de pagos
    public static void actualizarTablaAlumnos(PagosFrame pagosFrame) {
        try {
            // Conectar con la API para obtener los alumnos
            String alumnosJson = ConexionApi.conectarConApiAlumnos(); 

            Gson gson = new Gson();

            // Convertir el JSON de alumnos a una lista de objetos Alumno
            java.lang.reflect.Type tipoListaAlumnos = new TypeToken<ArrayList<Alumno>>() {
            }.getType();
            pagosFrame.alumnos = gson.fromJson(alumnosJson, tipoListaAlumnos);

            // Actualizar el modelo de la tabla con los alumnos obtenidos
            ModeloTablaAlumnosPagos modelo = new ModeloTablaAlumnosPagos(pagosFrame.alumnos);
            pagosFrame.jTableAlumnosPagos.setModel(modelo);
        } catch(Exception e) {
            // Mostrar mensaje de error si no se puede acceder a la tabla de alumnos
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la tabla de alumnos: " + e.getMessage());
        }
    }

    // Método para filtrar la tabla de alumnos según el texto de búsqueda
    public static void filtrarTablaAlumnos(PagosFrame pagosFrame) {
        String searchText = pagosFrame.jTextFieldBuscarAlumnoPagos.getText().toLowerCase();
        ArrayList<Alumno> alumnosFiltrados = new ArrayList<>();

        // Filtrar la lista de alumnos que coinciden con el texto de búsqueda
        for (Alumno alumno : pagosFrame.alumnos) {
            if (alumno.getNombre().toLowerCase().contains(searchText)) {
                alumnosFiltrados.add(alumno);
            }
        }

        // Actualizar la tabla con los alumnos filtrados
        ModeloTablaAlumnosPagos modelo = new ModeloTablaAlumnosPagos(alumnosFiltrados);
        pagosFrame.jTableAlumnosPagos.setModel(modelo);
    }

    // Método para actualizar la tabla con una lista filtrada de alumnos
    public static void actualizarTablaConAlumnos(ArrayList<Alumno> alumnosFiltrados, PagosFrame alumnosFrame) {
        ModeloTablaAlumnosPagos modelo = new ModeloTablaAlumnosPagos(alumnosFiltrados);
        alumnosFrame.jTableAlumnosPagos.setModel(modelo);
    }

    // Método para actualizar la tabla de artículos en la interfaz de pagos
    public static void actualizarTablaArticulos(PagosFrame pagosFrame) {
        try {
            // Conectar con la API para obtener los artículos
            String articulosJson = ConexionApi.conectarConApiArticulos(); 

            Gson gson = new Gson();

            // Convertir el JSON de artículos a una lista de objetos Articulo
            java.lang.reflect.Type tipoListaArticulos = new TypeToken<ArrayList<Articulo>>() {
            }.getType();
            pagosFrame.articulos = gson.fromJson(articulosJson, tipoListaArticulos);

            // Actualizar el modelo de la tabla con los artículos obtenidos
            ModeloTablaArticulos modelo = new ModeloTablaArticulos(pagosFrame.articulos);
            pagosFrame.jTableArticulosPagos.setModel(modelo);
        } catch(Exception e) {
            // Mostrar mensaje de error si no se puede acceder a la tabla de artículos
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la tabla de artículos: " + e.getMessage());
        }
    }

    // Método para filtrar la tabla de artículos según el texto de búsqueda
    public static void filtrarTablaArticulos(PagosFrame pagosFrame) {
        String searchText = pagosFrame.jTextFieldBuscarArticuloPagos.getText().toLowerCase();
        ArrayList<Articulo> articulosFiltrados = new ArrayList<>();

        // Filtrar la lista de artículos que coinciden con el texto de búsqueda
        for (Articulo articulo : pagosFrame.articulos) {
            if (articulo.getNombre().toLowerCase().contains(searchText)) {
                articulosFiltrados.add(articulo);
            }
        }

        // Actualizar la tabla con los artículos filtrados
        ModeloTablaArticulos modelo = new ModeloTablaArticulos(articulosFiltrados);
        pagosFrame.jTableArticulosPagos.setModel(modelo);
    }

    // Método para actualizar la tabla con una lista filtrada de artículos
    public static void anadirProductos(PagosFrame pagosFrame) {
    if (pagosFrame.jTableAlumnosPagos.getSelectedRow() != -1) {
        int selectedRow = pagosFrame.jTableAlumnosPagos.getSelectedRow();
        DefaultTableModel modeloDatosPago = (DefaultTableModel) pagosFrame.jTableDatosPago.getModel();

        // Obtener el ID del alumno de la primera columna (si es necesario para jTableDatosPago)
        Object idAlumno = pagosFrame.jTableAlumnosPagos.getValueAt(selectedRow, 0);

        // *** LÍNEA CRÍTICA: Obtener el objeto Alumno de tu lista 'alumnos' ***
        // Asumiendo que tienes una lista de alumnos llamada 'alumnos' en PagosFrame
        // y que está sincronizada con jTableAlumnosPagos
        if (pagosFrame.alumnos != null && selectedRow < pagosFrame.alumnos.size()) {
            Alumno alumnoSeleccionadoTabla = pagosFrame.alumnos.get(selectedRow);
            pagosFrame.alumnoParaTicket = alumnoSeleccionadoTabla; // Guardar el alumno para el ticket
            System.out.println("Alumno guardado para el ticket: " + pagosFrame.alumnoParaTicket); // Para depuración
        } else {
            JOptionPane.showMessageDialog(pagosFrame, "Error al obtener la información del alumno.");
            return; // Salir del método si no se puede obtener el alumno
        }

        // Obtener índice de forma de pago seleccionada
        int formaPagoIndex = pagosFrame.jComboBoxFormaPago.getSelectedIndex();

        // Obtener fecha y hora del JDateChooser
        Date fechaPago = pagosFrame.jDateFechaPago.getDate();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formatoFecha.format(fechaPago);
        String hora = pagosFrame.jSpinnerHora.getValue()+":"+pagosFrame.jSpinnerMinuto.getValue();

        // Añadir fila con los datos a jTableDatosPago
        modeloDatosPago.addRow(new Object[]{
                idAlumno,
                formaPagoIndex,
                fecha,
                hora
        });

        pagosFrame.jButtonSeleccionarAlumno.setEnabled(false);
    } else {
        // Mostrar mensaje de error si no se ha seleccionado un alumno
        JOptionPane.showMessageDialog(pagosFrame, "Debe seleccionar el alumno");
    }
}

    // Método para añadir un producto a la tabla de línea de detalle
    public static void anadirUnProducto(PagosFrame pagosFrame) {
        if (pagosFrame.jTableArticulosPagos.getSelectedRow() != -1) {
            DefaultTableModel modelo = (DefaultTableModel) pagosFrame.jTableLineaDetalle.getModel();
            
            // Obtener el ID del artículo y el precio de la tabla de artículos
            int idArticulo = (int) pagosFrame.jTableArticulosPagos.getValueAt(pagosFrame.jTableArticulosPagos.getSelectedRow(), 0);
            double precio = (double) pagosFrame.jTableArticulosPagos.getValueAt(
                pagosFrame.jTableArticulosPagos.getSelectedRow(), 
                pagosFrame.jTableArticulosPagos.getColumnCount() - 2
            );
            
            // Obtener unidades del spinner
            int unidades = (int) pagosFrame.jSpinnerUnidades.getValue();
            
            // Añadir fila con los datos
            modelo.addRow(new Object[]{
                idArticulo,
                unidades,
                precio
            });

            // Obtener el IVA de la última columna
            double iva = (double) pagosFrame.jTableArticulosPagos.getValueAt(
                pagosFrame.jTableArticulosPagos.getSelectedRow(),
                pagosFrame.jTableArticulosPagos.getColumnCount() - 1
            );
            
            // Calcular subtotal con IVA
            double subtotal = unidades * precio;
            double subtotalConIva = subtotal + (subtotal * iva / 100);
            
            // Obtener total actual y sumar nuevo subtotal
            double totalActual = 0;
            try {
                totalActual = Double.parseDouble(pagosFrame.jTextFieldTotal.getText());
            } catch (NumberFormatException e) {
                // Si el campo está vacío o no es un número válido, se mantiene en 0
            }
            
            double nuevoTotal = totalActual + subtotalConIva;
            
            // Actualizar campo total
            pagosFrame.jTextFieldTotal.setText(String.format("%.2f", nuevoTotal));
            
        } else {
            // Mostrar mensaje de error si no se ha seleccionado un artículo
            JOptionPane.showMessageDialog(pagosFrame, "Debe seleccionar un artículo");
        }
    }

    // Método para calcular el cambio a devolver
    public static void calcularCambio(PagosFrame pagosFrame) {
        try {
            double total = Double.parseDouble(pagosFrame.jTextFieldTotal.getText().replace(",", "."));
            double importePagado = Double.parseDouble(pagosFrame.jTextFieldEntregado.getText().replace(",", "."));
            double cambio = importePagado - total;
            pagosFrame.jTextFieldCambio.setText(String.format("%.2f", cambio));

            // Lógica para cambiar el color de fondo del campo Entregado
            if (importePagado < total) {
                pagosFrame.jTextFieldEntregado.setBackground(new java.awt.Color(255, 153, 153)); // Rojo claro
            } else {
                pagosFrame.jTextFieldEntregado.setBackground(new java.awt.Color(204, 255, 204)); // Verde claro (color original)
            }

        } catch (NumberFormatException e) {
            // Si hay error en la conversión, también poner el fondo en rojo
            pagosFrame.jTextFieldEntregado.setBackground(new java.awt.Color(255, 153, 153));
        }
    }

    // Método para calcular el descuento aplicado
    public static void calcularDescuento(PagosFrame pagosFrame) {
        try {
            double total = Double.parseDouble(pagosFrame.jTextFieldTotal.getText().replace(",", "."));
            double descuentoPorcentaje = 0.0;
            double descuentoContado = 0.0;
            double descuentoAplicado = 0.0;

            // Obtener el descuento por porcentaje
            String descuentoPorcentajeStr = pagosFrame.jTextFieldDescuentoPorcentaje.getText().trim();
            try {
                descuentoPorcentaje = Double.parseDouble(descuentoPorcentajeStr.replace("%", "").replace(",", "."));
            } catch (NumberFormatException e) {
                // Si no es un número válido, se mantiene en 0
            }

            // Obtener el descuento en contado
            String descuentoContadoStr = pagosFrame.jTextFieldDescuentoCantidad.getText().trim();
            try {
                descuentoContado = Double.parseDouble(descuentoContadoStr.replace(",", "."));
            } catch (NumberFormatException e) {
                // Si no es un número válido, se mantiene en 0
            }

            // Calcular el descuento total
            if (descuentoPorcentaje > 0) {
                descuentoAplicado += total * (descuentoPorcentaje / 100);
            }

            if (descuentoContado > 0) {
                descuentoAplicado += descuentoContado;
            }

            double totalConDescuento = total - descuentoAplicado;

            // Asegurarse de que el total con descuento no sea negativo
            if (totalConDescuento < 0) {
                totalConDescuento = 0.0;
            }

            // Actualizar total con descuento
            pagosFrame.jTextFieldTotal.setText(String.format("%.2f", totalConDescuento));

        } catch (NumberFormatException e) {
            // No se realiza ninguna modificación si hay error en la conversión del total
            JOptionPane.showMessageDialog(pagosFrame, "El total no es un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para iniciar un nuevo pago
    public static void nuevoPago(PagosFrame pagosFrame) {
        // Establecer fecha actual
        pagosFrame.jDateFechaPago.setDate(new Date());
        
        // Vaciar cuadros de búsqueda
        pagosFrame.jTextFieldBuscarAlumnoPagos.setText("");
        pagosFrame.jTextFieldBuscarArticuloPagos.setText("");
        
        // Deseleccionar tablas
        pagosFrame.jTableAlumnosPagos.clearSelection();
        pagosFrame.jTableArticulosPagos.clearSelection();
        
        // Limpiar tabla de detalles y pagos
        DefaultTableModel modeloDetalles = (DefaultTableModel) pagosFrame.jTableLineaDetalle.getModel();
        modeloDetalles.setRowCount(0);
        DefaultTableModel modeloPagos = (DefaultTableModel) pagosFrame.jTableDatosPago.getModel();
        modeloPagos.setRowCount(0);
        
        // Vaciar campos de texto
        pagosFrame.jTextFieldTotal.setText("");
        pagosFrame.jTextFieldDescuentoCantidad.setText("");
        pagosFrame.jTextFieldEntregado.setText("");
        pagosFrame.jTextFieldCambio.setText("");
        pagosFrame.jTextAreaObservaciones.setText("");
        
        // Restablecer spinner a 1
        pagosFrame.jSpinnerUnidades.setValue(1);
    }
    
    public static void actualizarSpinnerHora(PagosFrame pagosFrame){
    Calendar calendario = Calendar.getInstance();
    int hora = calendario.get(Calendar.HOUR_OF_DAY);
    int minutos = calendario.get(Calendar.MINUTE);
    
    pagosFrame.jSpinnerHora.setValue(hora);
    pagosFrame.jSpinnerMinuto.setValue(minutos);
    }

    public static void actualizarTablaHistoricoPagos(PagosFrame pagosFrame) {
        try {
            String pagosJson = ConexionApi.conectarConApiPagos();
            Gson gson = new Gson();
            java.lang.reflect.Type tipoListaPagos = new TypeToken<ArrayList<PagoSimple>>() {
            }.getType();
            pagosFrame.pagosSimples = gson.fromJson(pagosJson, tipoListaPagos);

            ModeloTablaPagos modelo = new ModeloTablaPagos(pagosFrame.pagosSimples);
            pagosFrame.jTableHistoricoPagos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla pagos " + e.getMessage());
        }
    }

}
