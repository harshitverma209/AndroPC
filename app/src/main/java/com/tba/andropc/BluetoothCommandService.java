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
    private static OutputStream out;

    public BluetoothCommandService(Context context){
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
    }
    public static void init(){
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
    }
    public static BluetoothAdapter getAdapter() {
        return bluetoothAdapter;
    }

    public static void connect(BluetoothDevice device){
        try {

            if(bluetoothSocket!=null){
                bluetoothSocket.close();
            }
            bluetoothSocket=device.createRfcommSocketToServiceRecord(uuid);
            bluetoothSocket.connect();
            out=bluetoothSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void scanDevices(){
        bluetoothAdapter.startDiscovery();
    }
    public static void enableBT(){

        if (!bluetoothAdapter.isEnabled()){
            bluetoothAdapter.enable();
        }

    }
    public static void disableBT(){
        if (bluetoothAdapter.isEnabled()){
            bluetoothAdapter.disable();
        }
    }

    public static void write(String text) {
        try {
            out.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}