package com.example.events

import android.widget.ImageView
import java.util.*

data class Event (
    var events:String,
    var id:Int=0,
    var name:String="",
    var description:String="",
    var slug:String="",
    var image:ImageView?=null,
    var startsAt: Date?=null,
    var endsAt:Date?=null,
    var timezone:TimeZone,
    var location:String="",
    var url:String=""

)