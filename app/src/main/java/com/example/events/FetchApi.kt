package com.example.events

import retrofit2.Call
import retrofit2.http.GET

interface FetchApi {
    companion object {
        val BASE_URL = "https://opencollective.com/sustainoss/"
    }
    @GET("events.json")
    fun getEvents(): Call<List<Event>>

}