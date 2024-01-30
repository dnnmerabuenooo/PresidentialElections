package com.example.labact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Page1 extends AppCompatActivity {

TextView voter;
String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        voter = findViewById(R.id.voter);
        Intent i = getIntent();
        name = i.getStringExtra("name");
        voter.setText("Hello, " + name + "!");
    }
}
