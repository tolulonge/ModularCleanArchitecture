package com.tolulonge.data_repository.data_source.remote

import com.tolulonge.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface RemoteUserDataSource {

    fun getUsers(): Flow<List<User>>

    fun getUser(id: Long): Flow<User>
}