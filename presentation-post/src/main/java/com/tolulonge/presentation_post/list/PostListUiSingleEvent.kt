package com.tolulonge.presentation_post.list

import com.tolulonge.presentation_cmn.state.UiSingleEvent

sealed class PostListUiSingleEvent : UiSingleEvent {
    data class OpenUserScreen(val navRoute: String) : PostListUiSingleEvent()
    data class OpenPostScreen(val navRoute: String) : PostListUiSingleEvent()
}