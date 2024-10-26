package com.josphat.pottercompose.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.josphat.pottercompose.data.api.model.Character

@Composable
fun HomeScreen() {
    val homeViewModel: HomeViewModel = viewModel() // Get the viewModel
    val state by homeViewModel.state.collectAsState() // Collect state from the ViewModel

    if (state.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        // Todo: Use LazyVerticalGrid to display characters in a grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(3), //Todo:  Display 2 characters per row
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(state) { character: Character ->
                CharacterImageCard(character = character)
            }
        }
    }
}

/**
 *  Todo: Use Coil to load images
 */
@Composable
fun CharacterImageCard(character: Character) {
    val imagePainter = rememberAsyncImagePainter(model = character.image)

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), // Fill max width for proper layout
        shape = RoundedCornerShape(size = 30.dp)
    ) {
        Column {
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Surface(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = .3f),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                contentColor = MaterialTheme.colorScheme.onSurface
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    // Display character information
                    Text(
                        text = "Actor Name: ${character.name}",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "Real Name: ${character.actor}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}
