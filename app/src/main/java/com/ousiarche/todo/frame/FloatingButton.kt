package com.ousiarche.todo.frame

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable

@Composable
fun FloatingButton(onClick: () -> Unit) {
    SmallFloatingActionButton(
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        Icon(
            Icons.Filled.Add,
            "Add Todo",
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}