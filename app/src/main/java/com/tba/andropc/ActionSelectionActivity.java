package com.tba.andropc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActionSelectionActivity extends AppCompatActivity {


    private static final int REQUEST_CONNECT_DEVICE = 1;


    Button act_trackpad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_selection);
        act_trackpad=findViewById(R.id.act_trackpad);
        act_trackpad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActionSelectionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
