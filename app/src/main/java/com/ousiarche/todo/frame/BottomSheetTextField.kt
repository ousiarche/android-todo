package com.ousiarche.todo.frame

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun BottomSheetTextField(content: String = "") {
    var text by remember { mutableStateOf(content) }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Todo") },
        modifier = Modifier
            .fillMaxWidth()
    )
}