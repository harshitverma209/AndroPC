package com.tba.andropc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MediaController extends AppCompatActivity {
    private final String PLAY="1",REWIND="2",FORWARD="3",VOLUMEUP="4",VOLUMEDOWN="5",MUTE="6",FULLSCREEN="7";
    private final int NO_MODE=0,MEDIA_MODE=3;
    ImageButton play,rewind,forward,volumeup,volumedown,mute,fullscreen;
    View.OnClickListener mediaControlsListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_controller);
        BluetoothCommandService.setMode(MEDIA_MODE);
        play=findViewById(R.id.play);
        rewind=findViewById(R.id.rewind);
        forward=findViewById(R.id.forward);
        fullscreen=findViewById(R.id.fullscreen);
        volumedown=findViewById(R.id.volumedown);
        volumeup=findViewById(R.id.volumeup);
        mute=findViewById(R.id.mute);
      //  play.setImageResource(R.drawable.playmedia);
        rewind.setImageResource(R.drawable.fastrewindmedia);
        forward.setImageResource(R.drawable.fastformedia);
        volumedown.setImageResource(R.drawable.volumedownmedia);
        volumeup.setImageResource(R.drawable.volumeupmedia);
        mute.setImageResource(R.drawable.mute);
        fullscreen.setImageResource(R.drawable.fullscreenmedia);
        initMediaControlsListener();
        play.setOnClickListener(mediaControlsListener);
        rewind.setOnClickListener(mediaControlsListener);
        forward.setOnClickListener(mediaControlsListener);
        volumeup.setOnClickListener(mediaControlsListener);
        volumedown.setOnClickListener(mediaControlsListener);
        fullscreen.setOnClickListener(mediaControlsListener);
        mute.setOnClickListener(mediaControlsListener);

    }

    private void initMediaControlsListener() {
        mediaControlsListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.play:
                    {
                        BluetoothCommandService.write(PLAY);
                        break;
                    }
                    case R.id.volumeup:
                    {
                        BluetoothCommandService.write(VOLUMEUP);
                        break;
                    }
                    case R.id.volumedown:
                    {
                        BluetoothCommandService.write(VOLUMEDOWN);
                        break;
                    }
                    case R.id.fullscreen:
                    {
                        BluetoothCommandService.write(FULLSCREEN);
                        break;
                    }
                    case R.id.forward:
                    {
                        BluetoothCommandService.write(FORWARD);
                        break;
                    }
                    case R.id.rewind:
                    {
                        BluetoothCommandService.write(REWIND);
                        break;
                    }
                    case R.id.mute:
                    {
                        BluetoothCommandService.write(MUTE);
                        break;
                    }
                    default:
                    {

                    }
                }

            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("chech", "MediaController destroyed");
        BluetoothCommandService.setMode(NO_MODE);
    }
}
