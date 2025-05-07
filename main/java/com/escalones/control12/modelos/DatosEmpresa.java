package com.escalones.control12.modelos;

/**
 * Clase DatosEmpresa
 * Representa los datos básicos de una empresa.
 * 
 * @author xarxa
 */
public class DatosEmpresa {

    /**
     * Identificador único de la empresa.
     */
    private Integer id;

    /**
     * Nombre de la empresa.
     */
    private String nombre;

    /**
     * CIF (Código de Identificación Fiscal) de la empresa.
     */
    private String cif;

    /**
     * Dirección física de la empresa.
     */
    private String direccion;

    /**
     * Código postal de la empresa.
     */
    private String cp;

    /**
     * Ciudad donde se ubica la empresa.
     */
    private String ciudad;

    /**
     * Primer número de teléfono de la empresa.
     */
    private String telefono1;

    /**
     * Segundo número de teléfono de la empresa.
     */
    private String telefono2;

    /**
     * Correo electrónico de la empresa.
     */
    private String email;

    /**
     * Sitio web de la empresa.
     */
    private String web;

    /**
     * Constructor vacío.
     */
    public DatosEmpresa() {}

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
