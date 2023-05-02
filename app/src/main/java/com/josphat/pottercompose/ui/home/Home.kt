package com.josphat.pottercompose.ui.home

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
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
 * Using COil to load images
 */


@Composable
fun CharacterImageCard(character: Character) {
    val imagePainter = rememberAsyncImagePainter(model = character.image)
    
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = imagePainter, contentDescription = null)

        // Add modifier later
        
        Column( modifier = Modifier(
            Text(text = "Real Name: ${character.actor} "),
            Text(text = "Actor Name: ${character.name}")
        ) {

        }
        
    }
    

    
}


