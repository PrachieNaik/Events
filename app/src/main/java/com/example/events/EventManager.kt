package com.example.events
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object EventManager{

    var retrofit: Retrofit
    var fetchApi:FetchApi
    init {
        retrofit= Retrofit.Builder()
            .baseUrl(FetchApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        fetchApi = retrofit.create(FetchApi::class.java)
    }
    fun getEventData(callBack: CallBack<List<Event>>){

        val call: Call<List<Event>> = fetchApi.getEvents()
        call.enqueue(object: Callback<List<Event>>        //will be executed on different code
        {
            override fun onFailure(call: Call<List<Event>>?, t: Throwable?) {
                Log.e("EventManager",t.toString())
            }
            override fun onResponse(call: Call<List<Event>>?, response: Response<List<Event>>?) {
                if(!response!!.isSuccessful)
                {
                    Log.e("EventManager",response.toString())
                }
                callBack.onSuccess(response.body())

            }

        })
    }


}
