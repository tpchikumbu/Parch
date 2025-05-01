package com.example.parch.db

import androidx.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
//import com.example.parch.db.todoDB

@Module
@InstallIn(SingletonComponent::class)
object dbModule {
    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context): todoDB =
        Room.databaseBuilder(context, todoDB::class.java,
            todoDB.NAME
        ).build()

    @Provides
    fun providesToDoDao(db: todoDB): todoDAO = db.getToDoDAO()


}