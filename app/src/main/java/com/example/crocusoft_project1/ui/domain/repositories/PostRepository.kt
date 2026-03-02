package com.example.crocusoft_project1.ui.domain.repositories

import com.example.crocusoft_project1.ui.domain.entities.PostEntity

interface PostRepository {

    fun fetchPosts(page:Int,size:Int): List<PostEntity>
}