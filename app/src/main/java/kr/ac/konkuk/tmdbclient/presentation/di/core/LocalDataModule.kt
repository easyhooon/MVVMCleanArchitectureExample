package kr.ac.konkuk.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.ac.konkuk.tmdbclient.data.db.ArtistDao
import kr.ac.konkuk.tmdbclient.data.db.MovieDao
import kr.ac.konkuk.tmdbclient.data.db.TvShowDao
import kr.ac.konkuk.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kr.ac.konkuk.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import kr.ac.konkuk.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kr.ac.konkuk.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import kr.ac.konkuk.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kr.ac.konkuk.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import javax.inject.Singleton


//in this module, we are going to construct and return this MovieLocalDataSourceImpl
@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}