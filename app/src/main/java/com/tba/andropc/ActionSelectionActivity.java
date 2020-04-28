package com.tba.andropc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActionSelectionActivity extends AppCompatActivity {

    private String deviceMac;

    Button act_trackpad ,mouse,media;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_selection);

        Intent intent=getIntent();

        deviceMac=intent.getStringExtra("deviceMac");
        BluetoothDevice device = BluetoothCommandService.getAdapter().getRemoteDevice(deviceMac);
        BluetoothCommandService.connect(device);
        mouse=findViewById(R.id.mousepad);
        media=findViewById(R.id.media);
        mouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(ActionSelectionActivity.this,TrackPad.class);
                startActivity(i);

            }
        });media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(ActionSelectionActivity.this,MediaController.class);
                startActivity(i);

            }
        });
        act_trackpad=findViewById(R.id.act_trackpad);
        act_trackpad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActionSelectionActivity.this, MainActivity.class);
                intent.putExtra("deviceMac",deviceMac);
                startActivity(intent);
            }
        });
    }



}
