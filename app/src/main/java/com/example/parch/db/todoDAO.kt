package com.example.parch.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.parch.ToDo

@Dao
interface todoDAO {

    @Query("SELECT * FROM TODO")
    fun getAllToDo() : LiveData<List<ToDo>>

    @Insert
    fun addToDo(todo: ToDo)

    @Query("UPDATE TODO SET title = :title, details = :details WHERE id = :id")
    fun editToDo(id: Int, title: String, details: String = "")

    @Query("DELETE FROM TODO WHERE id = :id")
    fun deleteToDo(id: Int)
}