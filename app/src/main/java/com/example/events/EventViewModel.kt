package com.example.events
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class EventViewModel : ViewModel() {
    var eventRepository = EventRepository()
    var events =  MutableLiveData<List<Event>>()
    var temp:LiveData<List<Event>>?=null
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
                Log.e("EVM","onError")
            }
            override fun onSuccess(list: List<Event>?) {
                list?.let {

                    events.postValue(it)
                    eventList.addAll(it)
                    eventRepository.addToDb(dbInstance,eventList)
                }
            }
        })
    }
    fun getDatafromDb() = eventRepository.getFromDb(dbInstance)

}