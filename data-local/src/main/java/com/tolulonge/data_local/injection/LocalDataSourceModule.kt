package com.tolulonge.data_local.injection

import com.tolulonge.data_local.source.LocalInteractionDataSourceImpl
import com.tolulonge.data_local.source.LocalPostDataSourceImpl
import com.tolulonge.data_local.source.LocalUserDataSourceImpl
import com.tolulonge.data_repository.data_source.local.LocalInteractionDataSource
import com.tolulonge.data_repository.data_source.local.LocalPostDataSource
import com.tolulonge.data_repository.data_source.local.LocalUserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindPostDataSource(lostDataSourceImpl: LocalPostDataSourceImpl): LocalPostDataSource

    @Binds
    abstract fun bindUserDataSource(userDataSourceImpl: LocalUserDataSourceImpl): LocalUserDataSource

    @Binds
    abstract fun bindInteractionDataStore(interactionDataStore: LocalInteractionDataSourceImpl): LocalInteractionDataSource
}