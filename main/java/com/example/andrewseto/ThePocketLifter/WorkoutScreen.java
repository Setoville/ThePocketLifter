package com.example.andrewseto.workoutbuddy2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class WorkoutScreen extends Activity {

    private EditText getWeight, getBar;
    private TextView sideweightText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_layout);
        getWeight= (EditText) findViewById(R.id.get_weight);
        getBar = (EditText) findViewById(R.id.get_bar);
        sideweightText = (TextView) findViewById(R.id.sideweight_Text);


    }
    public void onCrunchButtonClick(View view) {
        try{
            String weight = String.valueOf(getWeight.getText());
            String bar = String.valueOf(getBar.getText());

            int w = Integer.parseInt(weight);
            int b = Integer.parseInt(bar);

            w=w-b;

            w=w/2;

            if (w < b) {
                Toast.makeText(this, "Error: Bar heavier than weight", Toast.LENGTH_SHORT).show();
                w=0;
            }

            sideweightText.setText(String.valueOf(w));

        }catch(Exception e){
            Toast.makeText(this, "Please fill all boxes", Toast.LENGTH_SHORT).show();

        }
    }

    public void goToMain (View view){
        Intent getMainScreenIntent = new Intent(this, MainActivity.class);

        startActivity(getMainScreenIntent);

        finish();
    }

}
