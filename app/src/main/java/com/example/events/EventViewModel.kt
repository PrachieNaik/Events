package com.example.events
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class EventViewModel : ViewModel() {
    var eventRepository = EventRepository()
    var events =  MutableLiveData<List<Event>>()
    var eventList = ArrayList<Event>()
    lateinit var dbInstance:EventDatabase
    fun getDbInstance(db:EventDatabase)
    {
        dbInstance=db
    }
    fun getEventData() {
        if(eventList.isNotEmpty())
            return

        eventRepository.getEventData(object : CallBack<List<Event>>
        {
            override fun onError() {
                Log.e("MainActivity","onError")
            }
            override fun onSuccess(list: List<Event>?) {
                list?.let {
                    eventList.addAll(it)
                    events.postValue(it)
                    eventRepository.addToDb(dbInstance,eventList)


            }

        }
    })
}
}