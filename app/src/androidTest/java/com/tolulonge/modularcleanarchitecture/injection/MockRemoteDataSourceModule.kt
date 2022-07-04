package com.tolulonge.modularcleanarchitecture.injection

import com.tolulonge.data_remote.networking.injection.RemoteDataSourceModule
import com.tolulonge.data_repository.data_source.remote.RemotePostDataSource
import com.tolulonge.data_repository.data_source.remote.RemoteUserDataSource
import com.tolulonge.modularcleanarchitecture.remote.MockRemotePostDataSource
import com.tolulonge.modularcleanarchitecture.remote.MockRemoteUserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RemoteDataSourceModule::class]
)
abstract class MockRemoteDataSourceModule {

    @Binds
    abstract fun bindPostDataSource(postDataSourceImpl: MockRemotePostDataSource): RemotePostDataSource

    @Binds
    abstract fun bindUserDataSource(userDataSourceImpl: MockRemoteUserDataSource): RemoteUserDataSource
}