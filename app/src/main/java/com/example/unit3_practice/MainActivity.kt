package com.example.unit3_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.FontRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unit3_practice.Affirmation.Topic
import com.example.unit3_practice.ui.theme.Unit3practiceTheme
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.unit3_practice.data.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Unit3practiceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                GridApp()
                }
            }
        }
    }
}

@Composable
fun Item(modifier: Modifier= Modifier , topic: Topic){

    Card(modifier.padding(8.dp), shape = RoundedCornerShape(20.dp)) {
        Row {
            Image(
                painter = painterResource(topic.imageRecourse),
                contentDescription = stringResource(topic.StringRecourse),
                modifier.fillMaxHeight()
            )
//            Spacer(modifier.width(5.dp))
            Column {
                Text(
                    text = stringResource(topic.StringRecourse),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = topic.cnt.toString(),
                    modifier = Modifier.padding(5.dp)

                )
            }
        }
    }
}
@Composable
fun ListItem(modifier: Modifier= Modifier , topics : List<Topic>){
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(200.dp),
        verticalItemSpacing = 10.dp,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
        )
    {
        items(topics) {
            top-> Item(topic = top)
        }
    }

}

@Composable
fun GridApp(){
    val layoutDir = LocalLayoutDirection.current
    Surface(Modifier
        .fillMaxSize()
        .statusBarsPadding()
        .padding(
            start = WindowInsets.safeDrawing.asPaddingValues().calculateStartPadding(layoutDir),
            end = WindowInsets.safeDrawing.asPaddingValues().calculateEndPadding(layoutDir)
        )) {

        ListItem( topics = DataSource.topic)
    }
}