package com.escalones.control12.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que implementa JsonSerializer para serializar objetos Date a formato JSON.
 * Utiliza SimpleDateFormat para formatear la fecha en el formato "yyyy-MM-dd".
 * 
 * @autor xarxa
 */
public class DateSerializer implements JsonSerializer<Date> {

    // Formato de fecha utilizado para la serialización
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Método que serializa un objeto Date a su representación JSON.
     * 
     * @param date El objeto Date a serializar.
     * @param type El tipo del objeto que se está serializando.
     * @param jsc El contexto de serialización JSON.
     * @return Un JsonElement que representa la fecha serializada.
     */
    @Override
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsc) {
        // Serializa la fecha formateada como un elemento JSON
        return jsc.serialize(dateFormat.format(date));
    }
}
