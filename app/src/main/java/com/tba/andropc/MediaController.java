package com.tba.andropc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class MediaController extends AppCompatActivity {

    ImageButton play,rewind,forward,volumeup,volumedown,mute,fullscreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_controller);
        play=findViewById(R.id.play);
        rewind=findViewById(R.id.rewind);
        forward=findViewById(R.id.forward);
        fullscreen=findViewById(R.id.fullscreen);
        volumedown=findViewById(R.id.volumedown);
        volumeup=findViewById(R.id.volumeup);
        mute=findViewById(R.id.mute);
        play.setImageResource(R.drawable.playmedia);
        rewind.setImageResource(R.drawable.fastrewindmedia);
        forward.setImageResource(R.drawable.fastformedia);
        volumedown.setImageResource(R.drawable.volumedownmedia);
        volumeup.setImageResource(R.drawable.volumeupmedia);
        mute.setImageResource(R.drawable.mute);
        fullscreen.setImageResource(R.drawable.fullscreenmedia);

    }
}
