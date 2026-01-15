package com.ousiarche.todo.todo.model

import android.content.Context

class TodoRepository(context: Context) {

    private val db = TodoDatabase.getInstance(context)
    private val todoDao = db.todoDao()

    suspend fun addTodo(content: String, startingDate: Long, endingDate: Long) {
        val todo = Todo(
            content = content,
            startingDate = startingDate,
            endingDate = endingDate
        )

        todoDao.insertTodo(todo)
    }

    suspend fun completeTodo(id: Long) {
        todoDao.completeTodo(id)
    }

}