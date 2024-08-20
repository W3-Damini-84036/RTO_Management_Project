package com.sunbeaminfo.project.utils;

import com.google.gson.JsonObject;
import com.sunbeaminfo.project.entity.User;
import com.sunbeaminfo.project.entity.Admin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {
    public static final String BASEURL="http://localhost:7581";

    @POST("/user/login")
    public Call<JsonObject> loginUser(@Body User user);

    @GET("/user/{id}")
    public Call<JsonObject> getUserById(@Path("id") int id);
//
//    @POST("/users")
//    public Call<JsonObject> registerUser(@Body User user);

    @POST("/admin")
    public Call<JsonObject> registerAdmin(@Body Admin admin);

    @POST("/admin/login")
    public Call<JsonObject> loginAdmin(@Body Admin admin);

    @POST("/user/register")
    public Call<JsonObject> registerUser(@Body User user);
}