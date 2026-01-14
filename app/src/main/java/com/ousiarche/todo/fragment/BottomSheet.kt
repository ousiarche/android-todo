package com.ousiarche.todo.fragment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    sheetState: SheetState,
    scope: CoroutineScope,
    onDismissRequest: () -> Unit,
    ) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp, 0.dp)
            ) {
                val content: String = ""
                var text by remember { mutableStateOf(content) }
                BottomSheetTextField(text, { text = it })
                AddingButton(modifier = Modifier.align(Alignment.End),
                    text = text,
                    scope = scope,
                    sheetState = sheetState)
            }
    }
}