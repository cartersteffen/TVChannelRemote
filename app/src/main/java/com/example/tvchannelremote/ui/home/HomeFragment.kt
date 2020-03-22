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
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var mAdapter: TVChannelsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = ViewModelProviders.of(requireActivity()).get(HomeViewModel::class.java)

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview_tvchannels.layoutManager = LinearLayoutManager(activity)
        recyclerview_tvchannels.adapter = TVChannelsAdapter(homeViewModel.getTVChannels().value!!)
        mAdapter = recyclerview_tvchannels.adapter as TVChannelsAdapter
        button.setOnClickListener {
            homeViewModel.addTVChannel(TVChannel("New Channel", 20))
            //(recyclerview_tvchannels.adapter as TVChannelsAdapter).notifyDataSetChanged()
            homeViewModel.setText("New String")
            //Snackbar.make(it, "Card Added", Snackbar.LENGTH_LONG).show()
        }
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            text_home.text = it
        })
        homeViewModel.getTVChannels().observe(viewLifecycleOwner, Observer {
            mAdapter.notifyDataSetChanged()
        })
        /*val channelObserver = Observer<List<TVChannel>> {
            recyclerview_tvchannels.adapter?.notifyDataSetChanged()
        }
        homeViewModel.getTVChannels().observe(viewLifecycleOwner, channelObserver)*/
    }
}
