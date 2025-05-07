package com.escalones.control12.servicios.pagos;



import com.escalones.control12.modelos.Alumno;
import com.escalones.control12.modelos.ConexionApi;
import com.escalones.control12.modelos.DatosEmpresa;
import com.escalones.control12.modelos.Pago;
import com.escalones.control12.vistas.PagosFrame;
import com.google.gson.Gson;
import java.io.IOException;
import javax.swing.JOptionPane;
import com.escalones.control12.modelos.TipoPago;
import java.sql.Time;
import java.util.Calendar;
import com.escalones.control12.modelos.Articulo;
import com.escalones.control12.modelos.LineaDetalle;

import java.util.ArrayList;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 *
 * @author xarxa
 */
public class PagoAccesoApi {

    // Método para modificar un artículo
    /*public static void modificarPago(ArticulosFrame articulosFrame) {
        Articulo articulo = new Articulo();
        articulo.setId(articulosFrame.idArticuloActual); // Asumiendo que tienes un ID para el artículo seleccionado

        // Asignar valores desde los campos de la interfaz
        articulo.setNombre(articulosFrame.jTextFieldNombre.getText());
        articulo.setTipoAsistencia((TipoAsistencia)articulosFrame.jComboBoxTipoAsistencia.getSelectedItem());
        articulo.setNumeroHoras(Integer.parseInt(articulosFrame.jTextFieldNumeroHoras.getText()));
        articulo.setPrecio(Double.parseDouble(articulosFrame.jTextFieldPrecio.getText()));
        articulo.setIva(Double.parseDouble(articulosFrame.jTextFieldIva.getText()));
        
        // Modificar el artículo en la API
        modificarArticuloEnApi(articulo, articulosFrame);

        // Mensaje de confirmación
        JOptionPane.showMessageDialog(null, "Artículo modificado con éxito.");
    }*/

    // Método para modificar un artículo en la API
    /*public static void modificarPagoEnApi(Articulo articulo, ArticulosFrame articulosFrame) {
        try {
            // Convertir el objeto a JSON
            Gson gson = new Gson();
            String articuloJson = gson.toJson(articulo);
            ConexionApi.conectarConApiAccion(articuloJson, ConexionApi.ARTICULO, ConexionApi.ACCION_MODIFICAR); // Suponiendo que tienes un método para esto
            ArticuloAccionesFrame.actualizarTablaArticulos(articulosFrame);
            ArticuloAccionesFrame.reiniciarAccionAlta(articulosFrame); // Restablece los botones a la acción de "Alta"
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el articulo: " + ex.getMessage());
        }
    }*/

    // Método para eliminar un artículo
    /*public static void eliminarPago(ArticulosFrame articulosFrame) {
        try {
            Gson gson = new Gson();
            Articulo articulo = new Articulo();
            articulo.setId(articulosFrame.idArticuloActual);
            String articuloJson = gson.toJson(articulo);
            ConexionApi.conectarConApiAccion(articuloJson, ConexionApi.ARTICULO, ConexionApi.ACCION_ELIMINAR);
            ArticuloAccionesFrame.actualizarTablaArticulos(articulosFrame);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el Artículo: " + e.getMessage());
        }
    }*/

    // Método para guardar un artículo en la API
    public static void guardarPagoEnApi(Pago pago, PagosFrame pagosFrame) {
        // Convertir el objeto a JSON
        try {
    Gson gson = new Gson();
    // Si timeConvertido es un objeto de la clase TimeConvertido
    String timeJson = gson.toJson(pago.getHora());
            System.out.println(timeJson);
    // Ahora puedes usar timeJson como necesites
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Error en la conversión: " + e.getMessage());
}
        try {
            Gson gson = new Gson();
            String pagoJson = gson.toJson(pago);
            ConexionApi.conectarConApiAccion(pagoJson, ConexionApi.PAGO, ConexionApi.ACCION_NUEVO); 
            //actualizar pantalla pagos
            PagoAccionesFrame.nuevoPago(pagosFrame);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en al alta Pago: " + e.getMessage());
        }
    }
    
    // Método nuevo para añadir un artículo (similar al de profesores)
    public static void nuevoPago(PagosFrame pagosFrame) {
        Pago pago = new Pago();

        Alumno alumno = new Alumno();

        Integer valor = (Integer) pagosFrame.jTableAlumnosPagos.getValueAt(pagosFrame.jTableAlumnosPagos.getSelectedRow(), 0);
        alumno.setId(valor);
        
        DatosEmpresa datosEmpresa = new DatosEmpresa();
        datosEmpresa.setId(1);
        
        TipoPago tipoPago = new TipoPago();
        tipoPago.setId(pagosFrame.jComboBoxFormaPago.getSelectedIndex()+1);
        
        pago.setAlumno(alumno);
        pago.setDatosEmpresa(datosEmpresa);
        pago.setTipoPago(tipoPago);
        pago.setFecha(pagosFrame.jDateFechaPago.getDate());


        
        pago.setHora(pagosFrame.jSpinnerHora.getValue()+":"+pagosFrame.jSpinnerMinuto.getValue());
        
        double total = Double.parseDouble(pagosFrame.jTextFieldTotal.getText().replace(",", "."));
        pago.setImporte(total);

        
        for(int i = 0; i < pagosFrame.jTableLineaDetalle.getRowCount(); i++) {
            LineaDetalle lineaDetalle = new LineaDetalle();
            
            // Obtener los valores de la tabla
            Integer idProducto = (Integer) pagosFrame.jTableLineaDetalle.getValueAt(i, 0);
            Integer unidades = (Integer) pagosFrame.jTableLineaDetalle.getValueAt(i, 1);
            Double precio = (Double) pagosFrame.jTableLineaDetalle.getValueAt(i, 2);
            
            // Crear el artículo
            Articulo articulo = new Articulo();
            articulo.setId(idProducto);
            
            // Configurar la línea de detalle
            lineaDetalle.setArticulo(articulo);
            lineaDetalle.setUnidades(unidades);
            lineaDetalle.setPrecio(precio);
            
            pago.addLineaDetalle(lineaDetalle);
        }


        // Aquí puedes agregar el código para guardar el artículo en la base de datos
        // por ejemplo, usando un servicio o gestor de datos:
        guardarPagoEnApi(pago, pagosFrame);

        // Mensaje de confirmación
       
    }


}




