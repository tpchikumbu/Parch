//package com.example.parch
//
//import android.telecom.Call.Details
//import java.time.Instant
//import java.util.Date
//
//object ToDoManager {
//    private val todoList = mutableListOf<ToDo>()
//
//    fun getAllToDo() : List<ToDo>{
//        return todoList
//    }
//
//    fun addToDo(title: String, details: String = "") {
//        todoList.add(ToDo(System.currentTimeMillis().toInt(), title, details, Date.from(Instant.now())))
//    }
//
//    fun editToDo(id: Int, title: String, details: String = "") {
//        for (i in todoList.indices) {
//            if (todoList[i].id == id) {
//                todoList[i].title = title
//                todoList[i].details = details
//            }
//        }
//    }
//
//    fun deleteToDo(id: Int) {
//        todoList.removeIf{
//            it.id == id
//        }
//    }
//}