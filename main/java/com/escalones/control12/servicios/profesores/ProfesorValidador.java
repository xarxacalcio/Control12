package com.escalones.control12.servicios.profesores;

import com.escalones.control12.util.Validacion;
import com.escalones.control12.vistas.ProfesorFrame;
import java.util.Date;

/**
 *
 * @author xarxa
 */
public class ProfesorValidador {
    private String nombre;
    private String apellidos;
    private String telefono1;
    private String telefono2;
    private String email;
    private String usuario;
    private String password;
    
    private String errores = "";
    
    // Constructor que inicializa los campos con los valores del formulario
    public ProfesorValidador(ProfesorFrame profesorFrame) {
        nombre = profesorFrame.jTextFieldNombre.getText();
        apellidos = profesorFrame.jTextFieldApellidos.getText();
        telefono1 = profesorFrame.jTextFieldTelefono1.getText();
        telefono2 = profesorFrame.jTextFieldTelefono2.getText();
        email = profesorFrame.jTextFieldEmail.getText();
        usuario = profesorFrame.jTextFieldUsuario.getText();
        password = profesorFrame.jTextFieldContrasena.getText();
    }
    
    // Método que valida el formulario del profesor
    public boolean validarFormularioProfesor() {
        errores = "";
        boolean requeridos = comprobarRequeridos();
        boolean formato = comprobarFormato();
        return requeridos && formato;
    }
    
    // Método que comprueba que los campos requeridos están rellenos
    private boolean comprobarRequeridos() {
        boolean valido = true;
        if(!Validacion.estaRelleno(nombre)) {
            valido = false;
            errores += "El nombre es obligatorio.\n";
        }
        if(!Validacion.estaRelleno(apellidos)) {
            valido = false;
            errores += "Los apellidos son obligatorios.\n";
        }
        if(!Validacion.estaRelleno(telefono1)) {
            valido = false;
            errores += "El teléfono principal es obligatorio.\n";
        }
        if(!Validacion.estaRelleno(email)) {
            valido = false;
            errores += "El email es obligatorio.\n";
        }
        if(!Validacion.estaRelleno(usuario)) {
            valido = false;
            errores += "El usuario es obligatorio.\n";
        }
        if(!Validacion.estaRelleno(password)) {
            valido = false;
            errores += "La contraseña es obligatoria.\n";
        }
        return valido;
    }
    
    // Método que comprueba que los campos tienen el formato correcto
    private boolean comprobarFormato() {
        boolean valido = true;
        String patronEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String patronTelefono = "^[0-9]{9}$";
        String patronUsuario = "^[A-Za-z0-9]{4,}$";  // Mínimo 4 caracteres alfanuméricos
        String patronPassword = "^.{6,}$";  // Mínimo 6 caracteres cualquiera
        
        if (!Validacion.cumpleExpresionRegular(email, patronEmail)) {
            valido = false;
            errores += "El formato del email no es válido.\n";
        }
        if (!Validacion.cumpleExpresionRegular(telefono1, patronTelefono)) {
            valido = false;
            errores += "El formato del teléfono principal no es válido.\n";
        }
        if (Validacion.estaRelleno(telefono2) && !Validacion.cumpleExpresionRegular(telefono2, patronTelefono)) {
            valido = false;
            errores += "El formato del teléfono secundario no es válido.\n";
        }
        if (!Validacion.cumpleExpresionRegular(usuario, patronUsuario)) {
            valido = false;
            errores += "El usuario debe tener al menos 4 caracteres alfanuméricos.\n";
        }
        if (!Validacion.cumpleExpresionRegular(password, patronPassword)) {
            valido = false;
            errores += "La contraseña debe tener al menos 6 caracteres.\n";
        }
        return valido;
    }
    
    // Método que devuelve los errores encontrados durante la validación
    public String getErrores() {
        return errores;
    }
}
