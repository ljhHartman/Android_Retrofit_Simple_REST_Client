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
    private EditText txtFirstName, txtLastName;
    private Button btnPost;
    private TextView lblResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // initializing (get) View Elements
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        btnPost = findViewById(R.id.btnPost);
        lblResponse = findViewById(R.id.lblResponse);



        // BUTTON ONCLICK : POST ACTION
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EXECUTE : BUTTON ACTION
                Log.i("info", "Button is clicked");

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





    }
}