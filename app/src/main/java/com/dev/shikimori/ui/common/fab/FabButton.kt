package com.dev.shikimori.ui.common.fab

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun FabButton(
    outPadding: PaddingValues,
    iconButton: Int,
    textButton: Int,
    onClick: () -> Unit
) {
    ExtendedFloatingActionButton(
        modifier = Modifier.padding(outPadding),
        text = {
            Text(
                text = stringResource(id = textButton)
            )
        },
        icon = {
            Icon(
                painter = painterResource(id = iconButton),
                contentDescription = null
            )
        },
        onClick = {
            onClick.invoke()
        }
    )
}