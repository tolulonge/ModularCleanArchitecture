package com.tolulonge.modularcleanarchitecture.repository


import com.tolulonge.domain.entity.Interaction
import com.tolulonge.domain.repository.InteractionRepository
import com.tolulonge.modularcleanarchitecture.idling.ComposeCountingIdlingResource
import com.tolulonge.modularcleanarchitecture.idling.attachIdling
import kotlinx.coroutines.flow.Flow

class IdlingInteractionRepository(
    private val interactionRepository: InteractionRepository,
    private val countingIdlingResource: ComposeCountingIdlingResource
) : InteractionRepository {

    override fun getInteraction(): Flow<Interaction> {
        return interactionRepository.getInteraction()
            .attachIdling(countingIdlingResource)
    }

    override fun saveInteraction(interaction: Interaction): Flow<Interaction> {
        return interactionRepository.saveInteraction(interaction)
            .attachIdling(countingIdlingResource)
    }
}