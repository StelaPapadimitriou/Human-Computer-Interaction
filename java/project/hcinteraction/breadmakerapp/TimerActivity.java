package project.hcinteraction.breadmakerapp;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity {

    private TextView countdownText;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliSeconds = 3600000; //1 hour
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start2);

        MediaPlayer mp = MediaPlayer.create(TimerActivity.this,R.raw.end2);
        mp.start();

        countdownText = findViewById(R.id.countdown_text);

        startStop();


    }

    public void startStop()
    {
        if(timerRunning)
        {
            stopTimer();

        }else{
            startTimer();
        }
    }


    public void stopTimer()
    {
        countDownTimer.cancel();
        timerRunning = false;
    }

    public void startTimer()
    {
        countDownTimer = new CountDownTimer(timeLeftInMilliSeconds,500){
            public void onTick(long l)
            {
                timeLeftInMilliSeconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void updateTimer()
    {
        int minutes = (int) (timeLeftInMilliSeconds / 1000) / 60;
        int seconds = (int) (timeLeftInMilliSeconds / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        countdownText.setText(timeLeftFormatted);

        if(minutes == 0 ) {
            MediaPlayer mp2 = MediaPlayer.create(TimerActivity.this,R.raw.end4);
            mp2.start();
        }


    }
}
