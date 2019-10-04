package project.hcinteraction.breadmakerapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class StartActivity4 extends AppCompatActivity {
    float x1,x2,y1,y2;
    GestureDetector gestureDetector;
    AudioPlay audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start4);
        audio.playAudio(StartActivity4.this,R.raw.end);

        gestureDetector = new GestureDetector(StartActivity4.this, new GestureListener(StartActivity4.this, TimerActivity.class));

    }
    public boolean onTouchEvent(MotionEvent touchEvent) {
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();

                if(x1 < x2){
                    Intent i = new Intent(StartActivity4.this, IngredActivity15.class);
                    audio.stopAudio();
                    startActivity(i);
                }
                break;

        }
        return gestureDetector.onTouchEvent(touchEvent);
    }
}
