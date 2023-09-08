package com.example.threads_clone.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.threads_clone.item_view.ThreadIteam
import com.example.threads_clone.viewmodel.HomeViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Home(navHostController: NavHostController){

    val context = LocalContext.current
    val homeViewModel:HomeViewModel = viewModel()
    val threadsAndUsers by homeViewModel.threadsAndUsers.observeAsState(null)



    LazyColumn {
        items(threadsAndUsers ?: emptyList()){pairs ->
           ThreadIteam(
               thread = pairs.first,
               users = pairs.second,
               navHostController,
               FirebaseAuth.getInstance().currentUser!!.uid)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ShowHome(){
    //Home()
}