package com.example.events

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EventRepository{
    var eventManager=EventManager
    lateinit var eventDao: EventDAO
    fun addToDb(dbInstance:EventDatabase,eventList: ArrayList<Event>)
    {
        for(element in eventList) {
           dbInstance.eventDao().insertAll(element)
        }
    }

    fun getEventData(callBack: CallBack<List<Event>>){
        eventManager.getEventData(callBack)
    }
}