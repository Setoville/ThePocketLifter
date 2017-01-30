package com.example.andrewseto.workoutbuddy2;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by andrewseto on 27/01/2017.
 */
public class MyTask extends TimerTask{
    int count = 10;
    Timer t = null;


    public MyTask(Timer t){
        this.t=t;
    }

    public void run() {



        if(count==0){
            t.cancel();
        }

        count--;


    }

}
