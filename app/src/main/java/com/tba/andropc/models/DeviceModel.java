package com.tba.andropc.models;

public class DeviceModel {
    public DeviceModel(String deviceName, String deviceMac) {
        this.deviceName=deviceName="name not found";
        this.deviceMac=deviceMac;

    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    String deviceName;

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    String deviceMac;
}
