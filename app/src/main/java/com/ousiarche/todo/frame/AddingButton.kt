package com.ousiarche.todo.frame

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddingButton(modifier: Modifier) {
    OutlinedButton (
        onClick = { TODO("Feature adding todo") },
        modifier = modifier
    ) {
        Text("추가")
    }
}
