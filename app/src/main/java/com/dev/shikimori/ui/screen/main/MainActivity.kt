package com.dev.shikimori.ui.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.dev.shikimori.ui.route.AppNavGraph
import com.dev.shikimori.ui.theme.ShikimoriTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ShikimoriTheme {
                Scaffold(
                    topBar = {
                    },
                    floatingActionButton = {
                    },
                    bottomBar = {
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AppNavGraph(
                        navController = navController,
                        innerPadding = innerPadding
                    )
                }
            }
        }
    }
}