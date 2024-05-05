package com.dev.shikimori.ui.route

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
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
    navController: NavHostController,
    startDestination: String = NavigationRouts.Main.route,
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues
) {
    NavHost(
        modifier = modifier.padding(innerPadding),
        navController = navController,
        startDestination = startDestination
    ) {

        composable(NavigationRouts.Splash.route) {

        }

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
            startDestination = NavigationRouts.Main.Home.route
        ) {
            composable(NavigationRouts.Main.Home.route) {
                HomeScreen()
            }
            composable(NavigationRouts.Main.Calendar.route) {
                CalendarScreen()
            }
            composable(NavigationRouts.Main.Search.route) {
                SearchScreen()
            }
            composable(NavigationRouts.Main.News.route) {
                NewsScreen()
            }
            composable(NavigationRouts.Main.Profile.route) {
                ProfileScreen()
            }
        }

        navigation(
            route = NavigationRouts.AnimeDetail.route,
            startDestination = NavigationRouts.AnimeDetail.Detail.route
        ) {
            composable(NavigationRouts.AnimeDetail.Detail.route) {
                DetailScreen()
            }
            composable(NavigationRouts.AnimeDetail.More.route) {

            }
            composable(NavigationRouts.AnimeDetail.Characters.route) {

            }
            composable(NavigationRouts.AnimeDetail.Frames.route) {

            }
            composable(NavigationRouts.AnimeDetail.Videos.route) {

            }
            composable(NavigationRouts.AnimeDetail.Detail.route) {

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