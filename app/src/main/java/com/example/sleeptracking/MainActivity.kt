package com.example.sleeptracking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.sleeptracking.ui.theme.SleepTrackingTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SleepTrackingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    
                   Greeting()
                }
            }
        }
    }
}

/*@Composable
fun Timr(){
    var ticks by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        while(true) {
            delay(1.seconds)
            ticks++
        }
    }
    Column() {
        Text(text = ticks.toString())
    }
}*/

@Composable
fun Greeting() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        var b by remember {
            mutableStateOf(false)
        }
        var ticks by remember { mutableStateOf(0) }
        var status by remember { mutableStateOf("") }
        var result by remember { mutableStateOf(0) }

        if (b) {
            LaunchedEffect(Unit) {
                while (true) {
                    delay(1.seconds)
                    ticks++
                }
            }
        }
        if (b){
            status="clock running"
            result=0
        } else{
            status="clock stopped"
            result=ticks

        }

        Text(text = ticks.toString(), fontSize = 32.sp,
            color = Color.Green)
        Button(onClick = {
            b = !b

        }) {
            Text(text = status)
        }

        var min = (result).div(60).toDouble()
        if (min<60){
            Text(text = "You have slept for $min Seconds")
        } else{
            Text(text = "You have slept for $min Minutes")
        }
    }
}