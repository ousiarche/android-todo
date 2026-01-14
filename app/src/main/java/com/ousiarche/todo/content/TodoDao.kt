package com.ousiarche.todo.content

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun getAllTodos(): LiveData<List<Todo>>

    @Insert
    suspend fun insertTodo(todo: Todo)

    @Query("UPDATE todo SET completion = :completion WHERE id = :id")
    suspend fun updateCompletion(id: Long, completion: Boolean)

    @Query("DELETE FROM todo WHERE id = :id")
    suspend fun deleteTodo(id: Long)
}