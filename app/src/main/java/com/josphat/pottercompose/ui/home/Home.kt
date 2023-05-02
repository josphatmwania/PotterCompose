package com.josphat.pottercompose.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.josphat.pottercompose.data.api.model.Character


@Composable
fun HomeScreen() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()

    LazyColumn {
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )

            }
        }

        items(state){character:Character ->
            CharacterImageCard(character = character)

        }

    }
}

/**
 * Using Coil to load images
 */


@Composable
fun CharacterImageCard(character: Character) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,



    )

    {
        Image(
            modifier = Modifier
                .width(100.dp)
                .clip(RoundedCornerShape(15.dp))
                .padding(10.dp)
                .height(75.dp),


            painter = rememberAsyncImagePainter(model = character.image),
            contentDescription = null )

        Column(
            modifier = Modifier
            .padding(15.dp))

        {
            Text(text = "Real Name: ${character.actor}" )
            var fontWeight = FontWeight.Bold

            Text(text = "Actor Name:${character.name}")
//            fontWeight = FontWeight.Bold
        }








        
    }
    

    
}







