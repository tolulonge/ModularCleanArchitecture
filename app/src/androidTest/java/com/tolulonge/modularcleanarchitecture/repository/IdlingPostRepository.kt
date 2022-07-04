package com.tolulonge.modularcleanarchitecture.repository

import com.tolulonge.domain.entity.Post
import com.tolulonge.domain.repository.PostRepository
import com.tolulonge.modularcleanarchitecture.idling.ComposeCountingIdlingResource
import com.tolulonge.modularcleanarchitecture.idling.attachIdling
import kotlinx.coroutines.flow.Flow

class IdlingPostRepository(
    private val postRepository: PostRepository,
    private val countingIdlingResource: ComposeCountingIdlingResource
) : PostRepository {
    override fun getPosts(): Flow<List<Post>> =
        postRepository.getPosts().attachIdling(countingIdlingResource)

    override fun getPost(id: Long): Flow<Post> =
        postRepository.getPost(id).attachIdling(countingIdlingResource)
}