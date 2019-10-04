package project.hcinteraction.breadmakerapp;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class GestureListener extends GestureDetector.SimpleOnGestureListener {
    private Context context;
    private Class<?> T;
    MediaPlayer mp;
    AudioPlay audio;

    GestureListener(Context c, Class<?> t){
        context = c;
        T = t;
    }
    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }
    // event when double tap occurs

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Intent i = new Intent(context,T);
        audio.stopAudio();
        context.startActivity(i);

        return true;
    }

}