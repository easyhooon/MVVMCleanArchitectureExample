package kr.ac.konkuk.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.ac.konkuk.tmdbclient.domain.usecase.GetMoviesUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.GetTvShowsUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.UpdateMoviesUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import kr.ac.konkuk.tmdbclient.presentation.movie.MovieViewModel

class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }

}