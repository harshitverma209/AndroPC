package com.tba.andropc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.UUID;

public class BluetoothCommandService extends Service {

    private static final UUID MY_UUID = UUID.fromString("04c6093b-0000-1000-8000-00805f9b34fb");


    public BluetoothCommandService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
