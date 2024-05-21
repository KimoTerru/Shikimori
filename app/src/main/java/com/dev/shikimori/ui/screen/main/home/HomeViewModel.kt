package com.dev.shikimori.ui.screen.main.home

import androidx.lifecycle.ViewModel
import com.dev.shikimori.R
import com.dev.shikimori.ui.util.HomeScreenListType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(

): ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    fun setSearchText(text: String) {
        _searchText.value = text
    }

    fun clearSearchText() {
        _searchText.value = ""
    }

    private val _currentHomeScreenListTypeScreen = MutableStateFlow(HomeScreenListType.Anime)
    val currentAnimeTypeScreen = _currentHomeScreenListTypeScreen.asStateFlow()

    private val _searchPlaceholderText = MutableStateFlow(R.string.anime)
    val searchPlaceholderText = _searchPlaceholderText.asStateFlow()

    fun setCurrentAnimeTypeScreen() {
        _currentHomeScreenListTypeScreen.value = when (_currentHomeScreenListTypeScreen.value) {
            HomeScreenListType.Anime -> HomeScreenListType.Manga
            HomeScreenListType.Manga -> HomeScreenListType.Anime
        }
        _searchPlaceholderText.value = when (_currentHomeScreenListTypeScreen.value) {
            HomeScreenListType.Anime -> R.string.anime
            HomeScreenListType.Manga -> R.string.mannga_manhwa_and_ranobe
        }
    }

}