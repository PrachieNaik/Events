package com.example.events

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Event(
    var events: String = "",
    @PrimaryKey var id: Int = 0,
    var name: String = "",
    var description: String = "",
    var slug: String = "",
    var image: String = "",
    var startsAt: String = "",
    var endsAt: String = "",
    var timezone: String = "",
    //   var location:Location?=null,
    var url: String = "",
    var isChecked: Boolean = false
)
//) {
//    @PrimaryKey(autoGenerate = true)
//    var identity: Int = 0
//}