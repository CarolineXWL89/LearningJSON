package com.example.caroline.learningjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DataMuseAPI.baseURL) //put the baseURL there in interface so we don't have to remember it
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instantiate an API
        DataMuseAPI api = retrofit.create(DataMuseAPI.class); //parameter is name of interface we used

        Call<List<WordObject>> call = api.getSoundsLike("success");

        call.enqueue(new Callback<List<WordObject>>() {
            @Override
            public void onResponse(Call<List<WordObject>> call, Response<List<WordObject>> response) {

            }

            @Override
            public void onFailure(Call<List<WordObject>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
