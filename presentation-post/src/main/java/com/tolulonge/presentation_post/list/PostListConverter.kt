package com.tolulonge.presentation_post.list

import android.content.Context
import com.tolulonge.domain.entity.Result
import com.tolulonge.domain.usecase.GetPostsWithUsersWithInteractionUseCase
import com.tolulonge.presentation_cmn.state.CommonResultConverter
import com.tolulonge.presentation_cmn.state.UiState
import com.tolulonge.presentation_post.R


import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PostListConverter @Inject constructor(@ApplicationContext private val context: Context)
    : CommonResultConverter<GetPostsWithUsersWithInteractionUseCase.Response, PostListModel>() {

    override fun convertSuccess(data: GetPostsWithUsersWithInteractionUseCase.Response): PostListModel {
        return PostListModel(
            headerText = context.getString(
                R.string.total_click_count,
                data.interaction.totalClicks
            ),
            items = data.posts.map {
                PostListItemModel(
                    it.post.id,
                    it.user.id,
                    context.getString(R.string.author, it.user.name),
                    context.getString(R.string.title, it.post.title)
                )
            },
            interaction = data.interaction
        )
    }
}