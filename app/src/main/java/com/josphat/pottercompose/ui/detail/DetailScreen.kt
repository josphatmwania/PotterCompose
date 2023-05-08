package com.josphat.pottercompose.ui.detail


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel


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
