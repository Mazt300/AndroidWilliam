package com.proyectopersonal.seguridaddospasos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.GsonBuilder;
import com.proyectopersonal.seguridaddospasos.Codigo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText codigo1,codigo2,codigo3,codigo4,codigo5,codigo6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ObtenerCodigo();
    }

    private void ObtenerCodigo()
    {
        codigo1 = (EditText)findViewById(R.id.txt1);
        codigo2 = (EditText)findViewById(R.id.txt2);
        codigo3 = (EditText)findViewById(R.id.txt3);
        codigo4 = (EditText)findViewById(R.id.txt4);
        codigo5 = (EditText)findViewById(R.id.txt5);
        codigo6 = (EditText)findViewById(R.id.txt6);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.188:4000/api/usuariotoken/60e4bc84ba19a2064c952015")
                .addConverterFactory(GsonConverterFactory.create(
                        new GsonBuilder().serializeNulls().create()
                ))
                .build();
        ApiCodigo ApiCodigo = retrofit.create(ApiCodigo.class);
        Call call = ApiCodigo.getCodigo();

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    int[] Codigo;
                    List<String> list = new ArrayList<String>();
                    list = (ArrayList)response.body();
                    if (list.size() > 0)
                    {
                        codigo1.setText(list.get(0).toString());
                        codigo2.setText(list.get(1).toString());
                        codigo3.setText(list.get(2).toString());
                        codigo4.setText(list.get(3).toString());
                        codigo5.setText(list.get(4).toString());
                        codigo6.setText(list.get(5).toString());
                    }

                } else {
                    Log.d("Error", "Algo malo");
                    return;
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("Error", t.toString());
            }
        });
    }
}