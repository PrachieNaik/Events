package com.example.events

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    var eventList:List<Event>?=null

    lateinit var eventViewModel: EventViewModel
    val adapter = EventRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        eventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)

        eventsRecyclerView.layoutManager= LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        eventsRecyclerView.adapter = adapter

        eventViewModel.events.observe(this, Observer {
            Log.e("MA"," list ${it.size}")
            adapter.updateList(it)
        })

        eventViewModel.getEventData()



    }


}

