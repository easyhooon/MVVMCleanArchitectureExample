package kr.ac.konkuk.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.ac.konkuk.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import kr.ac.konkuk.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import kr.ac.konkuk.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kr.ac.konkuk.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import kr.ac.konkuk.tmdbclient.data.repository.movie.MovieRepositoryImpl
import kr.ac.konkuk.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import kr.ac.konkuk.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kr.ac.konkuk.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import kr.ac.konkuk.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import kr.ac.konkuk.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import kr.ac.konkuk.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kr.ac.konkuk.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import kr.ac.konkuk.tmdbclient.domain.repository.ArtistRepository
import kr.ac.konkuk.tmdbclient.domain.repository.MovieRepository
import kr.ac.konkuk.tmdbclient.domain.repository.TvShowRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
    movieRemoteDataSource: MovieRemoteDataSource,
    movieLocalDataSource: MovieLocalDataSource,
    movieCacheDataSource: MovieCacheDataSource
    ):MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}