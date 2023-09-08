package com.example.threads_clone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.threads_clone.screens.AddThreads
import com.example.threads_clone.screens.BottomNav
import com.example.threads_clone.screens.Home
import com.example.threads_clone.screens.Login
import com.example.threads_clone.screens.Notification
import com.example.threads_clone.screens.OtherUsers
import com.example.threads_clone.screens.Profile
import com.example.threads_clone.screens.Register
import com.example.threads_clone.screens.Search
import com.example.threads_clone.screens.Splash

@Composable
fun NavGraph(navController: NavHostController){


    NavHost(navController = navController,
        startDestination = Routes.Splash.routes
    ){


        composable(Routes.Splash.routes){
            Splash(navController)
        }


        composable(Routes.Home.routes){
           Home(navController)
        }

        composable(Routes.Notification.routes){
            Notification()
        }

        composable(Routes.Search.routes){
            Search(navController)
        }

        composable(Routes.AddThread.routes){
           AddThreads(navController)
        }

        composable(Routes.Profile.routes){
            Profile(navController)
        }

        composable(Routes.BottomNav.routes){
            BottomNav(navController)
        }
        composable(Routes.Login.routes){
            Login(navController)
        }
        composable(Routes.Register.routes){
            Register(navController)
        }

        composable(Routes.OtherUsers.routes){
            val data = it.arguments!!.getString("data")
            OtherUsers(navController,data!!)
        }




    }
}