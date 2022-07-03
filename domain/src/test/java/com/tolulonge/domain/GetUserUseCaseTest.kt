package com.tolulonge.domain

import com.tolulonge.domain.entity.User
import com.tolulonge.domain.repository.UserRepository
import com.tolulonge.domain.usecase.GetUserUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetUserUseCaseTest {

    private val userRepository = mock<UserRepository>()
    private val useCase = GetUserUseCase(
        mock(),
        userRepository
    )

    @ExperimentalCoroutinesApi
    @Test
    fun testProcess() = runBlockingTest {
        val request = GetUserUseCase.Request(0L)
        val user = User(1L, "name", "username", "email")
        whenever(userRepository.getUser(request.userId)).thenReturn(flowOf(user))
        val response = useCase.process(request).first()
        Assert.assertEquals(GetUserUseCase.Response(user), response)
    }

}