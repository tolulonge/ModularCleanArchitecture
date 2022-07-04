package com.tolulonge.presentation_post.single
import android.content.Context
import com.tolulonge.domain.usecase.GetPostUseCase
import com.tolulonge.presentation_cmn.state.CommonResultConverter
import com.tolulonge.presentation_post.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PostConverter @Inject constructor(@ApplicationContext private val context: Context) :
    CommonResultConverter<GetPostUseCase.Response, PostModel>() {

    override fun convertSuccess(data: GetPostUseCase.Response): PostModel {
        return PostModel(
            context.getString(R.string.title, data.post.title),
            context.getString(R.string.body, data.post.body)
        )
    }
}