package com.umutdiler.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umutdiler.woof.data.DataSource
import com.umutdiler.woof.data.Dog
import com.umutdiler.woof.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WoofTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Woof()
                }
            }
        }
    }
}

@Composable
fun Woof(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) {
        LazyColumn(contentPadding = it){
            items(DataSource.loadDogs()){
                DogCard(
                    it,
                    )
            }
        }
    }

}

@Composable
fun DogCard(dog : Dog,modifier : Modifier = Modifier) {
    Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))
    Card(
        modifier = Modifier.clip(MaterialTheme.shapes.medium),
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            DogIcon(dogIcon = dog.image)
            Spacer(modifier = Modifier.width(20.dp))
            DogInfo(name = dog.name, age = dog.age)
        }
    }

}

@Composable
fun DogIcon(
    dogIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentDescription = null,
        painter = painterResource(dogIcon),
    )
}
@Composable
fun DogInfo(name : String,age : Int){
    Column(
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_small))
    ){
        Text(
            text = name,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Age: $age years",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier : Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
        Row(
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically

        ){
            Image(
                painter = painterResource(id = R.drawable.pawn),
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.image_size))
                    .padding(dimensionResource(id = R.dimen.padding_small))


            )
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.titleLarge,

            )
        }
    },
        modifier = Modifier
    )
}

@Preview
@Composable
fun GreetingPreview() {
    WoofTheme (darkTheme = false){
        Woof()
    }

}
@Preview
@Composable
fun WoofAppDarkMode(){
    WoofTheme(darkTheme = true){
        Woof()
    }
}