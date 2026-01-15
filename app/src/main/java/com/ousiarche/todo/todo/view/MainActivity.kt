package com.ousiarche.todo.todo.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ousiarche.todo.todo.model.TodoRepository
import com.ousiarche.todo.todo.view.fragment.BottomSheet
import com.ousiarche.todo.todo.view.fragment.FloatingButton
import com.ousiarche.todo.todo.view.stateWrapper.BottomSheetStateWrapper
import com.ousiarche.todo.todo.viewmodel.MainViewModel
import com.ousiarche.todo.todo.viewmodel.MainViewModelFactory
import com.ousiarche.todo.ui.theme.TodoTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel> {
        val repository = TodoRepository(applicationContext)

        MainViewModelFactory(repository, BottomSheetStateWrapper())
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoTheme {
                val bottomSheetState by viewModel.bottomSheetState.collectAsState()
                val sheetState = rememberModalBottomSheetState()

                Scaffold(
                    floatingActionButton = { FloatingButton {
                        viewModel.onFloatingButtonClicked()
                    }},
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {
                        if (bottomSheetState.showSheet) {
                            BottomSheet(
                                sheetState = sheetState,
                                viewModel = viewModel,
                                onDismissRequest = {},
                            )
                        }
                    }
                }
            }
        }
    }
}