package com.example.composecampapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecampapp.ui.theme.ComposeCampAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCampAppTheme {
               Myapp()
            }
        }
    }
}
@Composable
fun Myapp(){
    Greetings()
}
@Composable
fun Greetings(names: List<String> = List(1000){ "$it"}){
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){
        items(items=names){name->
            Greeting(name = name)
        }
    }

}

@Composable
fun Greeting(name: String) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}
@Composable
fun CardContent(name:String){
    Row(
        modifier = Modifier
            .padding(12.dp)

    ) {
      Column(modifier = Modifier
          .weight(1f)
          .padding(12.dp)) {
          Text(text = "Hello,")
          Text(text = name,
                style=MaterialTheme.typography.h4.copy(fontWeight = FontWeight.ExtraBold))
      }
    }
}

@Composable
fun OnboardingScreen(){

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCampAppTheme {
        Myapp()
    }
}