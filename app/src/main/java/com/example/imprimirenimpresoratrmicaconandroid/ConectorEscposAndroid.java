package com.example.imprimirenimpresoratrmicaconandroid;


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class ConectorEscposAndroid {
    public static String URL_PLUGIN_POR_DEFECTO = "http://localhost:8000";
    public static int TAMANO_IMAGEN_NORMAL = 0;
    public static int TAMANO_IMAGEN_DOBLE_ANCHO = 1;
    public static int TAMANO_IMAGEN_DOBLE_ALTO = 2;
    public static int TAMANO_IMAGEN_DOBLE_ANCHO_Y_ALTO = 3;
    public static int ALINEACION_IZQUIERDA = 0;
    public static int ALINEACION_CENTRO = 1;
    public static int ALINEACION_DERECHA = 2;
    public static int RECUPERACION_QR_BAJA = 0;
    public static int RECUPERACION_QR_MEDIA = 1;
    public static int RECUPERACION_QR_ALTA = 2;
    public static int RECUPERACION_QR_MEJOR = 3;

    public ArrayList<OperacionPluginEscpos> operaciones;
    public String urlPlugin;
    public String serial;


    public ConectorEscposAndroid(String urlPlugin, String serial) {
        this.operaciones = new ArrayList<>();
        this.urlPlugin = urlPlugin;
        this.serial = serial;
    }

    public ConectorEscposAndroid(String urlPlugin) {
        this.operaciones = new ArrayList<>();
        this.urlPlugin = urlPlugin;
        this.serial = "";
    }

    public ConectorEscposAndroid() {
        this.urlPlugin = URL_PLUGIN_POR_DEFECTO;
        this.operaciones = new ArrayList<>();
        this.serial = "";
    }

    private void agregarOperacion(OperacionPluginEscpos operacion) {
        this.operaciones.add(operacion);
    }

    public ConectorEscposAndroid CargarImagenLocalEImprimir(String ruta, int tamano, int maximoAncho) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(ruta);
        argumentos.add(tamano);
        argumentos.add(maximoAncho);
        this.agregarOperacion(new OperacionPluginEscpos("CargarImagenLocalEImprimir", argumentos));
        return this;
    }

    public ConectorEscposAndroid Corte(int lineas) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(lineas);
        this.agregarOperacion(new OperacionPluginEscpos("Corte", argumentos));
        return this;
    }

    public ConectorEscposAndroid CorteParcial() {
        ArrayList<Object> argumentos = new ArrayList<>();
        this.agregarOperacion(new OperacionPluginEscpos("CorteParcial", argumentos));
        return this;
    }

    public ConectorEscposAndroid DefinirCaracterPersonalizado(String caracterRemplazoComoCadena, String matrizComoCadena) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(caracterRemplazoComoCadena);
        argumentos.add(matrizComoCadena);
        this.agregarOperacion(new OperacionPluginEscpos("DefinirCaracterPersonalizado", argumentos));
        return this;
    }

    public ConectorEscposAndroid DescargarImagenDeInternetEImprimir(String urlImagen, int tamano, int maximoAncho) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(urlImagen);
        argumentos.add(tamano);
        argumentos.add(maximoAncho);
        this.agregarOperacion(new OperacionPluginEscpos("DescargarImagenDeInternetEImprimir", argumentos));
        return this;
    }

    public ConectorEscposAndroid DeshabilitarCaracteresPersonalizados() {
        ArrayList<Object> argumentos = new ArrayList<>();
        this.agregarOperacion(new OperacionPluginEscpos("DeshabilitarCaracteresPersonalizados", argumentos));
        return this;
    }

    public ConectorEscposAndroid DeshabilitarElModoDeCaracteresChinos() {
        ArrayList<Object> argumentos = new ArrayList<>();
        this.agregarOperacion(new OperacionPluginEscpos("DeshabilitarElModoDeCaracteresChinos", argumentos));
        return this;
    }

    public ConectorEscposAndroid EscribirTexto(String texto) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(texto);
        this.agregarOperacion(new OperacionPluginEscpos("EscribirTexto", argumentos));
        return this;
    }

    public ConectorEscposAndroid EstablecerAlineacion(int alineacion) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(alineacion);
        this.agregarOperacion(new OperacionPluginEscpos("EstablecerAlineacion", argumentos));
        return this;
    }

    public ConectorEscposAndroid EstablecerEnfatizado(boolean enfatizado) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(enfatizado);
        this.agregarOperacion(new OperacionPluginEscpos("EstablecerEnfatizado", argumentos));
        return this;
    }

    public ConectorEscposAndroid EstablecerFuente(int fuente) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(fuente);
        this.agregarOperacion(new OperacionPluginEscpos("EstablecerFuente", argumentos));
        return this;
    }

    public ConectorEscposAndroid EstablecerImpresionAlReves(boolean alReves) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(alReves);
        this.agregarOperacion(new OperacionPluginEscpos("EstablecerImpresionAlReves", argumentos));
        return this;
    }

    public ConectorEscposAndroid EstablecerImpresionBlancoYNegroInversa(boolean invertir) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(invertir);
        this.agregarOperacion(new OperacionPluginEscpos("EstablecerImpresionBlancoYNegroInversa", argumentos));
        return this;
    }

    public ConectorEscposAndroid EstablecerRotacionDe90Grados(boolean rotar) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(rotar);
        this.agregarOperacion(new OperacionPluginEscpos("EstablecerRotacionDe90Grados", argumentos));
        return this;
    }

    public ConectorEscposAndroid EstablecerSubrayado(boolean subrayado) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(subrayado);
        this.agregarOperacion(new OperacionPluginEscpos("EstablecerSubrayado", argumentos));
        return this;
    }

    public ConectorEscposAndroid EstablecerTamanoFuente(int multiplicadorAncho, int multiplicadorAlto) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(multiplicadorAncho);
        argumentos.add(multiplicadorAlto);
        this.agregarOperacion(new OperacionPluginEscpos("EstablecerTamañoFuente", argumentos));
        return this;
    }

    public ConectorEscposAndroid Feed(int lineas) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(lineas);
        this.agregarOperacion(new OperacionPluginEscpos("Feed", argumentos));
        return this;
    }

    public ConectorEscposAndroid HabilitarCaracteresPersonalizados() {
        ArrayList<Object> argumentos = new ArrayList<>();
        this.agregarOperacion(new OperacionPluginEscpos("HabilitarCaracteresPersonalizados", argumentos));
        return this;
    }

    public ConectorEscposAndroid HabilitarElModoDeCaracteresChinos() {
        ArrayList<Object> argumentos = new ArrayList<>();
        this.agregarOperacion(new OperacionPluginEscpos("HabilitarElModoDeCaracteresChinos", argumentos));
        return this;
    }

    public ConectorEscposAndroid ImprimirCodigoDeBarras(String tipo, String datos, int tamanoImagen, int ancho, int alto) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(tipo);
        argumentos.add(datos);
        argumentos.add(tamanoImagen);
        argumentos.add(ancho);
        argumentos.add(alto);
        this.agregarOperacion(new OperacionPluginEscpos("ImprimirCodigoDeBarras", argumentos));
        return this;
    }


    public ConectorEscposAndroid ImprimirImagenEnBase64(String imagenCodificadaEnBase64, int tamano, int maximoAncho) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(imagenCodificadaEnBase64);
        argumentos.add(tamano);
        argumentos.add(maximoAncho);
        this.agregarOperacion(new OperacionPluginEscpos("ImprimirImagenEnBase64", argumentos));
        return this;
    }

    public ConectorEscposAndroid Iniciar() {
        ArrayList<Object> argumentos = new ArrayList<>();
        this.agregarOperacion(new OperacionPluginEscpos("Iniciar", argumentos));
        return this;
    }

    public ConectorEscposAndroid Pulso(int pin, int tiempoEncendido, int tiempoApagado) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(pin);
        argumentos.add(tiempoEncendido);
        argumentos.add(tiempoApagado);
        this.agregarOperacion(new OperacionPluginEscpos("Pulso", argumentos));
        return this;
    }

    public ConectorEscposAndroid TextoSegunPaginaDeCodigos(int numeroPagina, String pagina, String texto) {
        ArrayList<Object> argumentos = new ArrayList<>();
        argumentos.add(numeroPagina);
        argumentos.add(pagina);
        argumentos.add(texto);
        this.agregarOperacion(new OperacionPluginEscpos("TextoSegunPaginaDeCodigos", argumentos));
        return this;
    }


    public JSONObject getJson(String macImpresora) throws Exception, IOException, InterruptedException {
        JSONArray operacionesComoJson = new JSONArray();
        for (OperacionPluginEscpos op : this.operaciones) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nombre", op.nombre);
            jsonObject.put("argumentos", new JSONArray(op.argumentos));
            operacionesComoJson.put(jsonObject);
        }

        JSONObject impresionConNombreComoJson = new JSONObject();
        impresionConNombreComoJson.put("impresora", macImpresora);
        impresionConNombreComoJson.put("serial", this.serial);
        impresionConNombreComoJson.put("operaciones", operacionesComoJson);
        return impresionConNombreComoJson;
    }

    public boolean imprimirEn(String macImpresora, Context context) throws Exception, IOException, InterruptedException {
        ImpresoraConOperaciones impresionConNombre = new ImpresoraConOperaciones(this.operaciones, macImpresora, this.serial);
        String postEndpoint = this.urlPlugin + "/imprimir";
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://www.google.com";
        JSONArray jsonArray = new JSONArray();
        for (OperacionPluginEscpos op : this.operaciones) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(op.nombre, op.argumentos);
            jsonArray.put(jsonObject);
        }
        return false;

        /*
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        textView.setText("Response is: " + response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
        String respuesta = "a";
        if (respuesta.equals("true\n")) {
            return true;
        } else {
            throw new Exception("petición ok pero error en el servidor: " + respuesta);
        }
        */

    }

    public static String[] obtenerImpresoras(String urlPlugin) throws InterruptedException, IOException {
        return new String[]{""};
    }

    public static String[] obtenerImpresoras() throws InterruptedException, IOException {
        return obtenerImpresoras(URL_PLUGIN_POR_DEFECTO);
    }
}
