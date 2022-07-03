package com.tolulonge.domain

import com.tolulonge.domain.entity.Interaction
import com.tolulonge.domain.repository.InteractionRepository
import com.tolulonge.domain.usecase.UpdateInteractionUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class UpdateInteractionUseCaseTest {

    private val interactionRepository = mock<InteractionRepository>()
    private val useCase = UpdateInteractionUseCase(
        mock(),
        interactionRepository
    )

    @ExperimentalCoroutinesApi
    @Test
    fun testProcess() = runBlockingTest {
        val interaction = Interaction(10)
        val request = UpdateInteractionUseCase.Request(interaction)
        whenever(interactionRepository.saveInteraction(interaction)).thenReturn(flowOf(interaction))
        val response = useCase.process(request).first()
        Assert.assertEquals(UpdateInteractionUseCase.Response, response)
    }


}