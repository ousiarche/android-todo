package com.ousiarche.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.ousiarche.todo.frame.BottomSheet
import com.ousiarche.todo.frame.FloatingButton
import com.ousiarche.todo.ui.theme.TodoTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoTheme {
                val sheetState = rememberModalBottomSheetState()
                val scope = rememberCoroutineScope()

                Scaffold(
                    floatingActionButton = { FloatingButton { scope.launch { sheetState.show() }} },
                ) {
                    innerPadding ->
                        Box(
                            modifier = Modifier
                                .padding(innerPadding)
                        ) {
                            if (sheetState.isVisible) {
                                BottomSheet(
                                    sheetState = sheetState,
                                    onDismissRequest = { scope.launch { sheetState.hide() } },
                                )
                            }
                        }
                }
            }
        }
    }
}