package com.example.parch

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date

@Entity
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String = "",
    var details: String = "",
    var createdAt: Date = Date.from(Instant.now())
)