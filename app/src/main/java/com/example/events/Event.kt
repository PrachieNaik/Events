package com.example.events

data class Event (
    var events:String,
    var id:Int=0,
    var name:String="",
    var description:String="",
    var slug:String="",
    var image:String?="",
    var startsAt: String?="",
    var endsAt:String?="",
    var timezone:String="",
    var location:Location?=null,
    var url:String=""

)