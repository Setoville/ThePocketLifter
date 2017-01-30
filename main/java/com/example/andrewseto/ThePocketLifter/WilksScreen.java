package com.example.andrewseto.workoutbuddy2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WilksScreen extends Activity{
    private Button crunchButton;
    private EditText get_bench,get_squat,get_deadlift,get_bw;
    private TextView wilksText;
    public boolean male=false;
    public boolean kg=false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wilks_layout);
        get_bench = (EditText) findViewById(R.id.get_bench);
        get_squat = (EditText) findViewById(R.id.get_squat);
        get_deadlift = (EditText) findViewById(R.id.get_deadlift);
        get_bw = (EditText) findViewById(R.id.get_bw);
        wilksText = (TextView) findViewById(R.id.wilks_name);
    }
    public void onCrunchButtonMaleClick(View view){
        male=true;
  //     Toast.makeText(this, "kg=" +kg, Toast.LENGTH_SHORT).show();
        crunch();
    }
    public void onCrunchButtonFemaleClick(View view){
        male=false;
  //      Toast.makeText(this, "kg=" +kg, Toast.LENGTH_SHORT).show();

        crunch();
    }
    private void crunch() {
        //Toast.makeText(this, "Please fill all boxes" +male, Toast.LENGTH_SHORT).show();
        try {
            String benchString = String.valueOf(get_bench.getText());
            String squatString = String.valueOf(get_squat.getText());
            String deadliftString = String.valueOf(get_deadlift.getText());
            String bwString = String.valueOf(get_bw.getText());

            double bench = Integer.parseInt(benchString);
            double squat = Integer.parseInt(squatString);
            double deadlift = Integer.parseInt(deadliftString);
            double bw = Integer.parseInt(bwString);

        double coeff=0;
        double ma=-216.0475144,mb=16.2606339,mc=-0.002388645,md=-0.00113732,me=7.01863*(Math.pow(10,-6)), mf=-1.291*(Math.pow(10,-8));
        double fa=594.31747775582, fb=-27.23842536447, fc=0.82112226871, fd=-0.00930733913, fe=4.731582*(Math.pow(10,-5)), ff=-9.054*(Math.pow(10,-8));

            if (kg==false) {
            bench = bench / 2.20462;
            squat = squat / 2.20462;
            deadlift = deadlift / 2.20462;
            bw = bw / 2.20462;
        }
            double sum = bench + squat + deadlift;
            if (male){
                coeff=500/(ma+(bw*mb)+((Math.pow(bw,2))*mc)+((Math.pow(bw,3))*md)+((Math.pow(bw,4))*me)+((Math.pow(bw,5))*mf));
        }
            if (!male) {
                coeff=500/(fa+(bw*fb)+((Math.pow(bw,2))*fc)+((Math.pow(bw,3))*fd)+((Math.pow(bw,4))*fe)+((Math.pow(bw,5))*ff));
            }
            double finalcoeff = coeff*sum;

            wilksText.setText("Wilks Score: " + Double.toString(finalcoeff));



        }catch (Exception e){
            Toast.makeText(this, "Please fill all boxes", Toast.LENGTH_SHORT).show();
        }

    }
    public void onKgCheckbox (View view){
        kg = ((CheckBox) view).isChecked();

        if (kg){
            Toast.makeText(this, "Switched to KG", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this, "Switched to LBS", Toast.LENGTH_SHORT).show();

        }

    }
    public void goToMain (View view){
        Intent getMainScreenIntent = new Intent(this, MainActivity.class);

        startActivity(getMainScreenIntent);

        finish();
    }
}

