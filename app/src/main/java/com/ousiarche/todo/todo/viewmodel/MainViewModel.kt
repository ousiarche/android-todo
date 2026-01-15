package com.ousiarche.todo.todo.viewmodel

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ousiarche.todo.todo.model.TodoRepository
import com.ousiarche.todo.todo.view.stateWrapper.BottomSheetStateWrapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class MainViewModel(
    private val repository: TodoRepository,
    bottomSheetStateWrapper: BottomSheetStateWrapper,
): ViewModel() {

    private val _bottomSheetState = MutableStateFlow(bottomSheetStateWrapper)
    val bottomSheetState = _bottomSheetState.asStateFlow()

    @OptIn(ExperimentalMaterial3Api::class)
    fun onFloatingButtonClicked() {
        viewModelScope.launch {
            _bottomSheetState.update { it.copy(showSheet = true) }
        }
    }

     @OptIn(ExperimentalMaterial3Api::class)
     fun onAddClicked(content: String,
                      startingDate: String,
                      endingDate: String,

    ) {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

        viewModelScope.launch {
            repository.addTodo(
                content,
                LocalDateTime.parse(startingDate, formatter)
                    .atZone(ZoneId.systemDefault())
                    .toInstant()
                    .toEpochMilli(),
                LocalDateTime.parse(endingDate, formatter)
                    .atZone(ZoneId.systemDefault())
                    .toInstant()
                    .toEpochMilli()
            )

            _bottomSheetState.update { it.copy(showSheet = false) }
        }

    }

}