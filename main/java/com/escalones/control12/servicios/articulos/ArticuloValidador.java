package com.escalones.control12.servicios.articulos;

import com.escalones.control12.util.Validacion;
import com.escalones.control12.vistas.ArticulosFrame;

/**
 *
 * @author xarxa
 */
public class ArticuloValidador {
    private String nombre;
    private String tipoAsistencia;
    private String numeroHoras;
    private String precio;
    private String iva;

    private String errores ="";
    
    // Constructor que inicializa los campos con los valores del formulario
    public ArticuloValidador(ArticulosFrame articulosFrame){
        nombre = articulosFrame.jTextFieldNombre.getText();
        tipoAsistencia = articulosFrame.jComboBoxTipoAsistencia.getSelectedItem().toString();
        numeroHoras = articulosFrame.jTextFieldNumeroHoras.getText();
        precio =articulosFrame.jTextFieldPrecio.getText();
        iva= articulosFrame.jTextFieldIva.getText();
    }
    
    // Método que valida el formulario de artículo
    public boolean validarFormularioArticulo(){
        errores="";
        boolean requeridos = comprobarRequeridos();
        boolean numeros = comprobarNumeros();
        
        boolean condicion1 = requeridos && numeros;
        boolean condicion2 ;
        if(!condicion1){
            return condicion1;
        }
        if(condicion1){
            boolean rangos = comprobarRangos();
            condicion2=rangos;
            return condicion2;
        }
        return true;
    } 
    
    // Método que comprueba que los campos requeridos estén rellenados
    private boolean comprobarRequeridos(){
        boolean valido = true;
        if(!Validacion.estaRelleno(nombre)){
            valido=false;
            errores+="El nombre es obligatorio.\n";
        }

        if(!Validacion.estaRelleno(numeroHoras)){
            valido=false;
            errores+="El número de horas es obligatorio.\n";
        }
        if(!Validacion.estaRelleno(precio)){
            valido=false;
            errores+="El precio es obligatorio.\n";
        }
        if(!Validacion.estaRelleno(iva)){
            valido=false;
            errores+="El tipo de IVA es obligatorio.\n";
        }
        
        return valido;
    }
    
    // Método que devuelve los errores encontrados
    public String getErrores(){
        return errores;
    }

    // Método que comprueba que los campos numéricos sean válidos
    private boolean comprobarNumeros() {
         boolean valido = true;
        
        if(!Validacion.enteroValido(numeroHoras)){
            valido=false;
            errores+="El número de horas no es un número válido.\n";
        }
        if(!Validacion.floatValido(precio)){
            valido=false;
            errores+="El precio debe ser un número real válido.\n";
        }
        if(!Validacion.floatValido(iva)){
            valido=false;
            errores+="El tipo de IVA debe ser un número real válido.\n";
        }
        
        return valido;
    }
    
    // Método que comprueba que los valores numéricos estén dentro de los rangos permitidos
    public boolean comprobarRangos(){
        boolean valido = true;
        if(!Validacion.enteroMayorIgualQue(Integer.parseInt(this.numeroHoras),0)){
            valido=false;
            errores+="Las horas deben ser mayor o igual que 0.";
        }
        if(!Validacion.floatMayorIgualQue(Float.parseFloat(this.precio),0)){
            valido=false;
            errores+="El precio debe ser mayor o igual que 0.";
        }
        if(!Validacion.floatMayorIgualQue(Float.parseFloat(this.iva),0)){
            valido=false;
            errores+="El iva debe ser mayor o igual que 0.";
        }
        return valido;
    }
}
