package com.tba.andropc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class deviceAdapter(context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var deviceList = mutableListOf<String>()

    private val mLayoutInflater by lazy { LayoutInflater.from(context) }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DeviceViewHolder(mLayoutInflater.inflate(R.layout.devicename, parent, false))

    }

    override fun getItemCount(): Int {
        return deviceList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    inner class DeviceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}