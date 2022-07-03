package com.tolulonge.data_remote.networking.injection

import com.tolulonge.data_remote.networking.source.RemotePostDataSourceImpl
import com.tolulonge.data_remote.networking.source.RemoteUserDataSourceImpl
import com.tolulonge.data_repository.data_source.remote.RemotePostDataSource
import com.tolulonge.data_repository.data_source.remote.RemoteUserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindPostDataSource(postDataSourceImpl: RemotePostDataSourceImpl): RemotePostDataSource

    @Binds
    abstract fun bindUserDataSource(userDataSourceImpl: RemoteUserDataSourceImpl): RemoteUserDataSource
}