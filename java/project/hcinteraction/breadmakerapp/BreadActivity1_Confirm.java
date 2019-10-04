package project.hcinteraction.breadmakerapp;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class BreadActivity1_Confirm extends AppCompatActivity {
    float x1,x2,y1,y2;
    GestureDetector gestureDetector;
    AudioPlay audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread_activity1__confirm);
        audio.playAudio(BreadActivity1_Confirm.this,R.raw.xwriatikoconfirm);
        gestureDetector = new GestureDetector(BreadActivity1_Confirm.this, new GestureListener(BreadActivity1_Confirm.this, IngredActivity6.class));

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
                    Intent i = new Intent(BreadActivity1_Confirm.this, BreadActivity1.class);
                    audio.stopAudio();
                    startActivity(i);
                }
                break;

        }
        return gestureDetector.onTouchEvent(touchEvent);
    }

}
