package com.tolulonge.domain.repository

import com.tolulonge.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUsers(): Flow<List<User>>

    fun getUser(id: Long): Flow<User>
}