package com.tba.andropc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText etMain;
Button btnMain,LeftClick,RightClick;
String connect;
View trackpad;
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
            connect=etMain.getText().toString();
            }
        });
        trackpad.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN: {
                        break;
                    }
                    case MotionEvent.ACTION_MOVE:{
                        
                        break;
                    }
                }
                return false;
            }
        });

    }
    public void sendTextToPC()
    {

    }
}
