package com.escalones.control12.modelos;
import com.escalones.control12.modelos.LineaDetalle;
import com.escalones.control12.modelos.TipoPago;
import com.escalones.control12.modelos.DatosEmpresa;
import com.escalones.control12.modelos.Alumno;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author xarxa
 */
public class Pago {
    

    private Integer id;
    private Date fecha;
    private String hora;
    private Alumno alumno;
    private TipoPago tipoPago;
    private DatosEmpresa datosEmpresa;
    private List<LineaDetalle> lineaDetalles;
    private Double importe;

    public Pago() {
        this.lineaDetalles = new ArrayList<>();
    }

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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public DatosEmpresa getDatosEmpresa() {
        return datosEmpresa;
    }

    public void setDatosEmpresa(DatosEmpresa datosEmpresa) {
        this.datosEmpresa = datosEmpresa;
    }

    public List<LineaDetalle> getLineaDetalles() {
        return lineaDetalles;
    }

    public void addLineaDetalle(LineaDetalle lineaDetalle) {
        if (!this.lineaDetalles.contains(lineaDetalle)) {
            this.lineaDetalles.add(lineaDetalle);
            lineaDetalle.setPago(null);
        }
    }

    public void removeLineaDetalle(LineaDetalle lineaDetalle) {
        if (this.lineaDetalles.remove(lineaDetalle)) {
            if (lineaDetalle.getPago() == this) {
                lineaDetalle.setPago(null);
            }
        }
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
    
    
}
