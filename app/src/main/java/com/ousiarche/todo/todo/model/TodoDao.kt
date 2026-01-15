package com.ousiarche.todo.todo.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun selectAllTodos(): LiveData<List<Todo>>

    @Query("SELECT * FROM todo WHERE id = :id")
    fun selectTodoById(id: Long): LiveData<List<Todo>>

    @Insert
    suspend fun insertTodo(todo: Todo)

    @Query("UPDATE todo SET completion = 1 WHERE id = :id")
    suspend fun completeTodo(id: Long)

    @Query("DELETE FROM todo WHERE id = :id")
    suspend fun deleteTodo(id: Long)
}