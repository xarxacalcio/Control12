package com.escalones.control12.servicios.profesores;

import com.escalones.control12.modelos.ConexionApi;
import com.escalones.control12.modelos.Profesor;
import com.escalones.control12.vistas.ProfesorFrame;
import com.google.gson.Gson;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author xarxa
 */
public class ProfesorAccesoApi {
    
    // Método para crear un nuevo profesor
    public static void nuevoProfesor(ProfesorFrame profesorFrame) {
        Profesor profesor = new Profesor();

        // Asignar valores desde los campos de la interfaz
        profesor.setNombre(profesorFrame.jTextFieldNombre.getText());
        profesor.setApellidos(profesorFrame.jTextFieldApellidos.getText());
        profesor.setTelefono1(profesorFrame.jTextFieldTelefono1.getText());
        profesor.setTelefono2(profesorFrame.jTextFieldTelefono2.getText());
        profesor.setEmail(profesorFrame.jTextFieldEmail.getText());
        profesor.setNombreUsuario(profesorFrame.jTextFieldUsuario.getText());
        profesor.setContrasena(profesorFrame.jTextFieldContrasena.getText());
        profesor.setFoto("no-imagen");

        // Guardar el profesor en la API
        guardarProfesorEnApi(profesor, profesorFrame);
    }
    
    // Método para modificar un profesor existente
    public static void modificarProfesor(ProfesorFrame profesorFrame) {
        Profesor profesor = new Profesor();
        profesor.setId(profesorFrame.idProfesorActual);
        
        // Asignar valores desde los campos de la interfaz
        profesor.setNombre(profesorFrame.jTextFieldNombre.getText());
        profesor.setApellidos(profesorFrame.jTextFieldApellidos.getText());
        profesor.setTelefono1(profesorFrame.jTextFieldTelefono1.getText());
        profesor.setTelefono2(profesorFrame.jTextFieldTelefono2.getText());
        profesor.setEmail(profesorFrame.jTextFieldEmail.getText());
        profesor.setNombreUsuario(profesorFrame.jTextFieldUsuario.getText());
        profesor.setContrasena(profesorFrame.jTextFieldContrasena.getText());
        profesor.setFoto("no-imagen");

        // Modificar el profesor en la API
        modificarProfesorEnApi(profesor, profesorFrame);
    }
    
    // Método para modificar un profesor en la API
    public static void modificarProfesorEnApi(Profesor profesor, ProfesorFrame profesorFrame) {
        try {
            // Convertir el objeto a JSON
            Gson gson = new Gson();
            String profesorJson = gson.toJson(profesor);
            ConexionApi.conectarConApiAccion(profesorJson, ConexionApi.PROFESOR, ConexionApi.ACCION_MODIFICAR);
            ProfesorAccionesFrame.actualizarTablaProfesores(profesorFrame);
            ProfesorAccionesFrame.reiniciarAccionAlta(profesorFrame);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el profesor: " + ex.getMessage());
        }
    }
    
    // Método para eliminar un profesor
    public static void eliminarProfesor(ProfesorFrame profesorFrame) {
        try {
            Gson gson = new Gson();
            Profesor profesor = new Profesor();
            profesor.setId(profesorFrame.idProfesorActual);
            String profesorJson = gson.toJson(profesor);
            ConexionApi.conectarConApiAccion(profesorJson, ConexionApi.PROFESOR, ConexionApi.ACCION_ELIMINAR);
            ProfesorAccionesFrame.actualizarTablaProfesores(profesorFrame);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el Profesor: " + e.getMessage());
        }
    }
    
    // Método para guardar un profesor en la API
    public static void guardarProfesorEnApi(Profesor profesor, ProfesorFrame profesorFrame) {
        try {
            // Convertir el objeto a JSON
            Gson gson = new Gson();
            String profesorJson = gson.toJson(profesor);
            ConexionApi.conectarConApiAccion(profesorJson, ConexionApi.PROFESOR, ConexionApi.ACCION_NUEVO);
            ProfesorAccionesFrame.actualizarTablaProfesores(profesorFrame);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error en al alta del Profesor: " + e.getMessage());
        }
    }
}
