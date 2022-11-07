package com.example.aulateste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aulateste.ui.theme.AulaTesteTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //declarando mensagem do cartão de mensagem
            MessageCard("Lucas")
        }
    }
}

@Composable
//declarando o metódo de cartão de mensagem
fun MessageCard(name: String) {
    Text(text = "Olá $name!")
}
//criando o preview do projeto
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AulaTesteTheme {
        //chamando o metódo de cartão de mensagem
        MessageCard("Lucas")
    }
}