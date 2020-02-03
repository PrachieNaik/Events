package com.example.events

class EventRepository{
    var eventManager=EventManager

    fun getEventData(callBack: CallBack<List<Event>>){
        eventManager.getEventData(callBack)
    }
}