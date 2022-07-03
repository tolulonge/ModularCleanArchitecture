package com.tolulonge.data_repository.data_source.local

import com.tolulonge.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface LocalUserDataSource {

    fun getUsers(): Flow<List<User>>

    suspend fun addUsers(users: List<User>)
}