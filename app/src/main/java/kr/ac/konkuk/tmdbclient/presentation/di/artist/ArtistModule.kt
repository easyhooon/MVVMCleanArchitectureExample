package kr.ac.konkuk.tmdbclient.presentation.di.artist

import dagger.Module
import dagger.Provides
import kr.ac.konkuk.tmdbclient.domain.usecase.GetArtistsUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.UpdateArtistsUseCase
import kr.ac.konkuk.tmdbclient.presentation.artist.ArtistViewModelFactory

//ArtistViewModelFactory has two constructor parameters
//GetArtistsUseCase and UpdateArtistsUseCase
//So we need to add them as parameters for this provider
@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun providerArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }
}