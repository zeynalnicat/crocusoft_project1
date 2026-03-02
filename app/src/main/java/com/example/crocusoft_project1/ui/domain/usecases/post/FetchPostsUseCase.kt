package com.example.crocusoft_project1.ui.domain.usecases.post

import com.example.crocusoft_project1.ui.domain.entities.PostEntity
import com.example.crocusoft_project1.ui.domain.repositories.PostRepository

class FetchPostsUseCase(
    private val postRepository: PostRepository

) {

    operator fun invoke(page: Int, size: Int): List<PostEntity> {
        return postRepository.fetchPosts(page, size)

    }
}