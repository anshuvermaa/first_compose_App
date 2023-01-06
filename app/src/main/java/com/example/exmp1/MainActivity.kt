package com.example.exmp1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exmp1.ui.theme.Exmp1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Exmp1Theme {
                // A surface container using the 'background' color from the theme

                MyApp()
            }
        }
    }
}




@Composable
fun MyApp(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color=Color(0xFF546E7A),
        

        ) {
        var moneyCounter = remember {
            mutableStateOf(0)
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("$${moneyCounter.value}", style = TextStyle(
                color=Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            ))
            Spacer(modifier = Modifier.height(130.dp))
            // when ever we have to pass lambda as last parameter we can pass in curly braces {}
            CreateCircle(moneyCounter=moneyCounter.value){
                newValue->moneyCounter.value=newValue

            }
            Spacer(modifier = Modifier.height(130.dp))
            if(moneyCounter.value>30){
                Text(
                    "you have Lots of money🤑💰💰",
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp).align(alignment = Alignment.CenterHorizontally),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold,

                        )
                )
            }
        }


    }

}


@Composable
fun CreateCircle(moneyCounter:Int,UpdateMoneyCounter: (Int)->Unit){


//    var moneyCounter by remember {
//        mutableStateOf(0)
//    }
    Card(modifier = Modifier
        .padding(3.dp)
        .size(155.dp)
        .clickable {
            UpdateMoneyCounter(moneyCounter + 1)
            Log.d("Tap", "CreatedCircle: $moneyCounter")
        },
        shape = CircleShape,
        backgroundColor = Color.White,
        elevation = 10.dp


    ){
        Box(contentAlignment = Alignment.Center) {

            Text(text = "tap ${moneyCounter}",style=TextStyle(fontSize = 29.sp))
        }

    }

}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Exmp1Theme {
        MyApp()

    }
}