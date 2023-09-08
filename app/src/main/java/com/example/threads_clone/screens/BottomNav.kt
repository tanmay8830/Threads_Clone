package com.example.threads_clone.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.threads_clone.model.BottomNavItem
import com.example.threads_clone.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav(navController: NavHostController){

    val navController1 = rememberNavController()


    Scaffold(bottomBar = {MyBottomBar(navController1)}) { innerPading ->
    NavHost(navController = navController1, startDestination = Routes.Home.routes,
        modifier = Modifier.padding(innerPading)){


        composable(route = Routes.Home.routes){
            Home(navController)
        }

        composable(Routes.Notification.routes){
            Notification()
        }

        composable(Routes.Search.routes){
            Search(navController)
        }

        composable(Routes.AddThread.routes){
            AddThreads(navController1)
        }

        composable(Routes.Profile.routes){
            Profile(navController)
        }
    }

    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun MyBottomBar(navController1: NavHostController) {

    val backStackEntry =navController1.currentBackStackEntryAsState()

    val list = listOf(

        BottomNavItem("Home", Routes.Home.routes, Icons.Rounded.Home),
        BottomNavItem("Search", Routes.Search.routes, Icons.Rounded.Search),
        BottomNavItem("Add Threads", Routes.AddThread.routes, Icons.Rounded.Add),
        BottomNavItem("Notification", Routes.Notification.routes, Icons.Rounded.Notifications),
        BottomNavItem("Profile", Routes.Profile.routes, Icons.Rounded.Person),
        )

       BottomAppBar {

           list.forEach{

               val selected = it.routes ==  backStackEntry?.value?.destination?.route


               NavigationBarItem(selected = selected, onClick = {

                   navController1.navigate(it.routes){
                    popUpTo(navController1.graph.findStartDestination().id){
                        saveState = true
                    }
                       launchSingleTop =true
                   }
               }, icon = {
                   Icon(imageVector = it.icon, contentDescription = it.title)
               })
           }
       }
}
