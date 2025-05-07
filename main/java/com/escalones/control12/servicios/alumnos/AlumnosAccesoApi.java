package com.escalones.control12.servicios.alumnos;

import com.escalones.control12.modelos.Alumno;
import com.escalones.control12.modelos.ConexionApi;
import com.escalones.control12.modelos.Profesor;
import com.escalones.control12.servicios.profesores.ProfesorAccionesFrame;
import com.escalones.control12.util.DateSerializer;
import com.escalones.control12.vistas.AlumnoFrame;
import com.escalones.control12.vistas.ProfesorFrame;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author xarxa
 */
public class AlumnosAccesoApi {
    
    // Método para modificar un alumno a partir de los datos en la interfaz AlumnoFrame
    public static void modificarAlumno(AlumnoFrame alumnoFrame) {
        Alumno alumno = new Alumno();
        alumno.setId(alumnoFrame.idAlumnoActual);
        alumno.setNombre(alumnoFrame.jTextFieldNombre.getText());
        alumno.setApellidos(alumnoFrame.jTextFieldApellidos.getText());
        alumno.setTelefono1(alumnoFrame.jTextFieldTelefono.getText());
        alumno.setTelefono2(alumnoFrame.jTextFieldTelefono2.getText());
        alumno.setEmail(alumnoFrame.jTextFieldEmail.getText());

        modificarAlumnoEnApi(alumno, alumnoFrame);
        
    }

    // Método para modificar un alumno en la API
    public static void modificarAlumnoEnApi(Alumno alumno, AlumnoFrame alumnoFrame) {
        try {
            Gson gson = new Gson();
            String alumnoJson = gson.toJson(alumno);
            ConexionApi.conectarConApiAccion(alumnoJson, ConexionApi.ALUMNO, ConexionApi.ACCION_MODIFICAR);
            AlumnoAccionesFrame.actualizarTablaAlumnos(alumnoFrame);
            AlumnoAccionesFrame.reiniciarAccionAlta(alumnoFrame);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el Alumno: " + ex.getMessage());
        }
    }

    // Método para eliminar un alumno a partir de los datos en la interfaz AlumnoFrame
    public static void eliminarAlumno(AlumnoFrame alumnoFrame) {
        
        try {
            Gson gson = new Gson();
            Alumno alumno = new Alumno();
            alumno.setId(alumnoFrame.idAlumnoActual);
            String alumnoJson = gson.toJson(alumno);
            ConexionApi.conectarConApiAccion(alumnoJson, ConexionApi.ALUMNO, ConexionApi.ACCION_ELIMINAR);
            AlumnoAccionesFrame.actualizarTablaAlumnos(alumnoFrame);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el Alumno: " + e.getMessage());
        }
    }
    
    // Método para guardar un nuevo alumno en la API
    public static void guardarAlumnoEnApi(Alumno alumno, AlumnoFrame alumnoFrame) {
        try {
            Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer()).create();
            String alumnoJson = gson.toJson(alumno);
            ConexionApi.conectarConApiAccion(alumnoJson, ConexionApi.ALUMNO, ConexionApi.ACCION_NUEVO);
            AlumnoAccionesFrame.actualizarTablaAlumnos(alumnoFrame);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en al alta del Alumno: " + e.getMessage());
        }
    }
    
    // Método para crear un nuevo alumno a partir de los datos en la interfaz AlumnoFrame
    public static void nuevoAlumno(AlumnoFrame alumnoFrame) {
        Alumno alumno = new Alumno();

        // Asignar valores desde los campos de la interfaz
        alumno.setNombre(alumnoFrame.jTextFieldNombre.getText());
        alumno.setApellidos(alumnoFrame.jTextFieldApellidos.getText());
        alumno.setTelefono1(alumnoFrame.jTextFieldTelefono.getText());
        alumno.setTelefono2(alumnoFrame.jTextFieldTelefono2.getText());
        alumno.setEmail(alumnoFrame.jTextFieldEmail.getText());
        alumno.setFechaNacimiento(alumnoFrame.jDateFechaNacimiento.getDate());
        alumno.setFechaAlta(alumnoFrame.jDateFechaInscripcion.getDate());

        // Guardar al alumno en la API
        guardarAlumnoEnApi(alumno, alumnoFrame);

        
    }
    
    public static Alumno buscarAlumno(Integer idAlumno){
        try {
            System.out.println(ConexionApi.buscarAlumno(idAlumno));
            return null;
            
        } catch (Exception ex) {
            return null;
        }
    }
    
    public static Boolean existePagoAlumno(Integer idAlumno){
        try {
            System.out.println(ConexionApi.existePagoAlumno(idAlumno));
            String respuesta = ConexionApi.existePagoAlumno(idAlumno);
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(respuesta, JsonObject.class);
            return jsonObject.get("existePago").getAsBoolean();

        } catch (Exception ex) {
        
            return null;
        }
        
    }
    
    
}
