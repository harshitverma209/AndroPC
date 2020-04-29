package com.tba.andropc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MediaController extends AppCompatActivity {
    final String PLAY="1",REWIND="2",FORWARD="3",VOLUMEUP="4",VOLUMEDOWN="5",SILENT="6",FULLSCREEN="7";
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
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BluetoothCommandService.write(PLAY);
            }
        });
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BluetoothCommandService.write(REWIND);
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BluetoothCommandService.write(FORWARD);
            }
        });
        fullscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BluetoothCommandService.write(FULLSCREEN);
            }
        });
        volumeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BluetoothCommandService.write(VOLUMEUP);
            }
        });
        volumedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BluetoothCommandService.write(VOLUMEDOWN);
            }
        });
        mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BluetoothCommandService.write(SILENT);
            }
        });
    }
}
