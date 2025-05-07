package com.escalones.control12.modelos;

import java.util.Date;

/**
 *
 * @author xarxa
 */

public class PagoSimple {
    private Integer id;
    private Date fecha;
    private String nombre;
    private Double importe;
    private Integer unidades;
    private Double precioUnitario;
    private Articulo articulo;

    // Constructor
    public PagoSimple() {}

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
        if (articulo != null) {
            this.nombre = articulo.getNombre();
        }
    }

    // Método para calcular el subtotal
    public Double getSubtotal() {
        if (unidades != null && precioUnitario != null) {
            return unidades * precioUnitario;
        }
        return 0.0;
    }
}