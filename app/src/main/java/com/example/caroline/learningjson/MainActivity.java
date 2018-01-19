package com.example.caroline.learningjson;

import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private WordAdapter wordAdapter;
    private List<WordObject> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wire the recycler view
        recyclerView = findViewById(R.id.recyclerView);
        //create a layout manager for the recyclerview
        layoutManager = new LinearLayoutManager(this);
        //set the layout manager to the recyclerview
        recyclerView.setLayoutManager(layoutManager);
        //set the default animator to the recyclerview
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //create the adapter
        wordAdapter = new WordAdapter(this, words);
        //set the adapter
        recyclerView.setAdapter(wordAdapter);

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
                //List<WordObject> words = response.body();
                //Log.d("IT WORKED", words.toString());
                /*TODO wrie a ListView
                TODO create an adapter with the words
                TODO set the adapter to the ListView*/

                words.clear();
                words.addAll(response.body());
                wordAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<WordObject>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
