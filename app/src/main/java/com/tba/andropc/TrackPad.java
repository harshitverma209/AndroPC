package com.tba.andropc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class TrackPad extends AppCompatActivity {

    Button leftClickPad,rightClickPad;

    private int NO_MODE=0;
    private int MOUSE_MODE=2;
    View trackPadFull;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_pad);

        leftClickPad=findViewById(R.id.btnLeftClick);
        rightClickPad=findViewById(R.id.btnRightClick);
        trackPadFull=findViewById(R.id.trackPad);
        trackPadFull.setOnTouchListener(new View.OnTouchListener() {
            float posX,posY;
            float newPosX,newPosY;
            float movementInX,movementInY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                Log.d("chech", event.getActionMasked()+"");
                switch(event.getActionMasked()){
                    case MotionEvent.ACTION_DOWN: {
                        Log.d("chech", "Down!");
                        posX=event.getX();
                        posY=event.getY();
                        BluetoothCommandService.setMode(MOUSE_MODE);
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
//                        Log.d("chech", "Move");
                        newPosX=event.getX();
                        newPosY=event.getY();
                        movementInX=posX-newPosX;
                        movementInY=posY-newPosY;
                        posX=newPosX;
                        posY=newPosY;
                        moveMouse(movementInX,movementInY);
                        break;
                    }
                    case MotionEvent.ACTION_UP:{

                        BluetoothCommandService.setMode(NO_MODE);
                    }
                    default:{

                    }
                }
                return true;
            }
        });

    }

    private void moveMouse(float movementInX, float movementInY) {
//        Log.d("chech", movementInX+","+movementInY);
        BluetoothCommandService.moveMouse(movementInX,movementInY);
    }
}
