package com.example.crocusoft_project1.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.crocusoft_project1.R
import com.example.crocusoft_project1.core.Drawables
import com.example.crocusoft_project1.core.DsTheme
import com.example.crocusoft_project1.core.Strings


@Composable
fun DAppbar(
    modifier: Modifier = Modifier,
    suffixActionLeft: () -> Unit = {},
    suffixActionRight: () -> Unit = {},
    prefixAction: () -> Unit = {}
) {


    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = DsTheme.dimens.dp3)

    ) {

        DIconButton(Drawables.shape) { prefixAction() }

        Text(
            text = stringResource(id = Strings.title),
            style = DsTheme.textStyle.tTitle

        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(DsTheme.dimens.dp4)
        ) {

            DIconButton(Drawables.igtv) { suffixActionLeft() }

            DIconButton(Drawables.messanger) { suffixActionRight() }

        }

    }

}