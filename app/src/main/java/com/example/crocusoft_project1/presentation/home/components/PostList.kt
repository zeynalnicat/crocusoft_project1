package com.example.crocusoft_project1.presentation.home.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

import com.example.crocusoft_project1.domain.entities.PostEntity
import com.example.crocusoft_project1.presentation.home.HomeContract

@Composable
fun PostList(
    posts: List<PostEntity>,
    state: HomeContract.State,
    postIntent: (HomeContract.Intent) -> Unit,
) {


    posts.forEach { post ->
        PostDetail(
            post = post,
            postIntent = postIntent,
            isLiked = state.likedPosts.contains(post)
        )
        if (post == posts[posts.size - 1]) {
            postIntent(HomeContract.Intent.OnLoadMore)
        }
    }


}