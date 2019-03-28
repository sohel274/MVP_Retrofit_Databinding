package com.example.root.mymvp.retrofit;

import com.example.root.mymvp.model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("top-headlines")
    Call<News> getNews(@Query("sources") String sources, @Query("apiKey") String apiKey);


}
