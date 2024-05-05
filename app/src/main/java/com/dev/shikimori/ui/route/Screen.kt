package com.dev.shikimori.ui.route

private enum class Screen {
    Splash,

    Auth,

    Main,
    Home,
    Calendar,
    Search,
    News,
    Profile,

    AnimeDetail,
    Detail,
    More,
    Characters,
    Frames,
    Videos,
    Related,
    Authors,
    Discussion,

    About,
    Settings
}

sealed class NavigationRouts(val route: String) {
    data object Splash : NavigationRouts(Screen.Splash.name)
    data object Auth : NavigationRouts(Screen.Auth.name)
    data object About : NavigationRouts(Screen.About.name)
    data object Settings : NavigationRouts(Screen.Settings.name)
    data object Main : NavigationRouts(Screen.Main.name) {
        data object Home : NavigationRouts(Screen.Home.name)
        data object Calendar : NavigationRouts(Screen.Calendar.name)
        data object Search : NavigationRouts(Screen.Search.name)
        data object News : NavigationRouts(Screen.News.name)
        data object Profile : NavigationRouts(Screen.Profile.name)
    }

    data object AnimeDetail : NavigationRouts(Screen.AnimeDetail.name) {
        data object Detail : NavigationRouts(Screen.Detail.name)
        data object More : NavigationRouts(Screen.More.name)
        data object Characters : NavigationRouts(Screen.Characters.name)
        data object Frames : NavigationRouts(Screen.Frames.name)
        data object Videos : NavigationRouts(Screen.Videos.name)
        data object Related : NavigationRouts(Screen.Related.name)
        data object Authors : NavigationRouts(Screen.Authors.name)
        data object Discussion : NavigationRouts(Screen.Discussion.name)
    }
}