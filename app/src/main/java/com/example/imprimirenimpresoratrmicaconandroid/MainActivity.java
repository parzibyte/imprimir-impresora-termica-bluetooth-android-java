package com.example.imprimirenimpresoratrmicaconandroid;

import android.os.Bundle;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;


import com.example.imprimirenimpresoratrmicaconandroid.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        final String UrlPlugin = "http://localhost:8000";
        final EditText editTextMensaje = (EditText) findViewById(R.id.editTextMensaje);
        final EditText editTextSerial = (EditText) findViewById(R.id.editTextSerial);
        final EditText editTextMac = (EditText) findViewById(R.id.editTextMac);
        RequestQueue queue = Volley.newRequestQueue(this);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String serial = editTextSerial.getText().toString();
                String mac = editTextMac.getText().toString();
                if (mac.isEmpty()) {
                    Snackbar.make(view, "Escribe la MAC", Snackbar.LENGTH_LONG).show();
                    return;
                }
                ConectorEscposAndroid conectorEscposAndroid = new ConectorEscposAndroid(ConectorEscposAndroid.URL_PLUGIN_POR_DEFECTO, serial);
                conectorEscposAndroid
                        .Iniciar()
                        .EscribirTexto(editTextMensaje.getText().toString())
                        .Feed(1)
                        .EscribirTexto("Proudly brought to you by Parzibyte\n");
                String cuerpo = "";
                try {
                    cuerpo = conectorEscposAndroid.getJson(mac).toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String finalCuerpo = cuerpo;
                StringRequest peticionImprimir = new StringRequest(Request.Method.POST, UrlPlugin + "/imprimir",
                        response -> Snackbar.make(view, "Respuesta: " + response, Snackbar.LENGTH_LONG).show(),
                        error -> {
                            Snackbar.make(view, "Error imprimiendo: " + error.getMessage(), Snackbar.LENGTH_LONG).show();
                            error.printStackTrace();
                        }) {
                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8";
                    }

                    @Override
                    public byte[] getBody() {
                        return finalCuerpo.getBytes(StandardCharsets.UTF_8);
                    }

                    @Override
                    protected Response<String> parseNetworkResponse(NetworkResponse response) {
                        int mStatusCode = response.statusCode;
                        Log.d("PLUGIN", String.valueOf(mStatusCode));
                        Log.d("PLUGIN", "Aquí");
                        return super.parseNetworkResponse(response);
                    }

                };

                queue.add(peticionImprimir);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}