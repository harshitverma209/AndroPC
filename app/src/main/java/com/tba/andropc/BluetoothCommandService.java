package com.tba.andropc;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Bundle;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class BluetoothCommandService {
    UUID=
    private static BluetoothAdapter bluetoothAdapter;
    private static BluetoothSocket bluetoothSocket;

    public BluetoothCommandService(Context context){
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
    }

    public static BluetoothAdapter getAdapter() {
        return bluetoothAdapter;
    }

    public static void connect(BluetoothDevice device){
        bluetoothSocket=device.createRfcommSocketToServiceRecord(UUID);
    }
    public static void scanDevices(){
        bluetoothAdapter.startDiscovery();
    }
    public static void enableBT(){
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!bluetoothAdapter.isEnabled()){
            mBluetoothAdapter.enable();
        }

    }
    public static void disableBT(){
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter.isEnabled()){
            mBluetoothAdapter.disable();
        }
    }
}