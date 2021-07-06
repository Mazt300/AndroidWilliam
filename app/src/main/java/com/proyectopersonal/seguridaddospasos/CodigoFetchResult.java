package com.proyectopersonal.seguridaddospasos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CodigoFetchResult {

    @SerializedName("data")
    @Expose
    private ArrayList data;

    public ArrayList getData() {
        return data;
    }
}
