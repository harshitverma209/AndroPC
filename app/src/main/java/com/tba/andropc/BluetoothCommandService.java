package com.tba.andropc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class BluetoothCommandService extends Service {
    public BluetoothCommandService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
