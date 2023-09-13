@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.loginpage

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.loginpage.ui.theme.LoginPageTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LoginUI(applicationContext)

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginUI(context: Context) {


    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(color = Color.Green.copy(alpha = 0.4f))
            .fillMaxSize()
    ) {


        Text(
            text = "LOGIN",
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 230.dp, bottom = 50.dp)


        )
        OutlinedTextField(
            value = username,
            shape = AbsoluteRoundedCornerShape(200.dp),
            onValueChange = { username = it },
            label = { Text("Enter your username") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.Yellow.copy(alpha = 0.9f),
                cursorColor = Color.Yellow
            ),

            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "person", tint = Color.Black)
            },
            modifier = Modifier
                .padding(bottom = 5.dp, top = 5.dp)
                .width(1000.dp)


        )
        OutlinedTextField(
            value = password,
            shape = AbsoluteRoundedCornerShape(200.dp),
            onValueChange = { password = it },
            label = { Text("Enter your password") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.Yellow.copy(alpha = 0.9f),
                cursorColor = Color.Yellow
            ),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "password", tint = Color.Black)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp, top = 10.dp)

        )

        Column(
            modifier = Modifier
                .padding(start = 120.dp)

        ) {
            // instagram
            Row(verticalAlignment = Alignment.CenterVertically) {
                val image = painterResource(R.drawable.instagram)
                Box {
                    Image(
                        painter = image,
                        contentDescription = "Instagram",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
                val ct = LocalContext.current
                Button(
                    colors = ButtonDefaults.buttonColors(Color.Blue.copy(alpha = 0.3f)),
                    border = BorderStroke(width = 2.dp, color = Color.Red),

                    modifier = Modifier
                        .padding(16.dp), onClick = {
                        Log.e("tag", "URL is " + "https://www.instagram.com")
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            android.net.Uri.parse("https://www." + "instagram.com")
                        )
                        ct.startActivity(urlIntent)
                    }) {
                    Text(text = "LOGIN")
                }
            }
            // amazon
            Row(verticalAlignment = Alignment.CenterVertically) {
                val image = painterResource(R.drawable.amazon)
                Box {
                    Image(
                        painter = image,
                        contentDescription = "amazon",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
                val ct = LocalContext.current
                Button(
                    colors = ButtonDefaults.buttonColors(Color.Blue.copy(alpha = 0.3f)),
                    border = BorderStroke(width = 2.dp, color = Color.Red),

                    modifier = Modifier
                        .padding(16.dp), onClick = {
                        Log.e("tag", "URL is " + "https://www.amazon.com")
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            android.net.Uri.parse("https://www." + "amazon.com")
                        )
                        ct.startActivity(urlIntent)
                    }) {
                    Text(text = "LOGIN")
                }
            }
            //spotify
            Row(verticalAlignment = Alignment.CenterVertically) {
                val image = painterResource(R.drawable.spotify)
                Box {
                    Image(
                        painter = image,
                        contentDescription = "Spotify",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
                val ct = LocalContext.current
                Button(
                    colors = ButtonDefaults.buttonColors(Color.Blue.copy(alpha = 0.3f)),
                    border = BorderStroke(width = 2.dp, color = Color.Red),

                    modifier = Modifier
                        .padding(16.dp), onClick = {
                        Log.e("tag", "URL is " + "https://www.spotify.com/")
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            android.net.Uri.parse("https://www." + "spotify.com")
                        )
                        ct.startActivity(urlIntent)
                    }) {
                    Text(text = "LOGIN")
                }
            }
            // youtube
            Row(verticalAlignment = Alignment.CenterVertically) {
                val image = painterResource(R.drawable.youtube)
                Box {
                    Image(
                        painter = image,
                        contentDescription = "youtube",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(60.dp)
                    )
                }
                val ct = LocalContext.current
                Button(
                    colors = ButtonDefaults.buttonColors(Color.Blue.copy(alpha = 0.3f)),
                    border = BorderStroke(width = 2.dp, color = Color.Red),

                    modifier = Modifier
                        .padding(16.dp), onClick = {
                        Log.e("tag", "URL is " + "https://www.youtube.com")
                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            android.net.Uri.parse("https://www." + "youtube.com")
                        )
                        ct.startActivity(urlIntent)
                    }) {
                    Text(text = "LOGIN")
                }
            }
        }
    }

}