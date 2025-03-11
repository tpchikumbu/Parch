package com.example.parch.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.parch.ToDo

@Database(entities = [ToDo::class], version = 1)
@TypeConverters(Converters::class)
abstract class todoDB : RoomDatabase(){

    companion object {
        const val NAME = "todo_DB"
    }

    abstract fun getToDoDAO() : todoDAO
}