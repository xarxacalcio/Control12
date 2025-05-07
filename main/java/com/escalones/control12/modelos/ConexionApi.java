package com.escalones.control12.modelos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 *
 * @author xarxa
 */
public class ConexionApi {
    
    // Constantes para identificar las entidades
    public static final int PROFESOR = 0;
    public static final int ALUMNO = 1;
    public static final int ARTICULO = 2;
    public static final int PAGO = 4;

    // Constantes para identificar las acciones
    public static final int ACCION_NUEVO = 0;
    public static final int ACCION_MODIFICAR = 1;
    public static final int ACCION_ELIMINAR = 2;

    // Método para conectar con la API y obtener todos los profesores
    public static String conectarConApiProfesores() throws Exception {
        return conectarConApi("http://127.0.0.1:8000/control12api/profesor/todos");
    }
    
    // Método para conectar con la API y obtener todos los alumnos
    public static String conectarConApiAlumnos() throws Exception {
       return conectarConApi("http://127.0.0.1:8000/control12api/alumno/todos");
    }
    
  public static String buscarAlumno(Integer id) throws Exception {
       return conectarConApi("http://127.0.0.1:8000/control12api/alumno/"+id);
    } 
  
  public static String existePagoAlumno(Integer idAlumno) throws Exception{
      return conectarConApi("http://127.0.0.1:8000/control12api/pago/existe-pago/"+idAlumno); 
  }
    
    // Método para conectar con la API y obtener todos los artículos
    public static String conectarConApiArticulos() throws Exception {
        return conectarConApi("http://127.0.0.1:8000/control12api/catalogo-producto/todos");
    }
    
    // Método para conectar con la API y obtener todos los tipos de asistencia
    public static String conectarConApiTiposAsistencia() throws Exception {
        return conectarConApi("http://127.0.0.1:8000/control12api/tipoasistencia/todos");
    }
    
     // Método para conectar con la API y obtener todos los pagos
    public static String conectarConApiPagos() throws Exception {
       return conectarConApi("http://127.0.0.1:8000/control12api/pago/todos");
    }
    
    // Método para realizar una acción (nuevo, modificar, eliminar) sobre una entidad (profesor, alumno, artículo)
    public static boolean conectarConApiAccion(String json, int entidad, int accion) throws IOException {
        String urlApi = "";
        // Configurar la conexión según la entidad y la acción
        switch(entidad) {
            case PROFESOR:
                if(accion == ACCION_NUEVO) {
                    urlApi = "nuevo-profesor";
                } else if(accion == ACCION_MODIFICAR) {
                    urlApi = "modificar-profesor";
                } else if(accion == ACCION_ELIMINAR) {
                    urlApi = "eliminar-profesor";
                }
                return enviarJsonAApi(json, "http://127.0.0.1:8000/control12api/profesor/" + urlApi);
            case ALUMNO:
                if(accion == ACCION_NUEVO) {
                    urlApi = "nuevo-alumno";
                } else if(accion == ACCION_MODIFICAR) {
                    urlApi = "modificar-alumno";
                } else if(accion == ACCION_ELIMINAR) {
                    urlApi = "eliminar-alumno";
                }
                return enviarJsonAApi(json, "http://127.0.0.1:8000/control12api/alumno/" + urlApi);
            case ARTICULO:
                if(accion == ACCION_NUEVO) {
                    urlApi = "nuevo-producto";
                } else if(accion == ACCION_MODIFICAR) {
                    urlApi = "modificar-producto";
                } else if(accion == ACCION_ELIMINAR) {
                    urlApi = "eliminar-producto";
                }
                return enviarJsonAApi(json, "http://127.0.0.1:8000/control12api/catalogo-producto/" + urlApi);
                
            case PAGO:
                if(accion == ACCION_NUEVO) {
                    urlApi = "nuevo-pago";
                } else if(accion == ACCION_MODIFICAR) {
                    urlApi = "modificar-pago";
                } else if(accion == ACCION_ELIMINAR) {
                    urlApi = "eliminar-pago";
                }
                System.out.println(json);
                
                return enviarJsonAApi(json, "http://127.0.0.1:8000/control12api/pago/" + urlApi);    
        }
        return false;
    }

