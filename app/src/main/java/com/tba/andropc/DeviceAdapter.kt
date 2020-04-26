package com.tba.andropc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tba.andropc.models.DeviceModel
import kotlinx.android.synthetic.main.devicename.view.*
import java.util.ArrayList

class DeviceAdapter(context: Context, deviceModel: ArrayList<DeviceModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var deviceList = deviceModel

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
        fun bindData(s: DeviceModel) {
            itemView.name.text= s.toString()
        }
    }
}