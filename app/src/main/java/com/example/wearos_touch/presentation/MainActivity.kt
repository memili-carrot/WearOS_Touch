package com.example.wearos_touch.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                TouchTrackerScreen()
            }
        }
    }
}

@Composable
fun TouchTrackerScreen() {
    var x by remember { mutableStateOf(0f) }
    var y by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    x = offset.x
                    y = offset.y
                }
            },
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "터치 좌표",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "X: ${x.toInt()}   Y: ${y.toInt()}",
            modifier = Modifier.padding(8.dp)
        )
    }
}