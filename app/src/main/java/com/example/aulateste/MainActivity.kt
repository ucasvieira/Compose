package com.example.aulateste

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aulateste.ui.theme.AulaTesteTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.border
import com.example.aulateste.ui.theme.AulaTesteTheme






class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AulaTesteTheme() {
                Surface(modifier = Modifier.fillMaxSize()) {
                    //declarando o texto do author e o texto da mensagem
                    MessageCard(Message("Udyr", "Uga uga!"))
                }
            }
        }
    }
}
//criando a classe message com as variaveis author e body
data class Message(val author:String, val body: String)

@Composable
fun MessageCard(msg: com.example.aulateste.Message) {
    //adicionando borda a mensagem
    Row(modifier = Modifier.padding(all = 8.dp)) {
        //adicionando a imagem
        Image(
            //adicionando a imagem do diretorio
            painter = painterResource(R.drawable.udyr),
            //declarando a descrição do conteudo
            contentDescription = "Foto de perfil do contato",

            modifier = Modifier
                .size(40.dp)    //declarando o tamanho da imagem
                .clip(CircleShape)  //colocando imagem em forma redonda
                .border(1.5.dp, MaterialTheme.colors.primary, CircleShape) //colocando borda colorida em volta da imagem
        )
        //adicionar um espaço horizontal entre a imagem e a coluna
        Spacer(modifier = Modifier.width(8.dp))

        Column  {
            //texto do author
            Text(text = msg.author, color = MaterialTheme.colors.secondary, style = MaterialTheme.typography.body1)
            //adcionar espaço vertical entre o author e o texto da mensagem
            Spacer(modifier = Modifier.height(4.dp))
            //texto da mensagem
            Text(text = msg.body, modifier = Modifier.padding(all = 4.dp), style = MaterialTheme.typography.body2)
        }
    }
}
//ativando um preview do projeto com light e dark mode
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

@Composable
fun PreviewMessageCard(){
    AulaTesteTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            //declarando o texto do author e o texto da mensagem para o preview
            MessageCard(Message("Udyr", "Uga uga!"))
        }
    }
}
