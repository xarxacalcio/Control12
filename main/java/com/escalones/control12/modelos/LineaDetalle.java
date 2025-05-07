package com.escalones.control12.modelos;


/**
 *
 * @author xarxa
 */
public class LineaDetalle {
    private Integer id;
    private Pago pago;
    private Articulo catalogoProducto;
    private Integer unidades;
    private Double precio;

    public LineaDetalle() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Articulo getArticulo() {
        return catalogoProducto;
    }

    public void setArticulo(Articulo catalogoProducto) {
        this.catalogoProducto = catalogoProducto;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getRowCount() {
        return unidades != null ? unidades : 0;
    }
}
