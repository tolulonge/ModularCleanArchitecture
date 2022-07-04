package com.tolulonge.modularcleanarchitecture.repository

import com.tolulonge.domain.entity.User
import com.tolulonge.domain.repository.UserRepository
import com.tolulonge.modularcleanarchitecture.idling.ComposeCountingIdlingResource
import com.tolulonge.modularcleanarchitecture.idling.attachIdling
import kotlinx.coroutines.flow.Flow

class IdlingUserRepository(
    private val userRepository: UserRepository,
    private val countingIdlingResource: ComposeCountingIdlingResource
) : UserRepository {
    override fun getUsers(): Flow<List<User>> =
        userRepository.getUsers()
            .attachIdling(countingIdlingResource)

    override fun getUser(id: Long): Flow<User> =
        userRepository.getUser(id)
            .attachIdling(countingIdlingResource)
}