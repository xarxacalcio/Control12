package com.escalones.control12.modelos;

/**
 *
 * @author xarxa
 */
/**
 * Representa un artículo con sus propiedades y métodos asociados.
 * 
 * <p>Esta clase incluye información sobre el identificador, nombre, número de horas,
 * precio, IVA y tipo de asistencia del artículo.</p>
 * 
 * @author [Tu Nombre]
 */
public class Articulo {

    /**
     * Identificador único del artículo.
     */
    private Integer id;
    
    /**
     * Nombre del artículo.
     */
    private String nombre;
    
    /**
     * Número de horas asociadas al artículo.
     */
    private Integer numeroHoras;
    
    /**
     * Precio del artículo.
     */
    private Double precio;
    
    /**
     * IVA aplicado al artículo.
     */
    private Double iva;
    
    /**
     * Tipo de asistencia asociada al artículo.
     */
    private TipoAsistencia tipoAsistencia;

    /**
     * Constructor vacío.
     */
    public Articulo() {}

    /**
     * Constructor con parámetros.
     * 
     * @param id Identificador único del artículo.
     * @param nombre Nombre del artículo.
     * @param numeroHoras Número de horas asociadas al artículo.
     * @param precio Precio del artículo.
     * @param iva IVA aplicado al artículo.
     */
    public Articulo(Integer id, String nombre, Integer numeroHoras, Double precio, Double iva) {
        this.id = id;
        this.nombre = nombre;
        this.numeroHoras = numeroHoras;
        this.precio = precio;
        this.iva = iva;
    }

    /**
     * Obtiene el identificador del artículo.
     * 
     * @return El identificador del artículo.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador del artículo.
     * 
     * @param id El identificador del artículo.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del artículo.
     * 
     * @return El nombre del artículo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del artículo.
     * 
     * @param nombre El nombre del artículo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de horas del artículo.
     * 
     * @return El número de horas del artículo.
     */
    public Integer getNumeroHoras() {
        return numeroHoras;
    }

    /**
     * Establece el número de horas del artículo.
     * 
     * @param numeroHoras El número de horas del artículo.
     */
    public void setNumeroHoras(Integer numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    /**
     * Obtiene el precio del artículo.
     * 
     * @return El precio del artículo.
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del artículo.
     * 
     * @param precio El precio del artículo.
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el IVA del artículo.
     * 
     * @return El IVA del artículo.
     */
    public Double getIva() {
        return iva;
    }

    /**
     * Establece el IVA del artículo.
     * 
     * @param iva El IVA del artículo.
     */
    public void setIva(Double iva) {
        this.iva = iva;
    }
    
    /**
     * Obtiene el tipo de asistencia del artículo.
     * 
     * @return El tipo de asistencia del artículo.
     */
    public TipoAsistencia getTipoAsistencia() {
        return tipoAsistencia;
    }

    /**
     * Establece el tipo de asistencia del artículo.
     * 
     * @param tipoAsistencia El tipo de asistencia del artículo.
     */
    public void setTipoAsistencia(TipoAsistencia tipoAsistencia) {
        this.tipoAsistencia = tipoAsistencia;
    }
}
