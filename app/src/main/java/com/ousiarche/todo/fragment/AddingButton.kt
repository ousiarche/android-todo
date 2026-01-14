package com.ousiarche.todo.fragment

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.ousiarche.todo.content.Todo
import com.ousiarche.todo.content.TodoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddingButton(modifier: Modifier,
                 text: String,
                 scope: CoroutineScope,
                 sheetState: SheetState
) {

    val db = TodoDatabase.getInstance(context = LocalContext.current)

    OutlinedButton (
        onClick = {
            scope.launch {
                // TODO: Fix to insert(content, startingDate, endingDate)
                db.todoDao().insertTodo(Todo(
                    content = text,
                    creationDate = LocalDateTime.now(),
                    startingDate = LocalDateTime.now(),
                    endingDate = LocalDateTime.now(),
                    completion = false
                ))

                sheetState.hide()
            }
        },
        modifier = modifier
    ) {
        Text("추가")
    }
}
