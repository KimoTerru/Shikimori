package com.dev.shikimori.ui.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.dev.shikimori.ui.common.bottomBar.MainBottomMenuNavigation
import com.dev.shikimori.ui.route.AppNavGraph
import com.dev.shikimori.ui.theme.ShikimoriTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

            ShikimoriTheme {
                Scaffold(
                    bottomBar = {
                        MainBottomMenuNavigation(
                            navController = navController,
                            bottomBarState = bottomBarState
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AppNavGraph(
                        navController = navController,
                        bottomBarState = bottomBarState,
                        mainPadding = innerPadding
                    )
                }
            }
        }
    }
}