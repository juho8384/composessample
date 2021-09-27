package com.example.harvey.composesample

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harvey.composesample.ui.theme.ComposesampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposesampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("onCreate")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Row(modifier = Modifier.padding(top = 8.dp, start = 16.dp)) {
        Image(
            modifier = Modifier
                .size(60.dp)
                .background(colorResource(id = R.color.purple_200), shape = CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "img1"
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "Hello1 $name!",
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = "Hello2 $name!",
                    style = MaterialTheme.typography.body2
                )
            }

        }
    }

}


//side > split에서 확인 가능 및 oncreate랑 다르게 deploy preview로 실행 가능
@Preview(
    name = "Light Mode",
    showBackground = true
)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun DefaultPreview() {
    ComposesampleTheme {
        Greeting("It's preview")
    }
}