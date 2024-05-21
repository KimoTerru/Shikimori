package com.dev.shikimori.ui.common.bottomBar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dev.shikimori.R
import com.dev.shikimori.ui.route.NavigationRouts

private val listTab = TabBarItem(
    titleRoute = NavigationRouts.Main.Home.route,
    titleName = R.string.list,
    selectedIcon = R.drawable.list_outlined,
    unselectedIcon = R.drawable.list_outlined
)

private val calendarTab = TabBarItem(
    titleRoute = NavigationRouts.Main.Calendar.route,
    titleName = R.string.calendar,
    selectedIcon = R.drawable.calendar_filled,
    unselectedIcon = R.drawable.calendar_outlined,
    badgeAmount = 7
)

private val searchTab = TabBarItem(
    titleRoute = NavigationRouts.Main.Search.route,
    titleName = R.string.search,
    selectedIcon = R.drawable.search_filled,
    unselectedIcon = R.drawable.search_outlined
)

private val newsTab = TabBarItem(
    titleRoute = NavigationRouts.Main.News.route,
    titleName = R.string.news,
    selectedIcon = R.drawable.news_outlined,
    unselectedIcon = R.drawable.news_outlined
)

private val profileTab = TabBarItem(
    titleRoute = NavigationRouts.Main.Profile.route,
    titleName = R.string.profile,
    selectedIcon = R.drawable.account_outlined,
    unselectedIcon = R.drawable.account_outlined
)

private val mainTabBarItems = listOf(
    listTab,
    calendarTab,
    searchTab,
    newsTab,
    profileTab
)

private data class TabBarItem(
    val titleRoute: String,
    val titleName: Int,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val badgeAmount: Int? = null
)

@Composable
fun MainBottomMenuNavigation(
    navController: NavController,
    bottomBarState: MutableState<Boolean>
) {

    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            NavigationBar {
                mainTabBarItems.forEachIndexed { index, tabBarItem ->
                    NavigationBarItem(
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                            navController.navigate(tabBarItem.titleRoute) {
                                /*popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true*/
                            }
                        },
                        icon = {
                            TabBarIconView(
                                isSelected = selectedTabIndex == index,
                                selectedIcon = tabBarItem.selectedIcon,
                                unselectedIcon = tabBarItem.unselectedIcon,
                                titleTranslate = tabBarItem.titleName,
                                badgeAmount = tabBarItem.badgeAmount
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = tabBarItem.titleName),
                                fontSize = 12.sp,
                                fontWeight = if (selectedTabIndex == index) {
                                    FontWeight.Bold
                                } else {
                                    FontWeight.Normal
                                }
                            )
                        }
                    )
                }
            }
        }
    )
}

@Composable
private fun TabBarIconView(
    isSelected: Boolean,
    selectedIcon: Int,
    unselectedIcon: Int,
    titleTranslate: Int,
    badgeAmount: Int? = null
) {
    BadgedBox(badge = { TabBarBadgeView(badgeAmount) }) {
        Icon(
            painter = if (isSelected) {
                painterResource(id = selectedIcon)
            } else {
                painterResource(id = unselectedIcon)
            },
            contentDescription = stringResource(id = titleTranslate)
        )
    }
}

@Composable
private fun TabBarBadgeView(count: Int? = null) {
    if (count != null) {
        Badge {
            Text(count.toString())
        }
    }
}