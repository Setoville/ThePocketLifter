package com.example.andrewseto.workoutbuddy2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorScreen extends Activity {
    private Button crunchButton;
    private EditText getWeight, getReps;
    private TextView mayhewText, wathanText, averageText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
        crunchButton = (Button) findViewById(R.id.crunch_Button);
        getWeight = (EditText) findViewById(R.id.get_weight);
        getReps = (EditText) findViewById(R.id.get_reps);
        mayhewText = (TextView) findViewById(R.id.mayhew_Text);
        wathanText = (TextView) findViewById(R.id.wathan_Text);
        averageText = (TextView) findViewById(R.id.average_Text);
    }
    public void onCrunchButtonClick(View view){
        try {
            String weightLifted = String.valueOf(getWeight.getText());
            String repsDone = String.valueOf(getReps.getText());
                int w = Integer.parseInt(weightLifted);
                int r = Integer.parseInt(repsDone);
                double mayhewRM = (100 * w) / (52.2 + (41.9 * Math.exp(((double) r) * (-0.055))));
                double wathanRM = (100 * w) / (48.8 + (53.8 * Math.exp(((double) r) * (-0.075))));
                int mrm = (int) mayhewRM;
                int wrm = (int) wathanRM;
                int average = (mrm + wrm) / 2;
                if (r <= 0) {
                    average = 0;
                    mrm = 0;
                    wrm = 0;
                }
                if (r == 1) {
                    average = w;
                    mrm = w;
                    wrm = w;
                }
                wathanText.setText(Integer.toString(wrm));
                mayhewText.setText(Integer.toString(mrm));
                averageText.setText(Integer.toString((average)));



        }catch (Exception e){
            Toast.makeText(this, "Please fill all boxes", Toast.LENGTH_SHORT).show();
        }



    }

    public void goToMain (View view){
        Intent getMainScreenIntent = new Intent(this, MainActivity.class);

        startActivity(getMainScreenIntent);

        finish();
    }

}
