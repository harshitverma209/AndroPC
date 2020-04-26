package com.tba.andropc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DevicesActivity extends AppCompatActivity {
    RecyclerView deviceList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);
        deviceList=new RecyclerView(this,);
    }
}
