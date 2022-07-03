package com.tolulonge.presentation_post.list

data class PostListModel(
    val headerText: String = "",
    val items: List<PostListItemModel> = listOf()
)

data class PostListItemModel(
    val id: Long,
    val userId: Long,
    val authorName: String,
    val title: String
)