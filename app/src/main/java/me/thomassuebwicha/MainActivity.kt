package me.thomassuebwicha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import me.thomassuebwicha.ui.main.SleepAlarmActivity
import me.thomassuebwicha.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                    color = Color.White
                ) {
                    SleepAlarmActivity()
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.DarkGray) {
        Text(
            text = "Hi, my name is $name!",
            modifier = modifier,
            color = Color.White
        )
    }
}

@Composable
fun GreetingText(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        fontSize = 100.sp,
        lineHeight = 116.sp

    )
}

@Composable
fun NewSection() {
    Box(modifier = Modifier.fillMaxSize()) {
        Surface {
            Text(
                text = "This is another text line",
                fontSize = 100.sp
            )
        }
    }
}



@Preview(showBackground = true,
    )
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        SleepAlarmActivity()
    }
}