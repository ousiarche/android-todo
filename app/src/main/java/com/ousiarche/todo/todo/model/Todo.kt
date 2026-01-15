package com.ousiarche.todo.todo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val content: String,
    @ColumnInfo(name = "creation_date")
    val creationDate: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "starting_date")
    val startingDate: Long,
    @ColumnInfo(name = "ending_date")
    val endingDate: Long,
    val completion: Boolean = false,
)