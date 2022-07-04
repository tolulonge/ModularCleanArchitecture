package com.tolulonge.presentation_usr.single

import com.tolulonge.presentation_cmn.state.UiAction

sealed class UserUiAction : UiAction {
    data class Load(val userId: Long) : UserUiAction()
}