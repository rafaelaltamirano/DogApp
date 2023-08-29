package com.example.dogapp.framework.di

import com.example.dogapp.framework.api.DogsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun providesDogsApi(client: OkHttpClient): DogsApi {
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
        client.also(builder::client)
        return builder.build().create(DogsApi::class.java)
    }


//    @Provides
//    @Singleton
//    fun provideRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(url)
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun createClient(): OkHttpClient {
//        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
//            val loggingInterceptor =
//                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
//            okHttpClientBuilder.addInterceptor(loggingInterceptor)
//
//        return okHttpClientBuilder.build()
//    }
//
//    @Singleton
//    @Provides
//    fun providesDogsApi(retrofit: Retrofit): DogsApi {
//        return retrofit.create(DogsApi::class.java)
//    }
}