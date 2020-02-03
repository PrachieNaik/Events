package com.example.events

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    object EventManager{
        init {
            println("Singleton class invoked.")
        }
        fun getEventData(): List<Event>?{
            var events:List<Event>?=null
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(FetchApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()

            var fetchApi = retrofit.create(FetchApi::class.java)


            val call: Call<List<Event>> = fetchApi.events
            call.enqueue(object: Callback<List<Event>>        //will be executed on different code
            {
                override fun onFailure(call: Call<List<Event>>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<List<Event>>?, response: Response<List<Event>>?) {
                    if(!response!!.isSuccessful)
                    {
                        return
                    }
                    events= response.body()


                }

            })
            return events
        }


    }
