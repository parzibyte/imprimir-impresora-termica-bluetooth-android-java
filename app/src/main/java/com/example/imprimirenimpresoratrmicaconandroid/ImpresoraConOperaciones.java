package com.example.imprimirenimpresoratrmicaconandroid;

import java.util.ArrayList;

public class ImpresoraConOperaciones {
    public ArrayList<OperacionPluginEscpos> operaciones;
    public String impresora;
    public String serial;

    public ImpresoraConOperaciones(ArrayList<OperacionPluginEscpos> operaciones, String impresora, String serial) {
        this.operaciones = operaciones;
        this.impresora = impresora;
        this.serial = serial;
    }
}
