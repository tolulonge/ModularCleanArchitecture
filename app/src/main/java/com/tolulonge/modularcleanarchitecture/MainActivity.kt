package com.tolulonge.modularcleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tolulonge.modularcleanarchitecture.ui.theme.ModularCleanArchitectureTheme
import com.tolulonge.presentation_cmn.navigation.NavRoutes
import com.tolulonge.presentation_post.list.PostListScreen
import com.tolulonge.presentation_post.single.PostScreen
import com.tolulonge.presentation_usr.single.UserScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModularCleanArchitectureTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    App(navController = navController)
                }
            }
        }
    }
}

@Composable
fun App(navController: NavHostController) {
    NavHost(navController, startDestination = NavRoutes.Posts.route) {
        composable(route = NavRoutes.Posts.route) {
            PostListScreen(hiltViewModel(), navController)
        }
        composable(
            route = NavRoutes.Post.route,
            arguments = NavRoutes.Post.arguments
        ) {
            PostScreen(
                hiltViewModel(),
                NavRoutes.Post.fromEntry(it)
            )
        }
        composable(
            route = NavRoutes.User.route,
            arguments = NavRoutes.User.arguments
        ) {
            UserScreen(
                hiltViewModel(),
                NavRoutes.User.fromEntry(it)
            )
        }
    }
}

