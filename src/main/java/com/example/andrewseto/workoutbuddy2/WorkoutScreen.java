package com.example.andrewseto.workoutbuddy2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class WorkoutScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_layout);
    }

    public void goToMain (View view){
        Intent getMainScreenIntent = new Intent(this, MainActivity.class);

        startActivity(getMainScreenIntent);

        finish();
    }

}
