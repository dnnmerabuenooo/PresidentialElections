package com.example.labact;

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
        if (et_age.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter your age.", Toast.LENGTH_SHORT).show();
        } else {
            age = Integer.parseInt(et_age.getText().toString());
            if (age <= 17) {
                Toast.makeText(this, "You cannot vote.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "You can vote!", Toast.LENGTH_SHORT).show();

                name = home.getText().toString();
                Toast.makeText(this, "Hello, " + name + "!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, Page1.class);
                i.putExtra("name", name);
                startActivity(i);
                finish();
            }
        }
    }
}
