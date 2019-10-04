package project.hcinteraction.breadmakerapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class BreadActivity3 extends AppCompatActivity {
    float x1,x2,y1,y2;
    GestureDetector gestureDetector;
    AudioPlay audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread3);
        audio.playAudio(BreadActivity3.this,R.raw.olikis);
        gestureDetector = new GestureDetector(BreadActivity3.this, new GestureListener(BreadActivity3.this, BreadActivity3_Confirm.class));
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

                if(x1 > x2){
                    Intent i = new Intent(BreadActivity3.this, BreadActivity4.class);
                    audio.stopAudio();
                    startActivity(i);

                }else if(x1 < x2){
                    Intent i = new Intent(BreadActivity3.this, BreadActivity2.class);
                    audio.stopAudio();
                    startActivity(i);

                }
                break;

        }
        return gestureDetector.onTouchEvent(touchEvent);
    }
}
