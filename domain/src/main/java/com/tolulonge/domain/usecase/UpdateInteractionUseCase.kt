package com.tolulonge.domain.usecase

import com.tolulonge.domain.entity.Interaction
import com.tolulonge.domain.repository.InteractionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UpdateInteractionUseCase @Inject constructor(
    configuration: Configuration,
    private val interactionRepository: InteractionRepository
) : UseCase<UpdateInteractionUseCase.Request, UpdateInteractionUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> {
        return interactionRepository.saveInteraction(request.interaction)
            .map {
                Response
            }
    }

    data class Request(val interaction: Interaction) : UseCase.Request

    object Response : UseCase.Response
}