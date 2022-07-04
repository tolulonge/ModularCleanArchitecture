package com.tolulonge.data_repository.data_source.repository

import com.tolulonge.data_repository.data_source.local.LocalUserDataSource
import com.tolulonge.data_repository.data_source.remote.RemoteUserDataSource
import com.tolulonge.domain.entity.User
import com.tolulonge.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class UserRepositoryImpl  constructor(
    private val remoteUserDataSource: RemoteUserDataSource,
    private val localUserDataSource: LocalUserDataSource
) : UserRepository {

    override fun getUsers(): Flow<List<User>> = remoteUserDataSource.getUsers()
        .onEach {
            localUserDataSource.addUsers(it)
        }

    override fun getUser(id: Long): Flow<User> = remoteUserDataSource.getUser(id)
        .onEach {
            localUserDataSource.addUsers(listOf(it))
        }

}