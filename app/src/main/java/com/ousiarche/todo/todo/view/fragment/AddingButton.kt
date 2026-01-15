package com.ousiarche.todo.todo.view.fragment

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ousiarche.todo.todo.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddingButton(modifier: Modifier,
                 text: String,
                 viewModel: MainViewModel,
) {
    OutlinedButton (
        onClick = {
            viewModel.onAddClicked(
                text,
                "2026-01-15 19:30",
                "2026-01-15 20:30",
            )
        },
        modifier = modifier
    ) {
        Text("추가")
    }
}
