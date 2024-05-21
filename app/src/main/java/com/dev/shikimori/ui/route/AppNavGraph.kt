package com.dev.shikimori.ui.route

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.dev.shikimori.ui.screen.about.AboutScreen
import com.dev.shikimori.ui.screen.auth.AuthScreen
import com.dev.shikimori.ui.screen.detail.DetailScreen
import com.dev.shikimori.ui.screen.main.calendar.CalendarScreen
import com.dev.shikimori.ui.screen.main.home.HomeScreen
import com.dev.shikimori.ui.screen.main.news.NewsScreen
import com.dev.shikimori.ui.screen.main.profile.ProfileScreen
import com.dev.shikimori.ui.screen.main.search.SearchScreen
import com.dev.shikimori.ui.screen.settings.SettingsScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationRouts.Main.route,
    bottomBarState: MutableState<Boolean>,
    mainPadding: PaddingValues
) {
    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = startDestination
    ) {

        composable(NavigationRouts.Auth.route) {
            AuthScreen()
        }

        composable(NavigationRouts.Auth.route) {
            AuthScreen()
        }

        composable(NavigationRouts.About.route) {
            AboutScreen()
        }

        composable(NavigationRouts.Settings.route) {
            SettingsScreen()
        }

        navigation(
            route = NavigationRouts.Main.route,
            startDestination = NavigationRouts.Main.Home.route,
        ) {
            composable(NavigationRouts.Main.Home.route) {
                LaunchedEffect(Unit) {
                    bottomBarState.value = true
                }
                HomeScreen(
                    navController = navController,
                    outPadding = mainPadding
                )
            }
            composable(NavigationRouts.Main.Calendar.route) {
                LaunchedEffect(Unit) {
                    bottomBarState.value = true
                }
                CalendarScreen()
            }
            composable(NavigationRouts.Main.Search.route) {
                LaunchedEffect(Unit) {
                    bottomBarState.value = true
                }
                SearchScreen()
            }
            composable(NavigationRouts.Main.News.route) {
                LaunchedEffect(Unit) {
                    bottomBarState.value = true
                }
                NewsScreen()
            }
            composable(NavigationRouts.Main.Profile.route) {
                LaunchedEffect(Unit) {
                    bottomBarState.value = true
                }
                ProfileScreen()
            }
        }

        navigation(
            route = NavigationRouts.AnimeDetail.route,
            startDestination = NavigationRouts.AnimeDetail.Detail.route
        ) {
            composable(NavigationRouts.AnimeDetail.Detail.route) {
                LaunchedEffect(Unit) {
                    bottomBarState.value = false
                }
                DetailScreen(
                    navController = navController
                )
            }
            composable(NavigationRouts.AnimeDetail.More.route) {

            }
            composable(NavigationRouts.AnimeDetail.Characters.route) {

            }
            composable(NavigationRouts.AnimeDetail.Frames.route) {

            }
            composable(NavigationRouts.AnimeDetail.Videos.route) {

            }
            composable(NavigationRouts.AnimeDetail.Related.route) {

            }
            composable(NavigationRouts.AnimeDetail.Authors.route) {

            }
            composable(NavigationRouts.AnimeDetail.Discussion.route) {

            }
        }

    }

}