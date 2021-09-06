package kr.ac.konkuk.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kr.ac.konkuk.tmdbclient.domain.usecase.GetMoviesUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.UpdateArtistsUseCase
import kr.ac.konkuk.tmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase : UpdateMoviesUseCase
):ViewModel() {

    //This function will invoke execute function of the getMoviesUseCase and emit received list
    //as live data.

    //Since we are using coroutines we will use a live data block here.

    //We are not explicitly provide any dispatcher here. So coroutine will use the Main thread. Since we have

    //used IO thread in the data sources, calling them from the UI thread is the best practice.
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}