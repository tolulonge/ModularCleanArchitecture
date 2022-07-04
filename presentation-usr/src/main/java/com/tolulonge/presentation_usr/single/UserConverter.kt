package com.tolulonge.presentation_usr.single

import android.content.Context
import com.tolulonge.domain.usecase.GetUserUseCase
import com.tolulonge.presentation_cmn.state.CommonResultConverter
import com.tolulonge.presentation_usr.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UserConverter @Inject constructor(@ApplicationContext private val context: Context) :
    CommonResultConverter<GetUserUseCase.Response, UserModel>() {

    override fun convertSuccess(data: GetUserUseCase.Response): UserModel {
        return UserModel(
            context.getString(R.string.name, data.user.name),
            context.getString(R.string.username, data.user.username),
            context.getString(R.string.email, data.user.email)
        )
    }
}