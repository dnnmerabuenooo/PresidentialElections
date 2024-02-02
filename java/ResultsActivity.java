package com.example.presidentialelections;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView voter;
    TextView pres;
    TextView vice;
    String name;
    String enteredPres;
    String enteredVice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        pres = findViewById(R.id.pres);
        vice = findViewById(R.id.vice);
        voter = findViewById(R.id.voter);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        enteredPres = i.getStringExtra("pres");
        enteredVice = i.getStringExtra("vice");

        voter.setText("Thank you, " + name + "!");
        pres.setText("President: " + enteredPres.trim());
        vice.setText("Vice President: " + enteredVice.trim());
    }

    public void goToHomePage(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
