package kr.ac.konkuk.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.ac.konkuk.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import kr.ac.konkuk.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import kr.ac.konkuk.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import kr.ac.konkuk.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import kr.ac.konkuk.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import kr.ac.konkuk.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}