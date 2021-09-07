package kr.ac.konkuk.tmdbclient.presentation.di.movie

import dagger.Module
import dagger.Provides
import kr.ac.konkuk.tmdbclient.domain.usecase.GetMoviesUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.UpdateMoviesUseCase
import kr.ac.konkuk.tmdbclient.presentation.movie.MovieViewModelFactory

//ArtistViewModelFactory has two constructor parameters
//GetArtistsUseCase and UpdateArtistsUseCase
//So we need to add them as parameters for this provider
@Module
class MovieModule {

    @MovieScope
    @Provides
    fun providerMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}