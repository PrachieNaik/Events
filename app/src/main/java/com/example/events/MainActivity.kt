package com.example.events

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var eventList:List<Event>?=null

    var eventViewModel= EventViewModel()
    val adapter = EventRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        eventsRecyclerView.layoutManager= LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        eventsRecyclerView.adapter = adapter
        eventViewModel.getEventData(
            object : CallBack<List<Event>>
            {
                override fun onError() {
                    Log.e("MainActivity","onError")
                }
                override fun onSuccess(list: List<Event>?) {
                    eventList=list

                    list?.let {
                        adapter.updateList(it)
                    }


                }

            }
        )


    }


}
