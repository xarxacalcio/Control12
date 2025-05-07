package com.escalones.control12.servicios.articulos;

import com.escalones.control12.modelos.Articulo;
import com.escalones.control12.modelos.ConexionApi;
import com.escalones.control12.modelos.ModeloTablaArticulos;
import com.escalones.control12.modelos.TipoAsistencia;
import com.escalones.control12.vistas.ArticulosFrame;
import static com.escalones.control12.vistas.ArticulosFrame.ACCIONALTA;
import static com.escalones.control12.vistas.ArticulosFrame.ACCIONMODIFICAR;
import static com.escalones.control12.vistas.ArticulosFrame.NINGUNARTICULOACTIVADO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author xarxa
 */
public class ArticuloAccionesFrame {
    
    // Modifica el texto de los botones de alta y modificar según la acción actual
    public static void modificarBotonesAltaModificar(ArticulosFrame articulosFrame) {
        if (articulosFrame.accionAltaModificar == ACCIONALTA) {
            articulosFrame.jButtonAnadirArticulo.setText("Añadir Artículo");
        } else if (articulosFrame.accionAltaModificar == ACCIONMODIFICAR) {
            articulosFrame.jButtonAnadirArticulo.setText("Modificar Artículo");
        }
    }
    
    // Borra el contenido del formulario de artículos
    public static void borrarFormulario(ArticulosFrame articulosFrame) {
        articulosFrame.jTextFieldNombre.setText("");
        articulosFrame.jTextFieldNumeroHoras.setText("");
        articulosFrame.jTextFieldPrecio.setText("");
        articulosFrame.jTextFieldIva.setText("");
    }
    
    // Reinicia la acción de alta de artículos
    public static void reiniciarAccionAlta(ArticulosFrame articulosFrame) {
        articulosFrame.idArticuloActual = NINGUNARTICULOACTIVADO; // Reinicia el ID del artículo
        articulosFrame.accionAltaModificar = ACCIONALTA;
        modificarBotonesAltaModificar(articulosFrame);
    }
    
    // Actualiza la tabla de artículos con los datos obtenidos de la API
    public static void actualizarTablaArticulos(ArticulosFrame articulosFrame) {
        try {
            String articulosJson = ConexionApi.conectarConApiArticulos(); // Método que obtiene los artículos de la API

            Gson gson = new Gson();

            java.lang.reflect.Type tipoListaArticulos = new TypeToken<ArrayList<Articulo>>() {
            }.getType();
            articulosFrame.articulos = gson.fromJson(articulosJson, tipoListaArticulos);

            ModeloTablaArticulos modelo = new ModeloTablaArticulos(articulosFrame.articulos);
            articulosFrame.jTableArticulos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la tabla de artículos: " + e.getMessage());
        }
    }
    
    // Rellena el formulario con los datos del artículo seleccionado en la tabla
    public static void rellenarFormulario(ArticulosFrame articulosFrame) {
        int f = articulosFrame.jTableArticulos.getSelectedRow(); // Obtener el artículo seleccionado

        // Rellenar los campos del formulario con los datos del artículo
        articulosFrame.jTextFieldNombre.setText(articulosFrame.jTableArticulos.getValueAt(f, 1).toString());
        TipoAsistencia tipoAsistencia = (TipoAsistencia) articulosFrame.jTableArticulos.getValueAt(f, 2);
        articulosFrame.jComboBoxTipoAsistencia.setSelectedIndex(tipoAsistencia.getId() - 1);
        articulosFrame.jTextFieldNumeroHoras.setText(articulosFrame.jTableArticulos.getValueAt(f, 3).toString());
        articulosFrame.jTextFieldPrecio.setText(articulosFrame.jTableArticulos.getValueAt(f, 4).toString());
        articulosFrame.jTextFieldIva.setText(articulosFrame.jTableArticulos.getValueAt(f, 5).toString());
    }
    
    // Filtra la tabla de artículos según el texto de búsqueda
    public static void filtrarTablaArticulos(ArticulosFrame articulosFrame) {
        String searchText = articulosFrame.jTextFieldBuscarArticulo.getText().toLowerCase();
        ArrayList<Articulo> articulosFiltrados = new ArrayList<>();

        // Filtra la lista de artículos que coinciden con el texto de búsqueda
        for (Articulo articulo : articulosFrame.articulos) {
            if (articulo.getNombre().toLowerCase().contains(searchText)) {
                articulosFiltrados.add(articulo);
            }
        }

        // Actualiza la tabla con los artículos filtrados
        actualizarTablaConArticulos(articulosFiltrados, articulosFrame);
    }
    
    // Actualiza la tabla con una lista de artículos filtrados
    public static void actualizarTablaConArticulos(ArrayList<Articulo> articulosFiltrados, ArticulosFrame articulosFrame) {
        ModeloTablaArticulos modelo = new ModeloTablaArticulos(articulosFiltrados);
        articulosFrame.jTableArticulos.setModel(modelo);
    }

    // Actualiza el comboBox de tipos de asistencia con los datos obtenidos de la API
    public static void actualizarTiposAsistencia(ArticulosFrame articulosFrame) {
        try {
            String tipoAsistenciasJson = ConexionApi.conectarConApiTiposAsistencia(); // Método que obtiene los tipos de asistencia de la API
            Gson gson = new Gson();

            java.lang.reflect.Type tipoListaTiposAsistencia = new TypeToken<ArrayList<TipoAsistencia>>() {
            }.getType();
            articulosFrame.tiposAsistencia = gson.fromJson(tipoAsistenciasJson, tipoListaTiposAsistencia);

            articulosFrame.jComboBoxTipoAsistencia.removeAllItems();
            for (TipoAsistencia tipoAsistencia : articulosFrame.tiposAsistencia) {
                // Agregar nuevos elementos
                articulosFrame.jComboBoxTipoAsistencia.addItem(tipoAsistencia);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido acceder a la tabla de tipos de asistencia: " + e.getMessage());
        }
    }
}
