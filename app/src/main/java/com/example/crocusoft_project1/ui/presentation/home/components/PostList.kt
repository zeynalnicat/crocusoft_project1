package com.example.crocusoft_project1.ui.presentation.home.components

import androidx.compose.runtime.Composable

import com.example.crocusoft_project1.ui.domain.entities.PostEntity
import com.example.crocusoft_project1.ui.presentation.home.HomeContract

@Composable
fun PostList(
    posts: List<PostEntity>,
    postIntent: (HomeContract.Intent) -> Unit,
) {


    posts.forEach { post ->
        PostDetail(
            post = post,
            postIntent = postIntent
        )
        if(post == posts[posts.size-1]){
            postIntent(HomeContract.Intent.OnLoadMore)
        }
    }


}