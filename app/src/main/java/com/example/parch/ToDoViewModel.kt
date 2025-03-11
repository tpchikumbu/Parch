package com.example.parch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parch.db.todoDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class ToDoViewModel : ViewModel() {
//    private var _todoList = MutableLiveData<List<ToDo>>()
//    val todoList : LiveData<List<ToDo>> = _todoList

    val toDoDAO = MainApplication.todoDatabase.getToDoDAO()
    val todoList : LiveData<List<ToDo>> = toDoDAO.getAllToDo()

//    fun getAllToDo(){
//        _todoList.value = ToDoManager.getAllToDo().reversed()
//    }

    fun addToDo(title: String, details: String = "") {
        viewModelScope.launch(Dispatchers.IO) {
            toDoDAO.addToDo(ToDo(title = title, details = details, createdAt = Date.from(Instant.now()) ) )
        }
    }

//    fun editToDo(id: Int, title: String, details: String = "") {
//        viewModelScope.launch(Dispatchers.IO) {
//            toDoDAO.editToDo(id, title, details)
//        }
//    }

    fun deleteToDo(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            toDoDAO.deleteToDo(id)
        }

    }
}