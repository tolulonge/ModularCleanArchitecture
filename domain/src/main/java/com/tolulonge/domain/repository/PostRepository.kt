package com.tolulonge.domain.repository
import com.tolulonge.domain.entity.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    fun getPosts(): Flow<List<Post>>

    fun getPost(id: Long): Flow<Post>
}