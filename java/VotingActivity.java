package com.example.presidentialelections;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VotingActivity extends AppCompatActivity {

    TextView voter;
    EditText pres;
    EditText vice;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        voter = findViewById(R.id.voter);
        pres = findViewById(R.id.pres);
        vice = findViewById(R.id.vice);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        voter.setText("Hello, " + name + "!");
    }

    public void proceed(View view){
        String enteredPres = pres.getText().toString();
        String enteredVice = vice.getText().toString();
        if (enteredPres.isEmpty() && enteredVice.isEmpty()){
            Toast.makeText(this, "Please enter your chosen candidates.", Toast.LENGTH_SHORT).show();
        } else if(enteredPres.isEmpty()){
            Toast.makeText(this, "Please enter your chosen candidate for president.", Toast.LENGTH_SHORT).show();
        } else if(enteredVice.isEmpty()){
            Toast.makeText(this, "Please enter your chosen candidate for vice president.", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Laban, Pilipinas!", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, ResultsActivity.class);
            i.putExtra("name",name);
            i.putExtra("pres", enteredPres);
            i.putExtra("vice", enteredVice);
            startActivity(i);
            finish();
        }
    }

    public void goToHomePage(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
