package com.escalones.control12.modelos;

import java.util.Date;

/**
 * Clase Alumno
 * Representa a un alumno con sus atributos básicos.
 * 
 * @author xarxa
 */
/**
 * Representa un alumno con sus datos personales y de contacto.
 */
public class Alumno {

    /**
     * Identificador único del alumno.
     */
    private Integer id;

    /**
     * Nombre del alumno.
     */
    private String nombre;

    /**
     * Apellidos del alumno.
     */
    private String apellidos;

    /**
     * Primer número de teléfono del alumno.
     */
    private String telefono1;

    /**
     * Segundo número de teléfono del alumno.
     */
    private String telefono2;

    /**
     * Correo electrónico del alumno.
     */
    private String email;

    /**
     * Nombre de usuario del alumno.
     */
    private String nombreUsuario;

    /**
     * Contraseña del alumno.
     */
    private String contrasena;

    /**
     * Foto del alumno.
     */
    private String foto;

    /**
     * Fecha de nacimiento del alumno.
     */
    private Date fechaNacimiento;

    /**
     * Fecha de alta del alumno en el sistema.
     */
    private Date fechaAlta;

    /**
     * Constructor vacío.
     */
    public Alumno() {}

    /**
     * Obtiene el identificador del alumno.
     * 
     * @return el identificador del alumno.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador del alumno.
     * 
     * @param id el identificador del alumno.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del alumno.
     * 
     * @return el nombre del alumno.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del alumno.
     * 
     * @param nombre el nombre del alumno.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del alumno.
     * 
     * @return los apellidos del alumno.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del alumno.
     * 
     * @param apellidos los apellidos del alumno.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el primer número de teléfono del alumno.
     * 
     * @return el primer número de teléfono del alumno.
     */
    public String getTelefono1() {
        return telefono1;
    }

    /**
     * Establece el primer número de teléfono del alumno.
     * 
     * @param telefono1 el primer número de teléfono del alumno.
     */
    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    /**
     * Obtiene el segundo número de teléfono del alumno.
     * 
     * @return el segundo número de teléfono del alumno.
     */
    public String getTelefono2() {
        return telefono2;
    }

    /**
     * Establece el segundo número de teléfono del alumno.
     * 
     * @param telefono2 el segundo número de teléfono del alumno.
     */
    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    /**
     * Obtiene el correo electrónico del alumno.
     * 
     * @return el correo electrónico del alumno.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del alumno.
     * 
     * @param email el correo electrónico del alumno.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el nombre de usuario del alumno.
     * 
     * @return el nombre de usuario del alumno.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario del alumno.
     * 
     * @param nombreUsuario el nombre de usuario del alumno.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene la contraseña del alumno.
     * 
     * @return la contraseña del alumno.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del alumno.
     * 
     * @param contrasena la contraseña del alumno.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene la foto del alumno.
     * 
     * @return la foto del alumno.
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Establece la foto del alumno.
     * 
     * @param foto la foto del alumno.
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Obtiene la fecha de nacimiento del alumno.
     * 
     * @return la fecha de nacimiento del alumno.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del alumno.
     * 
     * @param fechaNacimiento la fecha de nacimiento del alumno.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la fecha de alta del alumno en el sistema.
     * 
     * @return la fecha de alta del alumno en el sistema.
     */
    public Date getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Establece la fecha de alta del alumno en el sistema.
     * 
     * @param fechaAlta la fecha de alta del alumno en el sistema.
     */
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
