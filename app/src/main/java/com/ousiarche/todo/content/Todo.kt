package com.ousiarche.todo.content

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.ousiarche.todo.converter.DateTimeConverter
import java.time.LocalDateTime

@Entity
@TypeConverters(DateTimeConverter::class)
data class Todo (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val content: String,
    @ColumnInfo(name = "creation_date")
    val creationDate: LocalDateTime,
    @ColumnInfo(name = "starting_date")
    val startingDate: LocalDateTime,
    @ColumnInfo(name = "ending_date")
    val endingDate: LocalDateTime,
    val completion: Boolean,
)