package project.hcinteraction.breadmakerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class IngredActivity12 extends AppCompatActivity {
    float x1,x2,y1,y2;
    AudioPlay audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingred12);
        audio.playAudio(IngredActivity12.this,R.raw.alati1);
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
                    Intent i = new Intent(IngredActivity12.this, IngredActivity13.class);
                    audio.stopAudio();
                    startActivity(i);
                }else if(x1 < x2){
                    Intent i = new Intent(IngredActivity12.this, IngredActivity11.class);
                    audio.stopAudio();
                    startActivity(i);
                }
                break;

        }
        return false;

    }
}
