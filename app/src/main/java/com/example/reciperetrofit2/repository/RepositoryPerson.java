package com.example.reciperetrofit2.repository;

import com.example.reciperetrofit2.model.Person;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RepositoryPerson {

    @POST("persons")
    Call<Person> createPost(@Body Person person);
}
