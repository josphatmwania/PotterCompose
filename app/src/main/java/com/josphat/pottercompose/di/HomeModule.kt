package com.josphat.pottercompose.di

import com.josphat.pottercompose.db.dao.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides
    @Singleton
    fun provideNiaNetworkDataSource(): NiaNetworkDataSource {
        return NiaNetworkDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideCharactersRepository(
        harryPotterApi: CharacterApi,
        characterDao: CharacterDao,
        network:NiaNetworkDataSource
    ): CharactersRepository {
        return CharacterRepositoryImpl(
            harryPotterApi = harryPotterApi, characterDao = characterDao,network = network
        )


    }

    class NiaNetworkDataSourceImpl : NiaNetworkDataSource {
        override suspend fun getTopicChangeList(after: Int?): List<NetworkChangeList> {
            TODO("Not yet implemented")
        }

    }
}