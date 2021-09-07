package kr.ac.konkuk.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.ac.konkuk.tmdbclient.data.api.TMDBService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// This module provides two dependencies . Retrofit instance and TMDB Service instance

@Module
class NetModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit):TMDBService {
        return retrofit.create(TMDBService::class.java)
    }

}