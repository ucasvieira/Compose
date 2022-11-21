package com.example.aulateste

import android.content.res.Configuration
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.material.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aulateste.ui.theme.AulaTesteTheme
import com.example.aulateste.R






class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AulaTesteTheme() {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Conversation(SampleData.conversationSample)
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

        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )

        Column (modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            //texto do author
            Text(text = msg.author, color = MaterialTheme.colors.secondary, style = MaterialTheme.typography.subtitle1)
            //adcionar espaço vertical entre o author e o texto da mensagem
            Spacer(modifier = Modifier.height(4.dp))
            //texto da mensagem
            Surface(shape =  MaterialTheme.shapes.medium,
            elevation = 1.dp,
            color = surfaceColor,
            modifier = Modifier
                .animateContentSize()
                .padding(1.dp)
            ) {
                Text(text = msg.body,
                    modifier =Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}
//ativando um preview do projeto com light e dark mode
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    name = "Light Mode"
)

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

@Composable
fun Conversation(messages: List<Message>){
    LazyColumn{
        items(messages) { message ->
            MessageCard(message)
        }
    }
}


@Preview
@Composable
fun PreviewConversation(){
    AulaTesteTheme(darkTheme = true){
        Conversation(SampleData.conversationSample)
    }
}
