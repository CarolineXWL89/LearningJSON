package com.example.caroline.learningjson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by princ on 12/01/2018.
 */

public interface DataMuseAPI {
    String baseURL = "http://www.api.datamuse.com"; //basically our concatenate things

    @GET("words")
    Call<List<WordObject>> getSoundsLike(@Query("sl") String word);
    //it is Call so that we can receive the data ASYNCHRONOUSLY so we don't have to halt the UI thread whilst it loads
}
