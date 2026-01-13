package com.ousiarche.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.ousiarche.todo.frame.BottomSheet
import com.ousiarche.todo.frame.FloatingButton
import com.ousiarche.todo.ui.theme.TodoTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoTheme {
                val sheetState = rememberModalBottomSheetState()
                val scope = rememberCoroutineScope()
                var showBottomSheet by remember { mutableStateOf(false) }

                Scaffold(
                    floatingActionButton = { FloatingButton { showBottomSheet = true } },
                ) {
                    if (showBottomSheet) {
                        BottomSheet(
                            sheetState = sheetState,
                            onDismissRequest = { showBottomSheet = false }
                        )
                    }
                }
            }
        }
    }
}