package kr.ac.konkuk.tmdbclient.presentation.di.tvshow

import dagger.Module
import dagger.Provides
import kr.ac.konkuk.tmdbclient.domain.usecase.GetTvShowsUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import kr.ac.konkuk.tmdbclient.presentation.tvshow.TvShowViewModelFactory

//ArtistViewModelFactory has two constructor parameters
//GetArtistsUseCase and UpdateArtistsUseCase
//So we need to add them as parameters for this provider
@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun providerTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }
}