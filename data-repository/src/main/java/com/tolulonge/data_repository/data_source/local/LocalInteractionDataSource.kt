package com.tolulonge.data_repository.data_source.local

import com.tolulonge.domain.entity.Interaction
import kotlinx.coroutines.flow.Flow

interface LocalInteractionDataSource {

    fun getInteraction(): Flow<Interaction>

    suspend fun saveInteraction(interaction: Interaction)
}