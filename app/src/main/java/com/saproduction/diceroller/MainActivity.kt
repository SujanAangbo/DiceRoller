package com.saproduction.diceroller

import android.os.Bundle
import android.util.Log
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saproduction.diceroller.ui.theme.DiceRollerTheme
import java.lang.StrictMath.random
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {

                DiceRollerApp()

            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize()) {
        DiceWithButtonAndImage()
    }
}

@Composable
fun DiceWithButtonAndImage() {

    var value = remember {
        mutableStateOf(1)
    }

    var imageResource = when(value.value) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = imageResource), contentDescription = imageResource.toString())
        Log.d("tag", "${imageResource.toString()}")
        Spacer(modifier = Modifier.height(8.dp))
        
        Button(onClick = {

            value.value = (1..6).random()
            Log.d("tag", "${value.value}")

        }) {
            Text(text = "Roll", modifier = Modifier.padding(8.dp), fontSize = 20.sp)
        }
    }
    
}