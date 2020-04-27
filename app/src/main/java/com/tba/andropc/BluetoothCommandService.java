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
    private static UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static BluetoothAdapter bluetoothAdapter;
    private static BluetoothSocket bluetoothSocket;

    public BluetoothCommandService(Context context){
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
    }

    public static BluetoothAdapter getAdapter() {
        return bluetoothAdapter;
    }

    public static void connect(BluetoothDevice device){
        try {
            bluetoothSocket=device.createRfcommSocketToServiceRecord(uuid);
            bluetoothSocket.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
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