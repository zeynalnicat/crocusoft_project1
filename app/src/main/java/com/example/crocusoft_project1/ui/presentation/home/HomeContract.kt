package com.example.crocusoft_project1.ui.presentation.home

import com.example.crocusoft_project1.ui.domain.entities.PostEntity
import com.example.crocusoft_project1.ui.domain.entities.StoryEntity

sealed interface HomeContract {

    sealed interface Intent {
        data object OnFetchStories : Intent

        data object OnFetchPosts : Intent


        data object OnToggleMore : Intent

        data class OnLikePost(val postEntity: PostEntity) : Intent

        data object OnComment : Intent

        data class OnShare(val postEntity: PostEntity) : Intent

        data class OnSave(val postEntity: PostEntity) : Intent

        data object OnLoadMore: Intent

    }


    data class State(
        val stories: List<StoryEntity> = emptyList(),
        val posts: List<PostEntity> = emptyList(),
        val page: Int = 0,
        val size: Int = 5,

    )
}