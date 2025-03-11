package com.example.parch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun ListPage(viewModel: ToDoViewModel) {
    val todoList by viewModel.todoList.observeAsState()
    var inputText by remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        // Input text row
//        Row (
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            TextField(value = inputText, onValueChange = { inputText = it})
//            Button(onClick = {
//                viewModel.addToDo(title = inputText)
//                inputText = ""
//            }) {
//                Text(text = "add")
//            }
//        }

        // Column of added to-do
        todoList?.let {
            LazyColumn(
                content = {
                    itemsIndexed(it) { index: Int, item: ToDo ->
                        ToDoItem(
                            item = item,
                            onDelete = { viewModel.deleteToDo(item.id) },
                            onEdit = { }
                        )
                    }
                }
            )
        }?: Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "No items in list.",
            fontSize = 20.sp
        )

        BottomSheet(viewModel)
    }
}

@Composable
fun ToDoItem(item: ToDo, onEdit: ()-> Unit, onDelete : ()-> Unit) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = item.title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = item.details,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
                color = Color.White
            )
            Text(
                text = SimpleDateFormat("HH:mm:aa, dd/mm/yy", Locale.ENGLISH).format(item.createdAt),
                fontSize = 10.sp,
                fontWeight = FontWeight.ExtraLight,
                color = Color.LightGray
            )
        }
        Column {
            IconButton(onClick = onEdit) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_add_circle_outline_24),
                    contentDescription = "Edit",
                    tint = Color.White
                )
            }
            IconButton(onClick = onDelete) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                    contentDescription = "Delete",
                    tint = Color.White
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(viewModel: ToDoViewModel) {
    var inputTitle by remember {
        mutableStateOf("")
    }
    var inputDetails by remember {
        mutableStateOf("")
    }
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    val sheetState = rememberModalBottomSheetState()

    FloatingActionButton(
        onClick = {
            isSheetOpen = true
        }
    ) { }

    if (isSheetOpen) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isSheetOpen = false
            }
        ) {
            TextField(value = inputTitle, onValueChange = { inputTitle = it })
            TextField(value = inputDetails, onValueChange = { inputDetails = it })
            Button(onClick = {
                viewModel.addToDo(title = inputTitle, details = inputDetails)
                inputTitle = ""
                inputDetails = ""
            }) {
                Text(text = "add")
            }
        }
    }
}