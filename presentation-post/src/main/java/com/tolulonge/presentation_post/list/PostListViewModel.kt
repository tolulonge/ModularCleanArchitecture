package com.tolulonge.presentation_post.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tolulonge.domain.entity.Interaction
import com.tolulonge.domain.usecase.GetPostsWithUsersWithInteractionUseCase
import com.tolulonge.domain.usecase.UpdateInteractionUseCase
import com.tolulonge.presentation_cmn.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(
    private val useCase: GetPostsWithUsersWithInteractionUseCase,
    private val converter: PostListConverter,
    private val updateInteractionUseCase: UpdateInteractionUseCase
) : ViewModel() {

    private val _postListFlow =
        MutableStateFlow<UiState<PostListModel>>(UiState.Loading)
    val postListFlow: StateFlow<UiState<PostListModel>> = _postListFlow

    fun loadPosts() {
        viewModelScope.launch {
            useCase.execute(GetPostsWithUsersWithInteractionUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    _postListFlow.value = it
                }
        }
    }

    fun updateInteraction(interaction: Interaction) {
        viewModelScope.launch {
            updateInteractionUseCase.execute(
                UpdateInteractionUseCase.Request(
                    interaction.copy(
                        totalClicks = interaction.totalClicks + 1
                    )
                )
            ).collect()
        }
    }
}