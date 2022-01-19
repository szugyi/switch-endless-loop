package com.example.switchloop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.switchloop.ui.theme.SwitchLoopTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwitchLoopTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var checkedChangeEvent by remember { mutableStateOf(true) }
                    var checked by remember { mutableStateOf(true) }

                    LaunchedEffect(checkedChangeEvent) {
                        delay(100)
                        checked = checkedChangeEvent
                    }

                    Switch(
                        checked = checked,
                        onCheckedChange = { isChecked ->
                            checkedChangeEvent = isChecked
                        }
                    )
                }
            }
        }
    }
}
