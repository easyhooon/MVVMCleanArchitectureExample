package kr.ac.konkuk.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kr.ac.konkuk.tmdbclient.domain.usecase.GetArtistsUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.GetTvShowsUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.UpdateArtistsUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase : UpdateTvShowsUseCase
): ViewModel() {

    fun getTvShows() = liveData {
        val movieList = getTvShowsUseCase.execute()
        emit(movieList)
    }

    fun updateTvShows() = liveData {
        val movieList = updateTvShowsUseCase.execute()
        emit(movieList)
    }
}