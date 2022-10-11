package com.project.reciperetrofit.controller;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.project.reciperetrofit.model.Person;
import com.project.reciperetrofit.repository.RepositoryPerson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControllerPerson {

    // GET By Id ALL ACTION
    public static void DelAll() {
        Log.i("info", "-- Del All --");

        // Build Retrofit : to send data in json format
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Init Repository Class
        RepositoryPerson repositoryPerson = retrofit.create(RepositoryPerson.class);

        // Init Repository Get Method
        Call<Void> call = repositoryPerson.deleteAll();
    }


    // GET By Id ALL ACTION
    public static void DelById(EditText input, TextView ResponseView) {
        Log.i("info", "-- DelById --");

        // Build Retrofit : to send data in json format
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Init Repository Class
        RepositoryPerson repositoryPerson = retrofit.create(RepositoryPerson.class);

        // Init Repository Get Method
        Log.i("info", "Check Input Value: " +String.valueOf(input.getText()));
        Long inputL = Long.parseLong(String.valueOf(input.getText()));
        Call<Void> call = repositoryPerson.delPersonById(inputL);


        call.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                // Set Input Box to Empty again
                input.setText("");

                // we are getting response from our body
                // and passing it to our modal class.
                Void responseFromAPI = response.body();


                // Build & Set Text for the ResponseView
                String responseString = "Response Code : " + response.code()
                        + "\n Deleted";
                ResponseView.setText(responseString);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Set Error to TextView
                ResponseView.setText("Api Call Failed" + t.getMessage());
            }
        });
    }












            // GET By Id ALL ACTION
    public static void GetById(EditText input, TextView ResponseView) {
        Log.i("info", "-- GetById --");

        // Build Retrofit : to send data in json format
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Init Repository Class
        RepositoryPerson repositoryPerson = retrofit.create(RepositoryPerson.class);

        // Init Repository Get Method
        Log.i("info", "Check Input Value: " +String.valueOf(input.getText()));
        Long inputL = Long.parseLong(String.valueOf(input.getText()));
        Call<Person> call = repositoryPerson.getPersonById(inputL);


        call.enqueue(new Callback<Person>() {

            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {

                // Set Input Box to Empty again
                input.setText("");

                // we are getting response from our body
                // and passing it to our modal class.
                Person responseFromAPI = response.body();

                // Build & Set Text for the ResponseView
                String responseString = "Response Code : " + response.code()
                        + "\nId : " + responseFromAPI.getId()
                        + "\nFirst Name : " + responseFromAPI.getFirstName() + "\n"
                        + "Last Name : " + responseFromAPI.getLastName();
                ResponseView.setText(responseString);
            }




            @Override
            public void onFailure(Call<Person> call, Throwable t) {

                // Set Error to TextView
                ResponseView.setText("Api Call Failed" + t.getMessage());
            }
        });
    }

    // GET ALL ACTION
    public static void GetData(TextView ResponseView) {
        Log.i("info", "-- GetData --");

        // Build Retrofit : to send data in json format
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Init Repository Class
        RepositoryPerson repositoryPerson = retrofit.create(RepositoryPerson.class);

        // Init Repository Get Method
        Call<Object> call = repositoryPerson.getPersons();


        call.enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

                // Set TextView
                ResponseView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

                // Set Error to TextView
                ResponseView.setText("Api Call Failed" + t.getMessage());
            }
        });
    }

    // POST ACTION
    public static void PostData(TextView firstNameEdt, TextView lastNameEdt,TextView ResponseView) {
        Log.i("info", "-- postDataAction --");

        // Build Retrofit : to send data in json format
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Init Repository Class
        RepositoryPerson repositoryPerson = retrofit.create(RepositoryPerson.class);

        // Set Input data to our Model
        Person person = new Person(firstNameEdt.getText().toString(), lastNameEdt.getText().toString());

        // Init Repository Post Method
        Call<Person> call = repositoryPerson.createPost(person);

        // Execute Method
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {

                // Set Input Boxes back to empty
                firstNameEdt.setText("");
                lastNameEdt.setText("");

                // we are getting response from our body
                // and passing it to our modal class.
                Person responseFromAPI = response.body();

                // Build & Set Text for the ResponseView
                String responseString = "Response Code : "
                        + response.code() + "\nFirst Name : "
                        + responseFromAPI.getFirstName() + "\n"
                        + "Last Name : " + responseFromAPI.getLastName();
                ResponseView.setText(responseString);
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                // setting text to our text view when
                // we get error response from API.
                ResponseView.setText("Error found is : " + t.getMessage());
            }
        });
    }




}