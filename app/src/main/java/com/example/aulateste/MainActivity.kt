package com.example.aulateste

import android.os.Bundle
import android.widget.Space
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
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //declarando o texto do author e o texto da mensagem
            MessageCard(Message("Udyr","Uga uga!"))
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
        )
        //adicionar um espaço horizontal entre a imagem e a coluna
        Spacer(modifier = Modifier.width(8.dp))

        Column  {
            //texto do author
            Text(text = msg.author)
            //adcionar espaço vertical entre o author e o texto da mensagem
            Spacer(modifier = Modifier.height(4.dp))
            //texto da mensagem
            Text(text = msg.body)
        }
    }
}
//ativando um preview do projeto
@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(
        msg = Message("Udyr","uga uga!")
    )
}
