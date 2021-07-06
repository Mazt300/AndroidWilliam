package com.proyectopersonal.seguridaddospasos;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCodigo {
    @GET("codigo/?limit=1")
    Call getCodigo();

}
