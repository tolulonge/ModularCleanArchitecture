package com.tolulonge.presentation_post.list

import com.tolulonge.domain.entity.Interaction
import com.tolulonge.presentation_cmn.state.UiAction

sealed class PostListUiAction : UiAction {

    object Load : PostListUiAction()
    data class UserClick(val userId: Long, val interaction: Interaction) : PostListUiAction()
    data class PostClick(val postId: Long, val interaction: Interaction) : PostListUiAction()
}