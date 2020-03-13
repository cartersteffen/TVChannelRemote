package com.example.tvchannelremote.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tvchannelremote.R
import com.example.tvchannelremote.data.TVChannel
import com.example.tvchannelremote.ui.adapters.TVChannelsAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private val tvChannels = listOf(
        TVChannel("CBS", 4),
        TVChannel("ABC", 5),
        TVChannel("FOX", 9),
        TVChannel("NBC", 11)
    )

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview_tvchannels.layoutManager = LinearLayoutManager(activity)
        recyclerview_tvchannels.adapter = TVChannelsAdapter(tvChannels)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            text_home.text = it
        })
    }
}