    // Método para enviar un JSON a la API para eliminar un profesor
    public static boolean enviarJsonAApiEliminar(int id) {
        try {
            // Configurar la conexión
            URL url = new URL("http://127.0.0.1:8000/control12api/profesor/eliminar-profesor");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setDoOutput(true);

            // Enviar el JSON en el cuerpo de la solicitud
            try (OutputStream os = conexion.getOutputStream()) {
                String json = "{\"id\":" + id + "}";
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Leer la respuesta
            int codigoRespuesta = conexion.getResponseCode();
            if (codigoRespuesta == 200 || codigoRespuesta == 201) {
                return true; // Éxito
            } else {
                System.out.println("Código de respuesta: " + codigoRespuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Error
    }

    // Método para enviar un nuevo artículo a la API
    public static boolean enviarJsonAApiNuevoArticulo(String json) {
        try {
            // Configurar la conexión
            URL url = new URL("http://127.0.0.1:8000/control12api/articulo/nuevo-articulo");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setDoOutput(true);

            // Enviar el JSON en el cuerpo de la solicitud
            try (OutputStream os = conexion.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Leer la respuesta
            int codigoRespuesta = conexion.getResponseCode();
            if (codigoRespuesta == 200 || codigoRespuesta == 201) {
                return true; // Éxito
            } else {
                System.out.println("Código de respuesta: " + codigoRespuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Error
    }

    // Método para modificar un artículo en la API
    public static boolean enviarJsonAApiModificarArticulo(String json) {
        try {
            // Configurar la conexión
            URL url = new URL("http://127.0.0.1:8000/control12api/articulo/modificar-articulo");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setDoOutput(true);

            // Enviar el JSON en el cuerpo de la solicitud
            try (OutputStream os = conexion.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Leer la respuesta
            int codigoRespuesta = conexion.getResponseCode();
            if (codigoRespuesta == 200 || codigoRespuesta == 201) {
                return true; // Éxito
            } else {
                System.out.println("Código de respuesta: " + codigoRespuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Error
    }

    // Método para eliminar un artículo en la API
    public static boolean enviarJsonAApiEliminarArticulo(int id) {
        try {
            // Configurar la conexión
            URL url = new URL("http://127.0.0.1:8000/control12api/articulo/eliminar-articulo");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setDoOutput(true);

            // Enviar el JSON en el cuerpo de la solicitud
            try (OutputStream os = conexion.getOutputStream()) {
                String json = "{\"id\":" + id + "}";
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Leer la respuesta
            int codigoRespuesta = conexion.getResponseCode();
            if (codigoRespuesta == 200 || codigoRespuesta == 201) {
                return true; // Éxito
            } else {
                System.out.println("Código de respuesta: " + codigoRespuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Error
    }

    // Método para conectar con la API y obtener una respuesta en formato JSON
    public static String conectarConApi(String urlString) throws Exception {
        StringBuilder result = new StringBuilder();
        
        // Desactivar la verificación del certificado SSL
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Desactivar la verificación del nombre del host
        HostnameVerifier allHostsValid = (hostname, session) -> true;
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

        // Configurar la conexión
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        // Verificar el código de respuesta
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        // Leer la respuesta
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output;
        while ((output = br.readLine()) != null) {
            result.append(output);
        }

        conn.disconnect();
        return result.toString();
    }

    // Método para enviar un JSON a la API
    public static boolean enviarJsonAApi(String json, String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("POST");
        conexion.setRequestProperty("Content-Type", "application/json");
        conexion.setDoOutput(true);

        // Enviar el JSON en el cuerpo de la solicitud
        try (OutputStream os = conexion.getOutputStream()) {
            byte[] input = json.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Leer la respuesta
        int codigoRespuesta = conexion.getResponseCode();
        if (codigoRespuesta == 200 || codigoRespuesta == 201) {
            return true; // Éxito
        } else {
            System.out.println("Código de respuesta: " + codigoRespuesta);
        }

        return false; // Error
    }
}
