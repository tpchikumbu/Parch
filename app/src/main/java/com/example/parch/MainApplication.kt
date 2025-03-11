package com.example.parch

import android.app.Application
import androidx.room.Room
import com.example.parch.db.todoDB

class MainApplication : Application () {

    companion object {
        lateinit var todoDatabase: todoDB
    }

    override fun onCreate() {
        super.onCreate()
        todoDatabase = Room.databaseBuilder(
            applicationContext,
            todoDB::class.java,
            todoDB.NAME
        ).build()
    }
}