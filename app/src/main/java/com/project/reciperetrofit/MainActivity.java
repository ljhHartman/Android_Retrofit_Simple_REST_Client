package com.project.reciperetrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.reciperetrofit.R;
import com.project.reciperetrofit.controller.ControllerPerson;



public class MainActivity extends AppCompatActivity {

    // Declare View Elements
    private EditText txtFirstName, txtLastName, txtId;
    private Button btnPost, btnGet, btnGetById, btnDelById, btnDelAll;
    private TextView lblResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // initializing (get) View Elements
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        btnPost = findViewById(R.id.btnPost);
        btnGet = findViewById(R.id.btnGet);
        btnGetById = findViewById(R.id.btnGetById);
        btnDelById = findViewById(R.id.btnDelById);
        btnDelAll = findViewById(R.id.btnDelAll);
        txtId = findViewById(R.id.txtId);
        lblResponse = findViewById(R.id.lblResponse);


        // BUTTON ONCLICK : POST ACTION
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EXECUTE : BUTTON ACTION
                Log.i("info", "Post Button is clicked");

                // Validating if the text fields are empty or not.
                if (txtFirstName.getText().toString().isEmpty() && txtLastName.getText().toString().isEmpty()) {
                    Log.i("info", "Input boxes are empty");
                } else {
                    // EXECUTE : POST ACTION
                    Log.i("info", "Execute Action");
                    ControllerPerson.PostData(txtFirstName, txtLastName, lblResponse);
                }
            }
        });


        // BUTTON ONCLICK : GET ACTION
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EXECUTE : BUTTON ACTION
                Log.i("info", "Get Button is clicked");

                // EXECUTE : POST ACTION
                Log.i("info", "Execute Action");
                ControllerPerson.GetData(lblResponse);
            }
        });


        // BUTTON ONCLICK : GET BY ID ACTION
        btnGetById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EXECUTE : BUTTON ACTION
                Log.i("info", "Get By Id Button is clicked");

                // Validating if the text fields are empty or not.
                if (txtId.getText().toString().isEmpty()) {
                    Log.i("info", "Input boxes are empty");
                } else {
                    // EXECUTE : POST ACTION
                    Log.i("info", "Execute Action");
                    ControllerPerson.GetById(txtId, lblResponse);
                }
            }
        });



        // BUTTON ONCLICK : Del BY ID ACTION
        btnDelById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EXECUTE : BUTTON ACTION
                Log.i("info", "Del By Id Button is clicked");

                // Validating if the text fields are empty or not.
                if (txtId.getText().toString().isEmpty()) {
                    Log.i("info", "Input boxes are empty");
                } else {
                    // EXECUTE : POST ACTION
                    Log.i("info", "Execute Action");
                    ControllerPerson.DelById(txtId, lblResponse);
                }
            }
        });


        // BUTTON ONCLICK : DEL ALL ACTION
        btnDelAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EXECUTE : BUTTON ACTION
                Log.i("info", "Delete Button is clicked");
                ControllerPerson.DelAll();
            }
        });




    }
}