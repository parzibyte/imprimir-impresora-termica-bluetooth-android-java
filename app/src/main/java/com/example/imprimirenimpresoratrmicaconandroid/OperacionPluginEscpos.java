package com.example.imprimirenimpresoratrmicaconandroid;


import java.util.ArrayList;

public class OperacionPluginEscpos {
    public String nombre;
    public ArrayList<Object> argumentos;

    public OperacionPluginEscpos(String nombre, ArrayList<Object> argumentos) {
        this.nombre = nombre;
        this.argumentos = argumentos;
    }


}
