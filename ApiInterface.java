package com.example.poetry.Api;

import com.example.poetry.Response.GetPoetryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("getpoetry.php")
    Call<GetPoetryResponse> getpoetry();

}
