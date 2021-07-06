package com.proyectopersonal.seguridaddospasos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Codigo {
    private int id;
    private Date FechaRegistro;
    @SerializedName("UsuarioId")
    @Expose
    private String UsuarioId;
    @SerializedName("Codigo")
    @Expose
    private  int Codigo;

    public int getId() {
        return id;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public String getUsuarioId() {
        return UsuarioId;
    }

    public int getCodigo() {
        return Codigo;
    }
}
