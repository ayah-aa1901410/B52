package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize().padding(10.dp),
                color = MaterialTheme.colors.background
            ) {
                MessageCard(name = "Daddy Shark")
            }
        }
    }
}
//Modifiers

@Composable
fun MessageCard(name: String) {
    Row(
        modifier = Modifier
//            .padding(all = 10.dp)
            .border(2.dp, Color.Red, RectangleShape)
            .fillMaxSize(1f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.someone),
            contentDescription = "A shark Image",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(text = "$name", modifier = Modifier.padding(10.dp))
            Divider(thickness = 1.dp, color = Color.White)
            Text(
                text = "DevelopersTermsPrivacyPolicy",
                style = MaterialTheme.typography.h4)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MessageCard(name = "Daddy Shark")
    }
}