package com.josphat.pottercompose.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.josphat.pottercompose.data.api.model.Character
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import coil.compose.AsyncImagePainter.State.Empty.painter


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
//        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,

    )

    {
        Image(
            modifier = Modifier
                .width(150.dp)
                .clip(shape = CircleShape)
//                .clip(CircleShape(50.dp))
                .height(90.dp),

            painter = rememberImagePainter(data = character.image),
            contentDescription = null )

        Column(
            modifier = Modifier
            .padding(15.dp))

        {
            Text(text = "Real Name: ${character.actor}")
            Text(text = "Actor Name: ${character.name}")
        }








        
    }
    

    
}







