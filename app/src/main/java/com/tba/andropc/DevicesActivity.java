package com.tba.andropc;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tba.andropc.models.DeviceModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DevicesActivity extends AppCompatActivity {
    private BluetoothAdapter bluetoothAdapter;
    RecyclerView deviceRecyclerView;
    private ArrayList<DeviceModel> devicesList;
    public UUID uuid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_devices);

        deviceRecyclerView=findViewById(R.id.rec);

        deviceAdapter dev= new deviceAdapter(this);
        deviceRecyclerView.setAdapter(dev);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(RecyclerView.VERTICAL);

        deviceRecyclerView.setLayoutManager(lm);

        bluetoothAdapter =BluetoothAdapter.getDefaultAdapter();
        enableBT();

        uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
        IntentFilter filter = new IntentFilter();

        filter.addAction(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);

        registerReceiver(mReceiver, filter);

        scanDevices();
        devicesList=new ArrayList<DeviceModel>();








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

                BluetoothDevice device =  intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                DeviceModel deviceModel = new DeviceModel(device.getName(),device.getAddress());
                devicesList.add(deviceModel);
                Log.d("chech","got it");
                showToast("Found device " + device.getName());
                update();
            }
        }
    };

    private void update() {
        synchronized (deviceRecyclerView){
        deviceRecyclerView.getAdapter().notify();
        }
    }

    private void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disableBT();
        unregisterReceiver(mReceiver);
    }
}
