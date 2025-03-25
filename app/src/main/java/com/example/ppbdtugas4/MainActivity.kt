package com.example.ppbdtugas4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ppbdtugas4.ui.theme.PPBDTUGAS4Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PPBDTUGAS4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DiceRollerApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DiceRollerApp(modifier: Modifier = Modifier) {
    var diceValue by remember { mutableStateOf<Int?>(null) }
    var isFirstRoll by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (diceValue != null) {
            Text(
                text = diceValue.toString(),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
        if (diceValue != null) {
            val imageResource = when (diceValue) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.dice_1 // fallback
            }

            Image(
                painter = painterResource(id = imageResource),
                contentDescription = diceValue.toString(),
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))
        }

        Button(
            onClick = {
                diceValue = Random.nextInt(1, 7)
                isFirstRoll = false
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Roll Dice", fontSize = 18.sp)
        }

        if (isFirstRoll) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Pencet tombol Roll Dice untuk memulai",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerPreview() {
    PPBDTUGAS4Theme {
        DiceRollerApp()
    }
}