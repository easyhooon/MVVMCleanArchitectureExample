package kr.ac.konkuk.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kr.ac.konkuk.tmdbclient.domain.usecase.GetArtistsUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.GetMoviesUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.UpdateArtistsUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.UpdateMoviesUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase : UpdateArtistsUseCase
): ViewModel(
) {

    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }
}