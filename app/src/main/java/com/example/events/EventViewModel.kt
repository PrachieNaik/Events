package com.example.events
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData




class EventViewModel : ViewModel() {
    var eventRepository = EventRepository()
    var events =  MutableLiveData<List<Event>>()
    var eventList = ArrayList<Event>()


    fun getEventData() {
        if(eventList.isNotEmpty())
            return

        eventRepository.getEventData(object : CallBack<List<Event>>
        {
            override fun onError() {
                Log.e("MainActivity","onError")
            }
            override fun onSuccess(list: List<Event>?) {
                Log.e("EVM"," list ${list?.size}")
                list?.let {
                    eventList.addAll(it)
                    events.postValue(it)
                }


            }

        })
    }
}
