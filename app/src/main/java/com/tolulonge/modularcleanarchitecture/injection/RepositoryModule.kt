package com.tolulonge.modularcleanarchitecture.injection

import com.tolulonge.data_repository.data_source.local.LocalInteractionDataSource
import com.tolulonge.data_repository.data_source.local.LocalPostDataSource
import com.tolulonge.data_repository.data_source.local.LocalUserDataSource
import com.tolulonge.data_repository.data_source.remote.RemotePostDataSource
import com.tolulonge.data_repository.data_source.remote.RemoteUserDataSource
import com.tolulonge.data_repository.data_source.repository.InteractionRepositoryImpl
import com.tolulonge.data_repository.data_source.repository.PostRepositoryImpl
import com.tolulonge.data_repository.data_source.repository.UserRepositoryImpl
import com.tolulonge.domain.repository.InteractionRepository
import com.tolulonge.domain.repository.PostRepository
import com.tolulonge.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun providePostRepository(
        remotePostDataSource: RemotePostDataSource,
        localPostDataSource: LocalPostDataSource
    ): PostRepository = PostRepositoryImpl(
        remotePostDataSource,
        localPostDataSource
    )

    @Provides
    fun provideUserRepository(
        remoteUserDataSource: RemoteUserDataSource,
        localUserDataSource: LocalUserDataSource
    ): UserRepository = UserRepositoryImpl(
        remoteUserDataSource,
        localUserDataSource
    )

    @Provides
    fun provideInteractionRepository(
        interactionDataSource: LocalInteractionDataSource
    ): InteractionRepository = InteractionRepositoryImpl(
        interactionDataSource
    )
}