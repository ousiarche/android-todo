package com.ousiarche.todo.fragment

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BottomSheetTextField(content: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = content,
        onValueChange = onValueChange,
        label = { Text("Todo") },
        modifier = Modifier
            .fillMaxWidth()
    )
}