package com.tba.andropc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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
        enableBT();
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
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
                Log.d("chech","discovering");

                //discovery starts, we can show progress dialog or perform other tasks
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                //discovery finishes, dismis progress dialog

            } else if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                //bluetooth device found
                Log.d("chech","got it");
                BluetoothDevice device = (BluetoothDevice) intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

//                s.add(device.getName()+"\n"+device.getAddress());
                //showToast("Found device " + device.getName());
            }
        }
    };
}
