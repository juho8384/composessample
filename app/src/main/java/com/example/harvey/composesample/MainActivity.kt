package com.example.harvey.composesample

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harvey.composesample.ui.theme.ComposesampleTheme
import com.google.accompanist.glide.rememberGlidePainter

// test commit
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme

            // to use xml theme, just do not use compose theme
            Conversation(messages = getMessages())
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            Greeting(message)
        }
    }
}


@Composable
fun Greeting(message: Message) {
    Row(modifier = Modifier.padding(top = 8.dp, start = 16.dp)) {
        Image(
            modifier = Modifier
                .size(60.dp)
                .background(colorResource(id = R.color.purple_200), shape = CircleShape)
                .border(1.5.dp, colorResource(R.color.black), CircleShape)
                .clip(CircleShape),
            //use glide
            painter = rememberGlidePainter(
                "http://via.placeholder.com/300.png",
                previewPlaceholder = R.drawable.ic_launcher_foreground
            ),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.width(16.dp))

        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor: Color by animateColorAsState(
            targetValue = if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.secondaryVariant
        )
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = "Hello1 ${message.name}",
                //use xml color
                color = colorResource(R.color.black)
            )

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = "Hello2 ${message.text}",
                    style = MaterialTheme.typography.body2,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    overflow = TextOverflow.Ellipsis
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
        Conversation(messages = getMessages())
    }
}