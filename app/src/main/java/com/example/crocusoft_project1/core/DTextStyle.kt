package com.example.crocusoft_project1.core

import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

import com.example.crocusoft_project1.core.theme.White


object DTextStyle {

    val tTitle = TextStyle(
        fontSize = DsTheme.dimens.sp8,
        fontWeight = FontWeight.W700
    )

    val t12 = TextStyle(
        fontSize = DsTheme.dimens.sp1,
        fontWeight = FontWeight.W400,
    )

    val t12White = TextStyle(
        fontSize = DsTheme.dimens.sp1,
        color = White,
        fontWeight = FontWeight.W400,
    )

    val t14Bold = TextStyle(
        fontSize = DsTheme.dimens.sp2,
        fontWeight = FontWeight.W600
    )

    val t12Gray = TextStyle(
        fontSize = DsTheme.dimens.sp1,
        fontWeight = FontWeight.W400,
        color = Gray
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