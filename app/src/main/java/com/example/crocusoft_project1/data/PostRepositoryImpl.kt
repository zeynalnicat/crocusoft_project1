package com.example.crocusoft_project1.data

import com.example.crocusoft_project1.domain.entities.PostEntity
import com.example.crocusoft_project1.domain.repositories.PostRepository
import jakarta.inject.Inject


class PostRepositoryImpl @Inject constructor() : PostRepository {


    override fun fetchPosts(page: Int, size: Int): List<PostEntity> {
        val start = page * size
        val end = start + size

        return (18..35)
            .drop(start)
            .take(end)
            .map {
                PostEntity(
                    id = it.toString(),
                    username = it.toString(),
                    contents = if (it % 2 == 0) listOf(
                        "https://picsum.photos/200/300",
                        "https://picsum.photos/200/300,"
                    ) else listOf("https://picsum.photos/200/300"),
                    location = "Baku, Azerbaijan",
                    description = "A beautiful sunset over the mountains in Azerbaijan. Follow me to stay tuned with latest updates ",
                    date = "14 December",
                    userUri = "https://i.pinimg.com/236x/07/01/66/070166623e835c5421388e5278ca8c9a.jpg"
                )
            }
    }
}