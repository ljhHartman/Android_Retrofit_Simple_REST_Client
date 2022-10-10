package com.project.reciperetrofit.repository;

import com.project.reciperetrofit.model.Person;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RepositoryPerson {

    @POST("persons")
    Call<Person> createPost(@Body Person person);
}
