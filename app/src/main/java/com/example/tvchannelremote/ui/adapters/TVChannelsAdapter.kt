package com.example.tvchannelremote.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.tvchannelremote.R
import com.example.tvchannelremote.data.TVChannel

class TVChannelsAdapter(private val list: List<TVChannel>) : RecyclerView.Adapter<TVChannelsAdapter.TVChannelViewHolder>() {


    class TVChannelViewHolder(itemView: ViewGroup) : RecyclerView.ViewHolder(itemView) {

        private var channelName: TextView? = null
        private var channelNumber: TextView? = null

        init {
            channelName = itemView.findViewById(R.id.channelName)
            channelNumber = itemView.findViewById(R.id.channelNumber)
        }

        fun bind(channel: TVChannel) {
            channelName?.text = channel.channelName
            channelNumber?.text = channel.channelNumber.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVChannelViewHolder {
        return TVChannelViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.tvchannel, parent, false) as ViewGroup)
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TVChannelViewHolder, position: Int) {
        val channel: TVChannel = list[position]
        holder.bind(channel)
    }
}