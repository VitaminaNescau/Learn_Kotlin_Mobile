package com.vitaminanescau.learn

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vitaminanescau.learn.ui.theme.LearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTheme {
                Column(verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(Color(0xFFd2e8d4))
                        .fillMaxSize()
                        .padding(24.dp))
                {
                    Spacer(modifier = Modifier.weight(1f))
                    LearnCard()
                    Spacer(modifier = Modifier.weight(1f))

                    LearnInfo()

                }
            }

        }
    }
}
@Composable
fun LearnCard(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxWidth()
    )
    {
        Image(painter = painterResource(R.drawable.android_logo),
            contentDescription = "Logo Android",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .width(120.dp)
                .background(Color(0xFF073042))
                .padding(2.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text ="Vitor J. Santos", fontSize = 32.sp, fontWeight = FontWeight.W400
            )
            Text(text = "Developer Android", fontWeight = FontWeight.W700, color = Color(0xFF3B8C61))

        }

    }

}
@Composable
fun LearnInfo(){
    val callIntent: Intent = Uri.parse("tel:+5571987908550").let { number ->
        Intent(Intent.ACTION_DIAL, number)
    }
    val mailIntent: Intent = Intent(Intent.ACTION_VIEW,Uri.parse("mailto:vitorjss82@gmail.com"))
    val httpIntent: Intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://github.com/vitaminanescau"))
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth(.6f)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.baseline_call_24),
                contentDescription = "Logo Call",
                alignment = Alignment.Center,
                modifier = Modifier.width(24.dp)
            )

   ClickableText(text = AnnotatedString("+55 71 98790-8550", spanStyle = SpanStyle(fontSize = 14.sp)),modifier = Modifier.align(Alignment.Bottom)) {
       i: Int ->
        context.startActivity(callIntent)
   }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.git),
                contentDescription = "Logo GitHub",
                alignment = Alignment.Center,
                modifier = Modifier.width(24.dp)
            )
            ClickableText(
                text = AnnotatedString("@VitaminaNescau",spanStyle = SpanStyle(fontSize = 14.sp)),
            onClick = {i: Int ->
                context.startActivity(httpIntent)

            }, modifier = Modifier.align(Alignment.Bottom)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.baseline_email_24),
                contentDescription = "Logo Email",
                alignment = Alignment.Center,
                modifier = Modifier.width(24.dp)
            )
            ClickableText(
                text = AnnotatedString("vitorjss82@gmail.com", spanStyle = SpanStyle(fontSize = 14.sp),
                ), onClick = {
                    i: Int ->  context.startActivity(mailIntent)
                }, modifier = Modifier.align(Alignment.Bottom)

            )
        }
    }
}

fun Context.openMailbox(){
    Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"))
}