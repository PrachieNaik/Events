package com.example.events

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var eventList:List<Event>?=null
    var eventRepository= EventRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eventRepository.getEventData(
            object : CallBack<List<Event>>
            {
                override fun onError() {
                    Log.e("MainActivity","onError")
                }
                override fun onSuccess(list: List<Event>?) {
                    eventList=list
                    setEventData()
                }
            }
        )
    }

    fun setEventData()
    {

    }
}
