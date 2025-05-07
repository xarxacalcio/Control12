package com.escalones.control12.servicios.alumnos;

import com.escalones.control12.util.Validacion;
import com.escalones.control12.vistas.AlumnoFrame;
import java.util.Date;

/**
 *
 * @author xarxa
 */
public class AlumnoValidador {
    
    private String nombre;
    private String apellidos;
    private String telefono1;
    private String telefono2;
    private String email;
    private Date fechaNacimiento;
    private Date fechaAlta;
    
    private String errores ="";
    
    // Constructor que inicializa los campos con los valores del formulario
    public AlumnoValidador(AlumnoFrame alumnoFrame){
        nombre = alumnoFrame.jTextFieldNombre.getText();
        apellidos = alumnoFrame.jTextFieldApellidos.getText();
        telefono1 = alumnoFrame.jTextFieldTelefono.getText();
        telefono2 =alumnoFrame.jTextFieldTelefono2.getText();
        email= alumnoFrame.jTextFieldEmail.getText();
        fechaNacimiento = alumnoFrame.jDateFechaNacimiento.getDate();
        fechaAlta = alumnoFrame.jDateFechaInscripcion.getDate();
    }
    
    // Método que valida el formulario del alumno
    public boolean validarFormularioAlumno(){
        errores="";
        boolean requeridos = comprobarRequeridos();
        boolean formato = comprobarFormato();
        return requeridos && formato;
    } 
    
    // Método que comprueba si los campos requeridos están rellenados
    private boolean comprobarRequeridos(){
        boolean valido = true;
        if(!Validacion.estaRelleno(nombre)){
            valido=false;
            errores+="El nombre es obligatorio.\n";
        }
        if(!Validacion.estaRelleno(apellidos)){
            valido=false;
            errores+="Los apellidos son obligatorios.\n";
        }
        if(!Validacion.estaRelleno(telefono1)){
            valido=false;
            errores+="El teléfono principal es obligatorio.\n";
        }
        if(!Validacion.estaRelleno(email)){
            valido=false;
            errores+="El email es obligatorio.\n";
        }
        if(!Validacion.estaRelleno(fechaNacimiento)){
            valido=false;
            errores+="La fecha de nacimiento es obligatoria.\n";
        }
        if(!Validacion.estaRelleno(fechaAlta)){
            valido=false;
            errores+="La fecha de alta es obligatoria.\n";
        }
        return valido;
    }
    
    // Método que comprueba si los campos tienen el formato correcto
    private boolean comprobarFormato() {
        boolean valido = true;
        String patronEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String patronTelefono = "^[0-9]{9}$";
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
        return valido;
    }
    
    // Método que devuelve los errores encontrados durante la validación
    public String getErrores(){
        return errores;
    }
}
