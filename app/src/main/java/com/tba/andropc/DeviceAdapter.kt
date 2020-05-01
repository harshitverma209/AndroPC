package com.tba.andropc

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tba.andropc.models.DeviceModel
import kotlinx.android.synthetic.main.devicename.view.*
import java.util.*

class DeviceAdapter(context: Context, deviceModel: ArrayList<DeviceModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var deviceList = deviceModel
    var context=context;

    private val mLayoutInflater by lazy { LayoutInflater.from(context) }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DeviceViewHolder(mLayoutInflater.inflate(R.layout.devicename, parent, false))

    }

    override fun getItemCount(): Int {
        return deviceList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as DeviceViewHolder).bindData(deviceList[position])
    }

    inner class DeviceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(dev: DeviceModel) {
            itemView.name.text= dev.deviceName;
            itemView.address.text=dev.deviceMac;
            itemView.setOnClickListener {
                val intent = Intent(context,ActionSelectionActivity::class.java)
                intent.putExtra("deviceMac",dev.deviceMac)
                context.startActivity(intent)
            }
        }
    }
}