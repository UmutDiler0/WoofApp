package com.umutdiler.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
    var expanded  by remember { mutableStateOf(false) }

    Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))
    Card(
        modifier = Modifier.clip(MaterialTheme.shapes.medium),
    ) {
        Column(
            modifier = modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessVeryLow
                    )
                )
        ){
            Row(
                modifier = Modifier.fillMaxSize()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                DogIcon(dogIcon = dog.image)
                DogInfo(name = dog.name, age = dog.age)
                Spacer(modifier = Modifier.weight(1f))
                DogItemButton(expanded = expanded, onClick = {
                    expanded = !expanded
                })
            }
            if(expanded){
                DogHobbies(
                    dog.hobbies,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }

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
@Composable
private fun DogItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = Modifier
    ){
        Icon(
            imageVector = if(expanded) Icons.Filled.ExpandLess
            else Icons.Filled.ExpandMore,
            contentDescription = stringResource(id = R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary,
        )
    }

}

@Composable
fun DogHobbies(
    dogHobby : Int,
    modifier : Modifier = Modifier
){
    Column(
        modifier = modifier
    ){
        Text(
            text = "About:",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = dogHobby),
            style = MaterialTheme.typography.bodyMedium
        )
    }
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