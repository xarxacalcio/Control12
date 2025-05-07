package com.escalones.control12.servicios.profesores;

import com.escalones.control12.modelos.ConexionApi;
import com.escalones.control12.modelos.ModeloTablaProfesores;
import com.escalones.control12.modelos.Profesor;
import com.escalones.control12.vistas.ProfesorFrame;
import static com.escalones.control12.vistas.ProfesorFrame.ACCIONALTA;
import static com.escalones.control12.vistas.ProfesorFrame.ACCIONMODIFICAR;
import static com.escalones.control12.vistas.ProfesorFrame.NINGUNPROFESORACTIVADO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @autor xarxa
 */
public class ProfesorAccionesFrame {
    
    // Método para modificar los textos de los botones según la acción (alta o modificar)
    public static void modificarBotonesAltaModificar(ProfesorFrame profesorFrame) {
        if (profesorFrame.accionAltaModificar == ACCIONALTA) {
            profesorFrame.jButtonAnadirProfesor.setText("Añadir Profesor");
            profesorFrame.jButtonLimpiar.setText("Limpiar Formulario");
        } else if (profesorFrame.accionAltaModificar == ACCIONMODIFICAR) {
            profesorFrame.jButtonAnadirProfesor.setText("Modificar Profesor");
            profesorFrame.jButtonLimpiar.setText("Cancelar Modificación");
        }
    }
    
    // Método para borrar el contenido del formulario
    public static void borrarFormulario(ProfesorFrame profesorFrame) {
        profesorFrame.jTextFieldNombre.setText("");
        profesorFrame.jTextFieldApellidos.setText("");
        profesorFrame.jTextFieldTelefono1.setText("");
        profesorFrame.jTextFieldTelefono2.setText("");
        profesorFrame.jTextFieldEmail.setText("");
        profesorFrame.jTextFieldUsuario.setText("");
        profesorFrame.jTextFieldContrasena.setText("");
    }
        
    // Método para reiniciar la acción a "alta" y desactivar cualquier profesor seleccionado
    public static void reiniciarAccionAlta(ProfesorFrame profesorFrame) {
        profesorFrame.accionAltaModificar = ACCIONALTA;
        profesorFrame.idProfesorActual = NINGUNPROFESORACTIVADO;
        modificarBotonesAltaModificar(profesorFrame);
    }
        
    // Método para actualizar la tabla de profesores desde la API
    public static void actualizarTablaProfesores(ProfesorFrame profesorFrame) {
        try {
            String profesoresJson = ConexionApi.conectarConApiProfesores();
            Gson gson = new Gson();

            java.lang.reflect.Type tipoListaProfesores = new TypeToken<ArrayList<Profesor>>() {
            }.getType();
            profesorFrame.profesores = gson.fromJson(profesoresJson, tipoListaProfesores);

            ModeloTablaProfesores modelo = new ModeloTablaProfesores(profesorFrame.profesores);
            profesorFrame.jTableProfesores.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla profesores: " + e.getMessage());
        }
    }
        
    // Método para filtrar la tabla de profesores según el texto de búsqueda
    public static void filtrarTablaProfesores(ProfesorFrame profesorFrame) {
        String cadenaBuscar = profesorFrame.jTextFieldBuscarProfesor.getText();
        ArrayList<Profesor> profesoresFiltrados = new ArrayList();
        for (Profesor profesor : profesorFrame.profesores) {
            if (profesor.getNombre().toUpperCase().contains(cadenaBuscar.toUpperCase())) {
                profesoresFiltrados.add(profesor);
            }
        }
        ModeloTablaProfesores modelo = new ModeloTablaProfesores(profesoresFiltrados);
        profesorFrame.jTableProfesores.setModel(modelo);
    }

    // Método para rellenar el formulario con los datos del profesor seleccionado en la tabla
    public static void rellenarFormulario(ProfesorFrame profesorFrame) {
        int f = profesorFrame.jTableProfesores.getSelectedRow();

        profesorFrame.jTextFieldNombre.setText(profesorFrame.jTableProfesores.getValueAt(f, 1).toString());
        profesorFrame.jTextFieldApellidos.setText(profesorFrame.jTableProfesores.getValueAt(f, 2).toString());
        profesorFrame.jTextFieldTelefono1.setText(profesorFrame.jTableProfesores.getValueAt(f, 3).toString());
        profesorFrame.jTextFieldTelefono2.setText(profesorFrame.jTableProfesores.getValueAt(f, 4).toString());
        profesorFrame.jTextFieldEmail.setText(profesorFrame.jTableProfesores.getValueAt(f, 5).toString());
        profesorFrame.jTextFieldUsuario.setText(profesorFrame.jTableProfesores.getValueAt(f, 6).toString());
        profesorFrame.jTextFieldContrasena.setText(profesorFrame.jTableProfesores.getValueAt(f, 7).toString());
    }   
}
