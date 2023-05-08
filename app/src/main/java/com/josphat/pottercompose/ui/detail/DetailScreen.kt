package com.josphat.pottercompose.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.josphat.pottercompose.R

@Composable
fun Details() {

    val detailViewModel = viewModel(modelClass = DetailViewModel::class.java)
    val state by detailViewModel.state.collectAsState()


//    onBackPressed : () -> Unit

}


//
//{
//    val state = viewModel.state.value
//
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                navigationIcon = {
//                    IconButton(onClick = { onBackPressed() }) {
//                        Image(painter = painterResource(id = R.drawable.arrow_back), contentDescription = "")
//
//                    }
//                },
//                title = {}
//            )
//
//
//        }
//    ){
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Start
//        ) {
//            Image(
//
//                painter = rememberAsyncImagePainter(model = character.image), contentDescription = )
//
//        }
//
//    }
//
//}
//
