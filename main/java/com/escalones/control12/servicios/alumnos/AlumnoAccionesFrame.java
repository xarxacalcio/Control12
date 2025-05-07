package com.escalones.control12.servicios.alumnos;

import com.escalones.control12.modelos.Alumno;
import com.escalones.control12.modelos.ConexionApi;
import com.escalones.control12.modelos.ModeloTablaAlumnos;
import com.escalones.control12.vistas.AlumnoFrame;
import static com.escalones.control12.vistas.AlumnoFrame.ACCIONALTA;
import static com.escalones.control12.vistas.AlumnoFrame.ACCIONMODIFICAR;
import static com.escalones.control12.vistas.AlumnoFrame.NINGUNALUMNOACTIVADO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author xarxa
 */
public class AlumnoAccionesFrame {
    
    // Modifica los textos de los botones según la acción (alta o modificar)
    public static void modificarBotonesAltaModificar(AlumnoFrame alumnoFrame) {
        if (alumnoFrame.accionAltaModificar == ACCIONALTA) {
            alumnoFrame.jButtonAnadirAlumno.setText("Añadir Alumno");
            alumnoFrame.jButtonLimpiar.setText("Limpiar Formulario");
        } else if (alumnoFrame.accionAltaModificar == ACCIONMODIFICAR) {
            alumnoFrame.jButtonAnadirAlumno.setText("Modificar Alumno");
            alumnoFrame.jButtonLimpiar.setText("Cancelar Modificación");
        }
    }

    // Borra el contenido del formulario
    public static void borrarFormulario(AlumnoFrame alumnoFrame) {
        alumnoFrame.jTextFieldNombre.setText("");
        alumnoFrame.jTextFieldApellidos.setText("");
        alumnoFrame.jTextFieldTelefono.setText("");
        alumnoFrame.jTextFieldTelefono2.setText("");
        alumnoFrame.jTextFieldEmail.setText("");
    }

    // Reinicia la acción a "alta" y desactiva cualquier alumno seleccionado
    public static void reiniciarAccionAlta(AlumnoFrame alumnoFrame) {
        alumnoFrame.accionAltaModificar = ACCIONALTA;
        alumnoFrame.idAlumnoActual = NINGUNALUMNOACTIVADO;
        modificarBotonesAltaModificar(alumnoFrame);
    }
    
    // Actualiza la tabla de alumnos con los datos obtenidos de la API
    public static void actualizarTablaAlumnos(AlumnoFrame alumnoFrame) {
        try {
            String alumnosJson = ConexionApi.conectarConApiAlumnos();
            Gson gson = new Gson();
            java.lang.reflect.Type tipoListaAlumnos = new TypeToken<ArrayList<Alumno>>() {
            }.getType();
            alumnoFrame.alumnos = gson.fromJson(alumnosJson, tipoListaAlumnos);

            ModeloTablaAlumnos modelo = new ModeloTablaAlumnos(alumnoFrame.alumnos);
            alumnoFrame.jTableAlumnos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la tabla alumnos " + e.getMessage());
        }
    }

    // Rellena el formulario con los datos del alumno seleccionado en la tabla
    public static void rellenarFormulario(AlumnoFrame alumnoFrame) {
        int f = alumnoFrame.jTableAlumnos.getSelectedRow();
        alumnoFrame.jTextFieldNombre.setText(alumnoFrame.jTableAlumnos.getValueAt(f, 1).toString());
        alumnoFrame.jTextFieldApellidos.setText(alumnoFrame.jTableAlumnos.getValueAt(f, 2).toString());
        alumnoFrame.jTextFieldTelefono.setText(alumnoFrame.jTableAlumnos.getValueAt(f, 3).toString());
        alumnoFrame.jTextFieldTelefono2.setText(alumnoFrame.jTableAlumnos.getValueAt(f, 4).toString());
        alumnoFrame.jTextFieldEmail.setText(alumnoFrame.jTableAlumnos.getValueAt(f, 5).toString());
        alumnoFrame.jDateFechaNacimiento.setDate((Date)alumnoFrame.jTableAlumnos.getValueAt(f, 6));
        alumnoFrame.jDateFechaInscripcion.setDate((Date)alumnoFrame.jTableAlumnos.getValueAt(f, 7));
    }
    
    // Filtra la tabla de alumnos según el texto ingresado en el campo de búsqueda
    public static void filtrarTablaAlumnos(AlumnoFrame alumnoFrame) {
        String cadenaBuscar = alumnoFrame.jTextFieldBuscarAlumno.getText();
        ArrayList<Alumno> alumnosFiltrados = new ArrayList();
        for (Alumno alumno : alumnoFrame.alumnos) {
            if (alumno.getNombre().toUpperCase().contains(cadenaBuscar.toUpperCase())) {
                alumnosFiltrados.add(alumno);
            }
        }
        ModeloTablaAlumnos modelo = new ModeloTablaAlumnos(alumnosFiltrados);
        alumnoFrame.jTableAlumnos.setModel(modelo);
    }
}
