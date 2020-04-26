package com.tba.andropc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText etMain;
Button btnMain;
String connect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMain=findViewById(R.id.etText2Pc);
        btnMain=findViewById(R.id.btnSend);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            connect=etMain.getText().toString();
            }
        });


    }
    public void sendTextToPC()
    {

    }
}
