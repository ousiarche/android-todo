package com.ousiarche.todo.content

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Fts4(languageId = "content")
@Entity
data class Todo (
    @PrimaryKey val id: Long,
    val content: String,
    val creationDate: LocalDateTime,
    val startingDate: LocalDateTime,
    val endingDate: LocalDateTime,
    val completion: Boolean,
)