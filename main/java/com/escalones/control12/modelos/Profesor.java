package com.escalones.control12.modelos;

/**
 *
 * @author xarxa
 */
/**
 * Clase que representa a un profesor.
 * Contiene información personal y de contacto del profesor.
 */
public class Profesor {

    /**
     * Identificador único del profesor.
     */
    private Integer id;
    
    /**
     * Nombre del profesor.
     */
    private String nombre;
    
    /**
     * Apellidos del profesor.
     */
    private String apellidos;
    
    /**
     * Primer número de teléfono del profesor.
     */
    private String telefono1;
    
    /**
     * Segundo número de teléfono del profesor.
     */
    private String telefono2;
    
    /**
     * Correo electrónico del profesor.
     */
    private String email;
    
    /**
     * Nombre de usuario del profesor.
     */
    private String nombreUsuario;
    
    /**
     * Contraseña del profesor.
     */
    private String contrasena;
    
    /**
     * Foto del profesor.
     */
    private String foto;
    
    /**
     * Constructor vacío.
     */
    public Profesor() {}

    /**
     * Obtiene el identificador del profesor.
     * 
     * @return el identificador del profesor
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador del profesor.
     * 
     * @param id el identificador del profesor
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del profesor.
     * 
     * @return el nombre del profesor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del profesor.
     * 
     * @param nombre el nombre del profesor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del profesor.
     * 
     * @return los apellidos del profesor
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del profesor.
     * 
     * @param apellidos los apellidos del profesor
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el primer número de teléfono del profesor.
     * 
     * @return el primer número de teléfono del profesor
     */
    public String getTelefono1() {
        return telefono1;
    }

    /**
     * Establece el primer número de teléfono del profesor.
     * 
     * @param telefono1 el primer número de teléfono del profesor
     */
    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    /**
     * Obtiene el segundo número de teléfono del profesor.
     * 
     * @return el segundo número de teléfono del profesor
     */
    public String getTelefono2() {
        return telefono2;
    }

    /**
     * Establece el segundo número de teléfono del profesor.
     * 
     * @param telefono2 el segundo número de teléfono del profesor
     */
    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    /**
     * Obtiene el correo electrónico del profesor.
     * 
     * @return el correo electrónico del profesor
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del profesor.
     * 
     * @param email el correo electrónico del profesor
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el nombre de usuario del profesor.
     * 
     * @return el nombre de usuario del profesor
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario del profesor.
     * 
     * @param nombreUsuario el nombre de usuario del profesor
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene la contraseña del profesor.
     * 
     * @return la contraseña del profesor
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del profesor.
     * 
     * @param contrasena la contraseña del profesor
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene la foto del profesor.
     * 
     * @return la foto del profesor
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Establece la foto del profesor.
     * 
     * @param foto la foto del profesor
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }
}
