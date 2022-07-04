package com.tolulonge.domain.usecase

import com.tolulonge.domain.entity.Post
import com.tolulonge.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetPostUseCase (
    configuration: Configuration,
    private val postRepository: PostRepository
) : UseCase<GetPostUseCase.Request, GetPostUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        postRepository.getPost(request.postId)
            .map {
                Response(it)
            }

    data class Request(val postId: Long) : UseCase.Request
    data class Response(val post: Post) : UseCase.Response
}