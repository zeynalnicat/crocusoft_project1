package com.example.crocusoft_project1.ui.core

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

import com.example.crocusoft_project1.ui.theme.White


object DTextStyle {

    val tTitle = TextStyle(
        fontSize = DsTheme.dimens.sp8,
        fontWeight = FontWeight.W700
    )

    val t12 = TextStyle(
        fontSize = DsTheme.dimens.sp1,
        fontWeight = FontWeight.W400,
    )

    val t12Bold =
        TextStyle(
            fontSize = DsTheme.dimens.sp1,
            fontWeight = FontWeight.W600,
        )

    val t8White = TextStyle(
        fontSize = DsTheme.dimens.sp0,
        fontWeight = FontWeight.W500,
        color = White

    )

}