package com.example.bizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardUI()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BizCardUI() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            elevation = CardDefaults.cardElevation(
               defaultElevation = 5.dp,
                pressedElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray,
            )

        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {
                ImageHeader()
                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider(modifier = Modifier.height(1.dp), color = Color.Black)
                Spacer(modifier = Modifier.height(20.dp))
                BizCardDetails()
                HorizontalDivider(modifier = Modifier.height(1.dp), color = Color.Black)

            }

        }
    }
}

@Composable
fun BizCardDetails() {
    val skillsVisible  = remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier
        .padding(5.dp)
        .fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally,) {
        Text(
            text = "Abubakar Issa",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Black,
            letterSpacing = 0.5.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Native Android Developer | Kotlin | Flutter Developer",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Gray,
            fontSize = 15.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(modifier = Modifier.padding(5.dp).height(40.dp),onClick = {
             skillsVisible.value = !skillsVisible.value        }) {
        Text(text = if (skillsVisible.value) "Hide SKills" else "Show Skills"

            ,style = TextStyle(fontSize = 15.sp),modifier = Modifier.align(Alignment.CenterVertically))


        }
        Spacer(modifier = Modifier.height(10.dp))
     if (skillsVisible.value){   SkillsList(
            portfolio = listOf(
                "Android Development",
                "Kotlin",
                "Flutter",
                "Firebase",
                "Dart",
                "Python",
                "Git",
                "GitHub",
                "Trello",
                "Slack",
                "Adobe Photoshop",
                "Microsoft Office",
                "Windows",
                "Linux",
                "MacOS",
                "Android Studio",
                "Visual Studio Code",
                "IntelliJ IDEA",
                "PyCharm",


        ),
        ) }
    }
}

@Composable
fun SkillsList(portfolio: List<String>) {
    LazyColumn() {
        items(portfolio.size) { index ->
            PortfolioItem(portfolio = portfolio[index])
        }
    }

}

@Composable
fun PortfolioItem(portfolio: String){
    ListItem(
        colors = ListItemDefaults.colors(
            containerColor = Color.Transparent,
        ),
        supportingContent = {
            Text(text = "A very cool skill",style = TextStyle(fontSize = 15.sp))
        },
     headlineContent = {
         Text(text = portfolio, style = TextStyle(fontSize = 15.sp))
     }
    )
}

@Composable
fun ImageHeader() {
    Surface(modifier = Modifier.size(
        width = 150.dp,
        height = 150.dp
    ),shape = CircleShape, border = BorderStroke(
        width = 2.dp,
        color = Color.Yellow
    )
    ) {
        Image(
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.me),
            contentDescription = "My Image",
            modifier = Modifier.size(250.dp),
            contentScale = ContentScale.Crop
        )
    }
}
