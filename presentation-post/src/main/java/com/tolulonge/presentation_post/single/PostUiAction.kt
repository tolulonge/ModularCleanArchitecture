package com.tolulonge.presentation_post.single

import com.tolulonge.presentation_cmn.state.UiAction

sealed class PostUiAction : UiAction {

    data class Load(val postId: Long) : PostUiAction()
}