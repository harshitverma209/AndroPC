package com.tba.andropc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etMain;
    Button btnMain,LeftClick,RightClick;
    String connect;
    View trackpad;
    private int KEYBOARD_MODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMain=findViewById(R.id.etText2Pc);
        btnMain=findViewById(R.id.btnSend);
        LeftClick=findViewById(R.id.btnLeftClick);
        RightClick=findViewById(R.id.btnRightClick);
        trackpad=findViewById(R.id.trackPad);




        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTextToPC();
            }
        });
        trackpad.setOnTouchListener(new View.OnTouchListener() {
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
                        BluetoothCommandService.setMode(KEYBOARD_MODE);
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
                    default:{

                    }
                }
                return true;
            }
        });

    }

    private void moveMouse(float movementInX, float movementInY) {
        Log.d("chech", movementInX+","+movementInY);
//        BluetoothCommandService.moveMouse(movementInX,movementInY);
    }

    public void sendTextToPC()
    {
        String text4PC=etMain.getText().toString();
        BluetoothCommandService.write(text4PC);
    }
}
