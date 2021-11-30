package com.example.poetry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.poetry.Adapter.PoetryAdapter;
import com.example.poetry.Api.ApiClient;
import com.example.poetry.Api.ApiInterface;
import com.example.poetry.Models.PoetryModel;
import com.example.poetry.Response.GetPoetryResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    PoetryAdapter poetryAdapter;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intialization();
        getdata();
    }

    private void intialization(){
        recyclerView = findViewById(R.id.poetry_recyclerView);
        Retrofit retrofit = ApiClient.getClient();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    private void setAdapter(List<PoetryModel> poetryModels){
        poetryAdapter = new PoetryAdapter(this,poetryModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(poetryAdapter);

    }

    private void getdata(){
        apiInterface.getpoetry().enqueue(new Callback<GetPoetryResponse>() {
            @Override
            public void onResponse(Call<GetPoetryResponse> call, Response<GetPoetryResponse> response) {
                try {
                    if (response!=null){
                        if (response.body().getStatus().equals("1")){
                            setAdapter(response.body().getData());
                        }
                        else {
                            Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                catch (Exception e){
                    Log.e("exe",e.getLocalizedMessage());
                }
            }

            @Override
            public void onFailure(Call<GetPoetryResponse> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());
            }
        });

    }

}