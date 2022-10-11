package com.project.reciperetrofit.repository;

import com.project.reciperetrofit.model.Person;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RepositoryPerson {

    @POST("persons")
    Call<Person> createPost(@Body Person person);

    @GET("persons")
    Call<Object> getPersons();

    @GET("persons/{id}")
    Call<Object> getPersonById(@Query("id") Long id);


}
