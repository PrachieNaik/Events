package com.example.events

class EventViewModel {
    var eventRepository=EventRepository()

    fun getEventData(callBack: CallBack<List<Event>>){
        eventRepository.getEventData(callBack)
    }
}