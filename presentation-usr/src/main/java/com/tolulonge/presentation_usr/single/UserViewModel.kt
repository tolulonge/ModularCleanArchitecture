package com.tolulonge.presentation_usr.single


import androidx.lifecycle.viewModelScope
import com.tolulonge.domain.usecase.GetUserUseCase
import com.tolulonge.presentation_cmn.state.MviViewModel
import com.tolulonge.presentation_cmn.state.UiSingleEvent
import com.tolulonge.presentation_cmn.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userUseCase: GetUserUseCase,
    private val converter: UserConverter
) : MviViewModel<UserModel, UiState<UserModel>, UserUiAction, UiSingleEvent>() {

    override fun initState(): UiState<UserModel> = UiState.Loading

    override fun handleAction(action: UserUiAction) {
        when (action) {
            is UserUiAction.Load -> {
                loadUser(action.userId)
            }
        }
    }

    private fun loadUser(userId: Long) {
        viewModelScope.launch {
            userUseCase.execute(GetUserUseCase.Request(userId))
                .map {
                    converter.convert(it)
                }
                .collect {
                    submitState(it)
                }
        }
    }
}