package kr.ac.konkuk.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.ac.konkuk.tmdbclient.domain.usecase.GetArtistsUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.GetMoviesUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.UpdateArtistsUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.UpdateMoviesUseCase
import kr.ac.konkuk.tmdbclient.presentation.movie.MovieViewModel

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}