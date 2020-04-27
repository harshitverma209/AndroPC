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




    // Local Bluetooth adapter
    private BluetoothAdapter mBluetoothAdapter = null;
    // Member object for Bluetooth Command Service
    private BluetoothCommandService mCommandService = null;
    private String deviceMac;

    Button act_trackpad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_selection);
        setupCommand();
        Intent intent=getIntent();

        mBluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        deviceMac=intent.getStringExtra("deviceMac");
        BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(deviceMac);
        mCommandService.connect(device);

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
    private void setupCommand() {
        // Initialize the BluetoothChatService to perform bluetooth connections
        mCommandService = new BluetoothCommandService(this);
    }


}
