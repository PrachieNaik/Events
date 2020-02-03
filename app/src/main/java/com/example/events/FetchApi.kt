package com.example.events

import retrofit2.Call
import retrofit2.http.GET

interface FetchApi {
    companion object {
        val BASE_URL = "https://opencollective.com/sustainoss/"
    }
    @get:GET("events")
    val events: Call<List<Event>>

}