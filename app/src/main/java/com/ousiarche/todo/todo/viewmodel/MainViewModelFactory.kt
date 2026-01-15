package com.ousiarche.todo.todo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ousiarche.todo.todo.model.TodoRepository
import com.ousiarche.todo.todo.view.stateWrapper.BottomSheetStateWrapper

class MainViewModelFactory(
    private val repository: TodoRepository,
    private val bottomSheetStateWrapper: BottomSheetStateWrapper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository, bottomSheetStateWrapper) as T
        }

        throw IllegalArgumentException("Unknown viewmodel class")
    }

}