package com.example.dogapp.framework.di

import com.example.dogapp.data.datasource.BreedsLocalSource
import com.example.dogapp.data.datasource.BreedsRemoteSource
import com.example.dogapp.framework.datasource.dogs.BreedsLocalSourceImp
import com.example.dogapp.framework.datasource.dogs.BreedsRemoteSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindBreedsLocalSource(imp: BreedsLocalSourceImp): BreedsLocalSource

    @Binds
    @Singleton
    abstract fun bindBreedsRemoteSource(imp: BreedsRemoteSourceImp): BreedsRemoteSource

}