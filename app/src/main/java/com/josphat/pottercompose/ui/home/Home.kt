package com.josphat.pottercompose.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
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

        }

    }
}

/**
 * Using COil to load images
 */
@Composable
fun CharacterImageCard(character: Character) {
    val imagePainter = rememberImagePainter(data = character.image)

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)
    ) {

    }
}



