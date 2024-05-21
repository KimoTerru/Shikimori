package com.dev.shikimori.ui.screen.main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.dev.shikimori.R
import com.dev.shikimori.ui.common.fab.FabButton
import com.dev.shikimori.ui.common.topBar.SearchAppBar
import com.dev.shikimori.ui.route.NavigationRouts

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    outPadding: PaddingValues,
    viewModel: HomeViewModel = HomeViewModel()
) {

    val searchText = viewModel.searchText.collectAsState()
    val searchPlaceholderText = viewModel.searchPlaceholderText.collectAsState()
    val currentListType = viewModel.currentAnimeTypeScreen.collectAsState()

    Scaffold(
        topBar = {
            SearchAppBar(
                searchText = searchText.value,
                showTrailingIcon = true,
                trailingIcon = R.drawable.switch_type,
                placeholderText = searchPlaceholderText.value,
                onClickTrailingIcon = viewModel::setCurrentAnimeTypeScreen,
                onChangedText = viewModel::setSearchText,
                onClickImeAction = viewModel::setSearchText,
                clearText = viewModel::clearSearchText
            )
        },
        floatingActionButton = {
            FabButton(
                outPadding = outPadding,
                iconButton = R.drawable.filter_outlined,
                textButton = R.string.filter,
                onClick = {
                    navController.navigate(NavigationRouts.AnimeDetail.route)
                }
            )
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it)
                .padding(bottom = outPadding.calculateBottomPadding()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            ListTabMenuScreen()
        }
    }
}