package com.example.dogapp.framework.di

import com.example.dogapp.data.datasource.BreedsLocalSource
import com.example.dogapp.data.datasource.BreedsRemoteSource
import com.example.dogapp.data.datasource.DogsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providerDogsRepository(
        remote: BreedsRemoteSource,
        local: BreedsLocalSource): DogsRepository {
        return DogsRepository(remote,local)
    }

}