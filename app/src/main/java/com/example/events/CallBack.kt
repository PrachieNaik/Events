package com.example.events

interface CallBack<T> {
    fun onSuccess(list: List<Event>?)
    fun onError()
}