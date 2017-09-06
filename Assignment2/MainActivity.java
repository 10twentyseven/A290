package com.a290.kevin.assignment2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer attempt = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner colors = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.colors_array ,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colors.setAdapter(adapter);



    }

    public void LogInEventHandler(View view) {
        String defaultUser = "kevin@yahoo.com";
        String defaultPass = "1234";
        String username = ((TextView) findViewById(R.id.email)).getText().toString();
        String name = ((TextView) findViewById(R.id.firstName)).getText().toString() + " " + ((TextView) findViewById(R.id.LastName)).getText().toString();
        String pass = ((TextView) findViewById(R.id.password)).getText().toString();
        TextView warning = (TextView) findViewById(R.id.warning);
        Button logIn = (Button) findViewById(R.id.button);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        String color = spin.getSelectedItem().toString();

        if (!username.equals(defaultUser) || !pass.equals(defaultPass)){
            attempt = attempt - 1;

            if (attempt == 0) {
                warning.setText("This is your last attempt");
            } else if (attempt <= -1){
                warning.setText("Your account has been locked");
                logIn.setClickable(false);
            } else {
                warning.setText("Account information incorrect. You have " + attempt.toString() + " attempts left!");
            }
        } else {
            warning.setText("Welcome " + username);

            Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
            myIntent.putExtra("USERNAME", "Welcome " + name);
            myIntent.putExtra("EMAIL", username);
            myIntent.putExtra("COLOR", color);
            startActivityForResult(myIntent, 40);
        }
    }
}
