package com.example.andrewseto.workoutbuddy2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToCalc(View view){
        Intent getCalcScreenIntent = new Intent (this, CalculatorScreen.class);

        startActivity(getCalcScreenIntent);

    }
    public void goToWilks(View view){
        Intent getWilksScreenIntent = new Intent (this, WilksScreen.class);

        startActivity(getWilksScreenIntent);

    }

    public void goToBreakTimer(View view){
        Intent getBreakTimerScreenIntent = new Intent (this, BreakTimerScreen.class);

        startActivity(getBreakTimerScreenIntent);
    }
    public void goToWorkout(View view){
        Intent getWorkoutScreenIntent = new Intent (this, WorkoutScreen.class);

        startActivity(getWorkoutScreenIntent);
    }
    //TODO
    //maybe a break timer with notifications?
    //improve 1rm, maybe add 2rm and 3rm?
    //PLATE CALCULATOR
    //suggest numbers



}
