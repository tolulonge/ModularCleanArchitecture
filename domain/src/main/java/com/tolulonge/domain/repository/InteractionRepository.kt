package com.tolulonge.domain.repository

import com.tolulonge.domain.entity.Interaction
import kotlinx.coroutines.flow.Flow

interface InteractionRepository {

    fun getInteraction(): Flow<Interaction>

    fun saveInteraction(interaction: Interaction): Flow<Interaction>
}