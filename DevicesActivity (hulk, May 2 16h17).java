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
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class DevicesActivity extends AppCompatActivity {
    private BluetoothAdapter bluetoothAdapter;
    RecyclerView deviceRecyclerView;
    private Set<DeviceModel> devicesList;
    public UUID uuid;
    DeviceAdapter dev;
    private ArrayList<DeviceModel> devicesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("chech", "Oncreate()");
        setContentView(R.layout.activity_devices);
        deviceRecyclerView=findViewById(R.id.rec);


//        Log.d("chech", "OnStart()");
        BluetoothCommandService.init(this);

        bluetoothAdapter =BluetoothAdapter.getDefaultAdapter();


        uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

        IntentFilter filter = new IntentFilter();
        if(!bluetoothAdapter.isEnabled()) {
            BluetoothCommandService.enableBT();
            filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        }
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);


        registerReceiver(mReceiver, filter);


        devicesList=new HashSet<DeviceModel>();
        devicesArrayList=new ArrayList<DeviceModel>();
        dev= new DeviceAdapter(this, devicesArrayList);
        deviceRecyclerView.setAdapter(dev);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(RecyclerView.VERTICAL);

        deviceRecyclerView.setLayoutManager(lm);


        BluetoothCommandService.scanDevices();











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
                Log.d("chech",devicesList.contains(deviceModel)+"");
                if(!devicesList.contains(deviceModel)) {
//                    devicesArrayList.add(deviceModel);
                    Log.d("chech","Not present");
                    devicesList.add(deviceModel);
                    devicesArrayList.add(deviceModel);
                    Log.d("chech", devicesList.size()+"");
                    showToast("Found device " + device.getName());
                    update();
                }
            }else if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)) {
                //Bluetooth Turned On, most probably
                BluetoothCommandService.scanDevices();
            }
        }
    };

    private void update() {
        synchronized (dev){
        dev.notifyDataSetChanged();
//        dev.notify();
//        Log.d("chech", "Notified");

        }

    }

    private void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BluetoothCommandService.disableBT();
        unregisterReceiver(mReceiver);
    }




}
