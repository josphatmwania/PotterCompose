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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
 * Using COil to load images
 */
@Composable
fun CharacterImageCard(character: Character) {
    val imagePainter = rememberAsyncImagePainter(model = character.image)

    Card(
//        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(size = 10.dp)


    ) {
        Box{

            Image(painter = imagePainter, contentDescription = null,
            modifier = Modifier
                .clip(shape = CircleShape)
                .height(150.dp),
            contentScale = ContentScale.Crop
            )


            Surface(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = .3f),
                modifier = Modifier.align(Alignment.BottomEnd),


                contentColor = MaterialTheme.colorScheme.onSurface

            ) {
                
                Column( 
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)



                ) {


                    Text(text = "Real Name: ${character.actor} ", Modifier.align(Alignment.End))
                    Text(text = "Actor Name: ${character.name} ", Modifier.align(Alignment.End))

                    
                }


            }




        }

    }
}



