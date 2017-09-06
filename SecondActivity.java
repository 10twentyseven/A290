package com.a290.kevin.assignment2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private String recievedUser;
    private String recievedEmail;
    private String recievedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        View bg = (View) findViewById(R.id.background);

        Intent intent = getIntent();
        recievedUser = intent.getStringExtra("USERNAME");
        recievedEmail = intent.getStringExtra("EMAIL");
        recievedColor = intent.getStringExtra("COLOR");

        TextView username = (TextView)findViewById(R.id.Name);
        username.setText(recievedUser);
        TextView email = (TextView)findViewById(R.id.email);
        email.setText(recievedEmail);

        if (recievedColor.equals("Red")){
            bg.setBackgroundColor(Color.parseColor("#993300"));
        } else if (recievedColor.equals("Orange")){
            bg.setBackgroundColor(Color.parseColor("#ff9933"));
        } else if (recievedColor.equals("Yellow")){
            bg.setBackgroundColor(Color.parseColor("#ffff00"));
        } else if (recievedColor.equals("Green")){
            bg.setBackgroundColor(Color.parseColor("#33cc33"));
        } else if (recievedColor.equals("Blue")){
            bg.setBackgroundColor(Color.parseColor("#3399ff"));
        } else if (recievedColor.equals("Indigo")){
            bg.setBackgroundColor(Color.parseColor("#621ab3"));
        } else if (recievedColor.equals("Violet")){
            bg.setBackgroundColor(Color.parseColor("#cc99ff"));
        }
    }


    private String total = "0";
    private String equation = "";

    public void plusEventHandler(View view) {
        TextView nums = (TextView) findViewById(R.id.nums);
        String current = nums.getText().toString();


        if (!current.equals("")){
            if ((current.substring(current.length()-2)).equals("+ ")) {
                nums.setText(current);
            } else if ((current.substring(current.length()-2)).equals("- ")) {
                nums.setText((current.substring(0, current.length()-2)) + "+ ");
            } else if ((current.substring(current.length()-2)).equals("/ ")) {
                nums.setText((current.substring(0, current.length()-2)) + "+ ");
            } else if ((current.substring(current.length()-2)).equals("* ")) {
                nums.setText((current.substring(0, current.length()-2)) + "+ ");
            } else {
                nums.setText(current + " + ");
            }
        } else {
            nums.setText("0" + " + ");
        }
    }

    public void minusEventHandler(View view) {
        TextView nums = (TextView) findViewById(R.id.nums);
        String current = nums.getText().toString();

        if (!current.equals("")){
            if ((current.substring(current.length()-2)).equals("- ")) {
                nums.setText(current);
            } else if ((current.substring(current.length()-2)).equals("+ ")) {
                nums.setText((current.substring(0, current.length()-2)) + "- ");
            } else if ((current.substring(current.length()-2)).equals("/ ")) {
                nums.setText((current.substring(0,current.length()-2)) + "- ");
            } else if ((current.substring(current.length()-2)).equals("* ")) {
                nums.setText((current.substring(0, current.length()-2)) + "- ");
            } else {
                nums.setText(current + " - ");
            }
        } else {
            nums.setText("0" + " - ");
        }
    }

    public void divideEventHandler(View view) {
        TextView nums = (TextView) findViewById(R.id.nums);
        String current = nums.getText().toString();

        if (!current.equals("")){
            if ((current.substring(current.length()-2)).equals("/ ")) {
                nums.setText(current);
            } else if ((current.substring(current.length()-2)).equals("- ")) {
                nums.setText((current.substring(0, current.length()-2)) + "/ ");
            } else if ((current.substring(current.length()-2)).equals("+ ")) {
                nums.setText((current.substring(0, current.length()-2)) + "/ ");
            } else if ((current.substring(current.length()-2)).equals("* ")) {
                nums.setText((current.substring(0,current.length()-2)) + "/ ");
            } else {
                nums.setText(current + " / ");
            }
        } else {
            nums.setText("0" + " / ");
        }
    }

    public void timesEventHandler(View view) {
        TextView nums = (TextView) findViewById(R.id.nums);
        String current = nums.getText().toString();

        if (!current.equals("")){
            if ((current.substring(current.length()-2)).equals("* ")) {
                nums.setText(current);
            } else if ((current.substring(current.length()-2)).equals("- ")) {
                nums.setText((current.substring(0,current.length()-2)) + "* ");
            } else if ((current.substring(current.length()-2)).equals("/ ")) {
                nums.setText((current.substring(0, current.length()-2)) + "* ");
            } else if ((current.substring(current.length()-2)).equals("+ ")) {
                nums.setText((current.substring(0, current.length()-2)) + "* ");
            } else {
                nums.setText(current + " * ");
            }
        } else {
            nums.setText("0" + " * ");
        }
    }

    public void secondPowerEventHandler(View view) {
        TextView nums = (TextView) findViewById(R.id.nums);
        String current = nums.getText().toString();

        if (!current.equals("")){
            if ((current.substring(current.length()-3)).equals("^2 ")) {
                nums.setText(current);
            } else if ((current.substring(current.length()-2)).equals("- ")) {
                nums.setText((current.substring(0, current.length()-2)) + "^2 ");
            } else if ((current.substring(current.length()-2)).equals("/ ")) {
                nums.setText((current.substring(0, current.length()-2)) + "^2 ");
            } else if ((current.substring(current.length()-2)).equals("* ")) {
                nums.setText((current.substring(0, current.length()-2)) + "^2 ");
            } else if ((current.substring(current.length()-2)).equals("+ ")) {
                nums.setText((current.substring(0, current.length()-2)) + "^2 ");
            } else if ((current.substring(current.length() - 5)).equals("^1/2 ")) {
                nums.setText((current.substring(0, current.length() - 5)) + "^2 ");
            } else {
                nums.setText(current + " ^2 ");
            }
        } else {
            nums.setText("0" + " ^2 ");
        }
    }

    public void halfPowerEventHandler(View view) {
        TextView nums = (TextView) findViewById(R.id.nums);
        String current = nums.getText().toString();

        if (!current.equals("")){
            if (current.length()>=5) {
                if ((current.substring(current.length() - 5)).equals("^1/2 ")) {
                    nums.setText(current);
                } else if ((current.substring(current.length() - 2)).equals("- ")) {
                    nums.setText((current.substring(0, current.length() - 2)) + "^1/2 ");
                } else if ((current.substring(current.length() - 2)).equals("/ ")) {
                    nums.setText((current.substring(0, current.length() - 2)) + "^1/2 ");
                } else if ((current.substring(current.length() - 2)).equals("* ")) {
                    nums.setText((current.substring(0, current.length() - 2)) + "^1/2 ");
                } else if ((current.substring(current.length() - 2)).equals("+ ")) {
                    nums.setText((current.substring(0, current.length() - 2)) + "^1/2 ");
                } else if ((current.substring(current.length() - 3)).equals("^2 ")) {
                    nums.setText((current.substring(0, current.length() - 3)) + "^1/2 ");
                } else {
                    nums.setText(current + " ^1/2 ");
                }
            } else {
                if ((current.substring(current.length() - 2)).equals("- ")) {
                    nums.setText((current.substring(0, current.length() - 2)) + "^1/2 ");
                } else if ((current.substring(current.length() - 2)).equals("/ ")) {
                    nums.setText((current.substring(0, current.length() - 2)) + "^1/2 ");
                } else if ((current.substring(current.length() - 2)).equals("* ")) {
                    nums.setText((current.substring(0, current.length() - 2)) + "^1/2 ");
                } else if ((current.substring(current.length() - 2)).equals("+ ")) {
                    nums.setText((current.substring(0, current.length() - 2)) + "^1/2 ");
                } else if ((current.substring(current.length() - 3)).equals("^2 ")) {
                    nums.setText((current.substring(0, current.length() - 3)) + "^1/2 ");
                } else {
                    nums.setText(current + " ^1/2 ");
                }

            }
        } else {
            nums.setText("0" + " ^1/2 ");
        }
    }

    public void equalsEventHandler(View view) {

    }
}
