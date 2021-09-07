package kr.ac.konkuk.tmdbclient.presentation.di.core

import dagger.Module
import dagger.Provides
import kr.ac.konkuk.tmdbclient.domain.repository.ArtistRepository
import kr.ac.konkuk.tmdbclient.domain.repository.MovieRepository
import kr.ac.konkuk.tmdbclient.domain.repository.TvShowRepository
import kr.ac.konkuk.tmdbclient.domain.usecase.*

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)

    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository):GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowRepository)

    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository):GetArtistsUseCase{
        return GetArtistsUseCase(artistRepository)

    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistRepository)
    }
}