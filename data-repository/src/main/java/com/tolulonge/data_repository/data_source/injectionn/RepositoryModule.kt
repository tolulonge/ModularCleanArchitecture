package com.tolulonge.data_repository.data_source.injectionn

import com.tolulonge.data_repository.data_source.repository.InteractionRepositoryImpl
import com.tolulonge.data_repository.data_source.repository.PostRepositoryImpl
import com.tolulonge.data_repository.data_source.repository.UserRepositoryImpl
import com.tolulonge.domain.repository.InteractionRepository
import com.tolulonge.domain.repository.PostRepository
import com.tolulonge.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPostRepository(postRepositoryImpl: PostRepositoryImpl): PostRepository

    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindInteractionRepository(interactionRepositoryImpl: InteractionRepositoryImpl): InteractionRepository
}