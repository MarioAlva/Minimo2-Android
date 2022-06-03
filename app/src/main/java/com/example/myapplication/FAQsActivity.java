package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.models.FAQs;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FAQsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);
        init();
    }

    public void init() {
        Gson gson2 = new GsonBuilder().setLenient().create();
        Retrofit retrofit2 = new Retrofit.Builder().baseUrl(RetrofitAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson2)).build();
        System.out.println(retrofit2);
        RetrofitAPI gerritAPI2 = retrofit2.create(RetrofitAPI.class);
        Call<List<FAQs>> call2 = gerritAPI2.getFAQs();
        call2.enqueue(new Callback<List<FAQs>>() {
            @Override
            public void onResponse(Call<List<FAQs>> call2, Response<List<FAQs>> response) {
                //if(!response.isSuccessful()){
                //    Intent intent = new Intent(getApplicationContext(), ErrorActivity.class);
                //    startActivity(intent);
                //}
                List<FAQs> FAQsList = response.body();
                System.out.println("me meto aqui");
                ListAdapter listAdapter = new ListAdapter(FAQsList, FAQsActivity.this);
                RecyclerView recyclerView = findViewById(R.id.RecyclerViewList);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(FAQsActivity.this));
                recyclerView.setAdapter(listAdapter);
                findViewById(R.id.progressBar).setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<FAQs>> call2, Throwable t) {
                System.out.println(call2);
                //Intent intent = new Intent(this, MenuActivity.class);
                //startActivity(intent);
            }
        });
    }
}
