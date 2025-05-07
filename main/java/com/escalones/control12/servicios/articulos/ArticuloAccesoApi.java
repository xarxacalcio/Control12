package com.escalones.control12.servicios.articulos;

import com.escalones.control12.modelos.Articulo;
import com.escalones.control12.modelos.ConexionApi;
import com.escalones.control12.modelos.TipoAsistencia;
import com.escalones.control12.vistas.ArticulosFrame;
import com.google.gson.Gson;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author xarxa
 */
public class ArticuloAccesoApi {

    // Método para modificar un artículo
    public static void modificarArticulo(ArticulosFrame articulosFrame) {
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
    }

    // Método para modificar un artículo en la API
    public static void modificarArticuloEnApi(Articulo articulo, ArticulosFrame articulosFrame) {
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
    }

    // Método para eliminar un artículo
    public static void eliminarArticulo(ArticulosFrame articulosFrame) {
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
    }

    // Método para guardar un artículo en la API
    public static void guardarArticuloEnApi(Articulo articulo, ArticulosFrame articulosFrame) {
        // Convertir el objeto a JSON
        try {
            Gson gson = new Gson();
            String articuloJson = gson.toJson(articulo);
            ConexionApi.conectarConApiAccion(articuloJson, ConexionApi.ARTICULO, ConexionApi.ACCION_NUEVO); // Suponiendo que tienes un método para esto
            ArticuloAccionesFrame.actualizarTablaArticulos(articulosFrame); // Actualiza la tabla de artículos
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en al alta del Artículo: " + e.getMessage());
        }
    }
    
    // Método nuevo para añadir un artículo (similar al de profesores)
    public static void nuevoArticulo(ArticulosFrame articulosFrame) {
        Articulo articulo = new Articulo();

        // Asignar valores desde los campos de la interfaz
        articulo.setNombre(articulosFrame.jTextFieldNombre.getText());
        articulo.setNumeroHoras(Integer.parseInt(articulosFrame.jTextFieldNumeroHoras.getText()));
        articulo.setPrecio(Double.parseDouble(articulosFrame.jTextFieldPrecio.getText()));
        articulo.setIva(Double.parseDouble(articulosFrame.jTextFieldIva.getText()));
        articulo.setTipoAsistencia((TipoAsistencia)articulosFrame.jComboBoxTipoAsistencia.getSelectedItem());

        // Aquí puedes agregar el código para guardar el artículo en la base de datos
        // por ejemplo, usando un servicio o gestor de datos:
        guardarArticuloEnApi(articulo, articulosFrame);

        // Mensaje de confirmación
        JOptionPane.showMessageDialog(null, "Nuevo artículo creado con éxito.");
    }

}
