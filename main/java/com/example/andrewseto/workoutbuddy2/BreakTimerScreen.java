package com.example.andrewseto.workoutbuddy2;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Object;
import java.util.Timer;


public class BreakTimerScreen extends Activity {
    public Button startButton, stopButton, restartButton;
    public EditText getMinutes, getSeconds;
    public TextView showTime;
    private CountDownTimer myTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try{

        super.onCreate(savedInstanceState);
        setContentView(R.layout.breaktimer_layout);

        startButton = (Button) findViewById(R.id.timerStartButton);
        //stopButton = (Button) findViewById(R.id.timerStopButton);
        //restartButton = (Button) findViewById(R.id.timerRestartButton);
        getMinutes = (EditText) findViewById(R.id.get_minutes);
        getSeconds = (EditText) findViewById(R.id.get_seconds);
        showTime = (TextView) findViewById(R.id.time);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mText = getMinutes.getText().toString();
                String sText = getSeconds.getText().toString();



                if (mText.equals("")){
                    mText = "0";

                }
                if (sText.equals("")){
                    sText = "0";
                }
                int seconds = (Integer.valueOf(sText)) + (Integer.valueOf(mText) * 60);


                if (!sText.equalsIgnoreCase("")) {
                    CountDownTimer myTimer = new CountDownTimer(seconds * 1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            String s = Long.toString(millisUntilFinished / 1000);

                            int secondsInt = Integer.parseInt(s);
                            int Minutes = 0;
                            while (secondsInt > 59) {
                                secondsInt = secondsInt - 60;
                                System.out.println(secondsInt);
                                Minutes++;
                            }

                            if (secondsInt > 9) {
                                showTime.setText(Minutes + ":" + secondsInt);
                            } else if (secondsInt <= 9) {
                                showTime.setText(Minutes + ":0" + secondsInt);
                            }
                        }


                        @Override
                        public void onFinish() {



                            showTime.setText("Done");

                            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(BreakTimerScreen.this)
                                    .setSmallIcon(android.R.drawable.stat_notify_error)
                                    .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                                    .setContentTitle("Title")
                                    .setContentText("Breaks up");
                                notificationBuilder.setDefaults(
                                    Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
                                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(BreakTimerScreen.this);
                                notificationManagerCompat.notify(1,notificationBuilder.build());
                        }
                    }.start();




                }


            }

        });

    }catch(Exception e){
            Toast.makeText(this, "Please fill all boxes", Toast.LENGTH_SHORT).show();
        }

    {
    }


    }


    public void onRestartButtonClick(View view) {
    }


    public void goToMain (View view){
        Intent getMainScreenIntent = new Intent(this, MainActivity.class);

        startActivity(getMainScreenIntent);

        finish();
    }



}
