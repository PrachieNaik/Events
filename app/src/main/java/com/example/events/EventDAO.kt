package com.example.events

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EventDAO {

    @Insert
    fun insertAll(vararg events: Event)

    @Query("SELECT * FROM event")
    fun getAllEvents() : LiveData<List<Event>>


}
