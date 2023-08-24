package com.example.dogapp.framework.di

import android.content.Context
import androidx.room.Room
import com.example.dogapp.data.dao.DogBreedsDao
import com.example.dogapp.framework.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "dogyDB"
        ).build()
    }

    @Provides
    fun providedDogBreedsDao(appDatabase: AppDatabase): DogBreedsDao {
        return appDatabase.dogBreedsDao()
    }

}
