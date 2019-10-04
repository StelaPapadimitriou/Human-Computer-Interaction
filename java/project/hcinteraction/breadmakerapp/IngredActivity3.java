package project.hcinteraction.breadmakerapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class IngredActivity3 extends AppCompatActivity {
    float x1,x2,y1,y2;
    AudioPlay audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingred3);
        audio.playAudio(IngredActivity3.this,R.raw.zaxari);

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
                if (x1 > x2) {
                    Intent i = new Intent(IngredActivity3.this, IngredActivity4.class);
                    audio.stopAudio();
                    startActivity(i);
                }else if(x1 < x2){
                    Intent i = new Intent(IngredActivity3.this, IngredActivity2.class);
                    audio.stopAudio();
                    startActivity(i);
                }
                break;

        }
        return false;
    }

}
