package com.tba.andropc;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class BluetoothCommandService {
    private static UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static BluetoothAdapter bluetoothAdapter;
    private static BluetoothSocket bluetoothSocket;
    private static OutputStream out;
    private static Context context;

    public BluetoothCommandService(Context context){
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
    }
    public static void init(Context context){
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        BluetoothCommandService.context=context;
    }
    public static BluetoothAdapter getAdapter() {
        return bluetoothAdapter;
    }

    public static void connect(BluetoothDevice device){
        bluetoothAdapter.cancelDiscovery();
        try {

            if(bluetoothSocket!=null){
                bluetoothSocket.close();
            }
            Log.d("chech",device.getName());
            bluetoothSocket=device.createRfcommSocketToServiceRecord(uuid);
            bluetoothSocket.connect();
            out=bluetoothSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void scanDevices(){
        if(bluetoothAdapter.isDiscovering()){
            bluetoothAdapter.cancelDiscovery();
        }
        bluetoothAdapter.startDiscovery();
        if(bluetoothAdapter.isDiscovering()){
            Toast.makeText(context, "Scanning for Bluetooth Devices", Toast.LENGTH_SHORT).show();
        }
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
        text=text+'\0';
        try {
            out.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void write(int item) {
        try {
            out.write(item);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setMode(int mode) {
        if(mode==0){
            try {
                out.write("\0".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                out.write(mode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void moveMouse(float movementInX, float movementInY) {
        String movement="("+movementInX+","+movementInY+")";
        try {
            out.write(movement.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}