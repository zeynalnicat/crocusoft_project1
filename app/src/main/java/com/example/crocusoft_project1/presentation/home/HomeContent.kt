package com.example.crocusoft_project1.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.crocusoft_project1.R
import com.example.crocusoft_project1.core.Colors
import com.example.crocusoft_project1.core.DsTheme
import com.example.crocusoft_project1.presentation.home.components.DAppbar
import com.example.crocusoft_project1.presentation.home.components.PostList
import com.example.crocusoft_project1.presentation.home.components.StoryList


@Composable
fun HomeContent(
    innerPadding: PaddingValues,
    state: HomeContract.State,
    postIntent: (HomeContract.Intent) -> Unit,
) {

    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) {
        postIntent(HomeContract.Intent.OnFetchStories)
        postIntent(HomeContract.Intent.OnFetchPosts)
    }


    Scaffold(
        modifier = Modifier.padding(innerPadding),
        topBar = { DAppbar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)

        ) {
            Spacer(modifier = Modifier.height(height = DsTheme.dimens.dp2))
            StoryList(
                stories = state.stories
            )
            Spacer(modifier = Modifier.height(height = DsTheme.dimens.dp2))

            HorizontalDivider(
                thickness = DsTheme.dimens.dpHalf,
                color = colorResource(Colors.shadow).copy(alpha = 0.6f)
            )

            Spacer(modifier = Modifier.height(height = DsTheme.dimens.dp2))

            PostList(
                posts = state.posts,
                postIntent = postIntent
            )
        }
    }
}