package com.tba.andropc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;

public class DevicesActivity extends AppCompatActivity {
    private BluetoothAdapter BA;
    RecyclerView deviceList;
    public UUID uuid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);
        BA=BluetoothAdapter.getDefaultAdapter();
        deviceList=new RecyclerView(this,);
    }
}
