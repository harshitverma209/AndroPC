package com.tba.andropc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;

import java.util.UUID;

public class DevicesActivity extends AppCompatActivity {
    private BluetoothAdapter BA;
    RecyclerView deviceList;
    public UUID uuid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);
        BA=BluetoothAdapter.getDefaultAdapter();
        uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
        
//        deviceList=new RecyclerView(this,);
    }
    private void scanDevices(){
        BA.startDiscovery();
    }
}
