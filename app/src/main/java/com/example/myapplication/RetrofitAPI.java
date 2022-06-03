package com.example.myapplication;

import com.example.myapplication.models.FAQs;
import com.example.myapplication.models.User;
import com.example.myapplication.models.UserData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitAPI {
    public static final String BASE_URL = "http://localhost:8080/dsaApp/";
    @POST("user/login")
    Call<User> login(@Body UserData user);

    @POST("user/add")
    Call<User> add(@Body UserData user);

    @GET("FAQ/get")
    Call<List<FAQs>> getFAQs();
}