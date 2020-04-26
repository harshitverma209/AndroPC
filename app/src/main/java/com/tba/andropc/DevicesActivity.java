package com.tba.andropc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;

import java.util.UUID;

public class DevicesActivity extends AppCompatActivity {
    private BluetoothAdapter bluetoothAdapter;
    RecyclerView deviceList;
    public UUID uuid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);
        bluetoothAdapter =BluetoothAdapter.getDefaultAdapter();
        uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

//        deviceList=new RecyclerView(this,);
    }
    private void scanDevices(){
        bluetoothAdapter.startDiscovery();
    }
    public void enableBT(){
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!bluetoothAdapter.isEnabled()){
            mBluetoothAdapter.enable();
        }

    }
    public void disableBT(){
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter.isEnabled()){
            mBluetoothAdapter.disable();
        }
    }
}
