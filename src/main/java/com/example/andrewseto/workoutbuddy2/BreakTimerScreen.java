package com.example.andrewseto.workoutbuddy2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.Object;



public class BreakTimerScreen extends Activity {
    public Button startButton, stopButton, restartButton;
    private EditText getMinutes, getSeconds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breaktimer_layout);
        startButton = (Button) findViewById(R.id.timerStartButton);
        stopButton = (Button) findViewById(R.id.timerStopButton);
        restartButton = (Button) findViewById(R.id.timerRestartButton);
        getMinutes = (EditText) findViewById(R.id.get_minutes);
        getSeconds = (EditText) findViewById(R.id.get_seconds);

     //  StopWatch stopWatch = new StopWatch();
        //timer
        //StopWatch stopwatch = new StopWatch();
    }
    public void onStartButtonClick(View view) {
        try{
            String minutesAdded = String.valueOf(getMinutes.getText());
            String secondsAdded = String.valueOf(getSeconds.getText());
            int m = Integer.parseInt(minutesAdded);
            int s = Integer.parseInt(secondsAdded);

            //convert this to ms
            //get the numbers from the edittexts

        }catch (Exception e){
            Toast.makeText(this, "Please fill all boxes", Toast.LENGTH_SHORT).show();
        }
    }
    public void onStopButtonClick(View view) {

    }
    public void onRestartButtonClick(View view) {

    }


    public void goToMain (View view){
        Intent getMainScreenIntent = new Intent(this, MainActivity.class);

        startActivity(getMainScreenIntent);

        finish();
    }



}
