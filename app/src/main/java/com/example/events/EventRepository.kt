package com.example.events
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class EventRepository{
    var eventManager=EventManager

    fun addToDb(dbInstance:EventDatabase,eventList: ArrayList<Event>)
    {
        for(element in eventList) {
           dbInstance.eventDao().insert(element)
        }
    }
    fun getFromDb(dbInstance:EventDatabase): LiveData<List<Event>>
    {
        return dbInstance.eventDao().getAllEvents()
    }
    fun getEventData(callBack: CallBack<List<Event>>){
        eventManager.getEventData(callBack)
    }
}