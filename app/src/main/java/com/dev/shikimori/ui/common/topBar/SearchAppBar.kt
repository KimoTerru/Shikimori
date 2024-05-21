package com.dev.shikimori.ui.common.topBar

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dev.shikimori.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    searchText: String,
    showTrailingIcon: Boolean = false,
    trailingIcon: Int = R.drawable.close,
    placeholderText: Int,
    onClickTrailingIcon: () -> Unit = {},
    onClickImeAction: (String) -> Unit = {},
    onChangedText: (String) -> Unit = {},
    clearText: () -> Unit = {}
) {
    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        query = searchText,
        onQueryChange = onChangedText,
        onSearch = onClickImeAction,
        placeholder = {
            Text(
                text = stringResource(id = placeholderText)
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search_outlined),
                contentDescription = null
            )
        },
        trailingIcon = {
            if (searchText.isEmpty() and showTrailingIcon) {
                IconButton(
                    onClick = {
                        onClickTrailingIcon.invoke()
                    }
                ) {
                    Icon(
                        painter = painterResource(
                            id = trailingIcon
                        ),
                        contentDescription = null
                    )
                }
            } else if (searchText.isNotEmpty()) {
                IconButton(
                    onClick = clearText
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.close
                        ),
                        contentDescription = null
                    )
                }
            } else {
                Spacer(modifier = Modifier.size(0.dp))
            }
        },
        active = false,
        onActiveChange = {},
        content = {}
    )
}