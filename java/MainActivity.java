package com.example.presidentialelections;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int age;
    String name;
    EditText home;
    EditText et_age;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_age = findViewById(R.id.age);
        home = findViewById(R.id.home);
    }

    public void submitAge(View v) {
        String enteredName = home.getText().toString();
        String enteredAge = et_age.getText().toString();

        if (enteredName.isEmpty() && enteredAge.isEmpty()) {
            Toast.makeText(this, "Please enter your name and age.", Toast.LENGTH_SHORT).show();
        } else if (enteredName.isEmpty()) {
            Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show();
        } else if (enteredAge.isEmpty()) {
            Toast.makeText(this, "Please enter your age.", Toast.LENGTH_SHORT).show();
        } else {
            age = Integer.parseInt(enteredAge);
            if (age <= 17) {
                Toast.makeText(this, "You cannot vote.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "You can vote!", Toast.LENGTH_SHORT).show();

                name = enteredName;
                Toast.makeText(this, "Hello, " + name + "!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, VotingActivity.class);
                i.putExtra("name", name);
                startActivity(i);
                finish();
            }
        }
    }

}
