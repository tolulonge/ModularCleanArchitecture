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
import com.tolulonge.modularcleanarchitecture.idling.ComposeCountingIdlingResource
import com.tolulonge.modularcleanarchitecture.repository.IdlingInteractionRepository
import com.tolulonge.modularcleanarchitecture.repository.IdlingPostRepository
import com.tolulonge.modularcleanarchitecture.repository.IdlingUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepositoryModule::class]
)
class IdlingRepositoryModule {

    @Singleton
    @Provides
    fun provideIdlingResource(): ComposeCountingIdlingResource =
        ComposeCountingIdlingResource("repository-idling")

    @Provides
    fun providePostRepository(
        remotePostDataSource: RemotePostDataSource,
        localPostDataSource: LocalPostDataSource,
        countingIdlingResource: ComposeCountingIdlingResource
    ): PostRepository = IdlingPostRepository(
        PostRepositoryImpl(
            remotePostDataSource,
            localPostDataSource
        ),
        countingIdlingResource
    )

    @Provides
    fun provideUserRepository(
        remoteUserDataSource: RemoteUserDataSource,
        localUserDataSource: LocalUserDataSource,
        countingIdlingResource: ComposeCountingIdlingResource
    ): UserRepository = IdlingUserRepository(
        UserRepositoryImpl(
            remoteUserDataSource,
            localUserDataSource
        ),
        countingIdlingResource
    )

    @Provides
    fun provideInteractionRepository(
        interactionDataSource: LocalInteractionDataSource,
        countingIdlingResource: ComposeCountingIdlingResource
    ): InteractionRepository = IdlingInteractionRepository(
        InteractionRepositoryImpl(
            interactionDataSource
        ),
        countingIdlingResource
    )
}